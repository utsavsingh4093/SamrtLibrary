package com.logic.datepicker;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.BookUserDAO;
import com.dao.IssueBookDAO;
import com.dto.BookUser;
import com.dto.IssueBookDTO;

public class BookIssueChecker {
	
	public static boolean dateChecking(String issueDate, String returnDate, int bookId, int initialQuantity) {
	 
		List<IssueBookDTO> list = IssueBookDAO.fetchDates(bookId);
	    Map<LocalDate, Integer> dailyBookUsage = new HashMap<>();

	    for (IssueBookDTO issueBookDTO : list) {
	        LocalDate start = LocalDate.parse(issueBookDTO.getIssueDate());
	        LocalDate end = LocalDate.parse(issueBookDTO.getReturnDate());

	        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
	            dailyBookUsage.put(date, dailyBookUsage.getOrDefault(date, 0) + 1);
	        }
	    }

	    LocalDate newIssueDate = LocalDate.parse(issueDate);
	    LocalDate newReturnDate = LocalDate.parse(returnDate);
	    System.out.println("Your issue Date is : " + issueDate + " Your Return Date is : " + returnDate + "\n");

	    int availableBooks = initialQuantity;
	    boolean isAvailable = true;

	    for (LocalDate date = newIssueDate; !date.isAfter(newReturnDate); date = date.plusDays(1)) {
	        int usedBooks = dailyBookUsage.getOrDefault(date, 0);
	        if (usedBooks >= availableBooks) {
	            System.out.println("Not enough books available on: " + date);
	            isAvailable = false;
	            break;
	        }
	    }

	    if (isAvailable) {
	        for (LocalDate date = newIssueDate; !date.isAfter(newReturnDate); date = date.plusDays(1)) {
	            dailyBookUsage.put(date, dailyBookUsage.getOrDefault(date, 0) + 1);
	        }
	        System.out.println("Request accommodated. Books available after request: " + availableBooks);
	    }

	    return isAvailable;
	}
	
//---------------------------------------------------------------------------------------------------
	
	public static boolean renewBook(int bookId, String currentReturnDateStr, String newReturnDateStr) {

       List<IssueBookDTO> list = IssueBookDAO.fetchDates(bookId);
   	    
   	    LocalDate newIssueDate = LocalDate.parse(currentReturnDateStr);
   	    LocalDate newReturnDate = LocalDate.parse(newReturnDateStr);

   	    List<BookUser> bookList = BookUserDAO.fetchAllBooks();
   	    int availableQuantity = 0;

   	    for (BookUser bookUser : bookList) {
   	        if (bookUser.getId() == bookId) { 
   	            availableQuantity = Integer.parseInt(bookUser.getQuantity());
   	            break;
   	        }
   	    }

         if (list.isEmpty()) {
             return true;
         }

         for (IssueBookDTO issueBookDTO : list) {
   	        LocalDate existingIssueDate = LocalDate.parse(issueBookDTO.getIssueDate());
   	        LocalDate existingReturnDate = LocalDate.parse(issueBookDTO.getReturnDate());
   	        
   	     if (availableQuantity >0 || availableQuantity < 0 || availableQuantity == 0) {
   	        if (newIssueDate.isBefore(existingReturnDate) && newReturnDate.isAfter(existingIssueDate)) {
   	            return false;
   	        }
   	        }
   	    }
   	    return true;
   	}

}
