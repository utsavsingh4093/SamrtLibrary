package com.logic.datepicker;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.dao.BookUserDAO;
import com.dao.IssueBookDAO;
import com.dto.BookUser;
import com.dto.IssueBookDTO;

public class DateMatching {
	public static boolean dateChecking(String issueDate, String returnDate, int bookId, int quantity) {
	
	    List<IssueBookDTO> list = IssueBookDAO.fetchDates(bookId);
    
	    LocalDate newIssueDate = LocalDate.parse(issueDate);
	    LocalDate newReturnDate = LocalDate.parse(returnDate);

	    List<LocalDate> issueDates = new ArrayList<>();
	    List<LocalDate> returnDates = new ArrayList<>();

		    for (IssueBookDTO issueBookDTO : list) {
	        LocalDate existingIssueDate = LocalDate.parse(issueBookDTO.getIssueDate());
	        LocalDate existingReturnDate = LocalDate.parse(issueBookDTO.getReturnDate());

	        issueDates.add(existingIssueDate);
	        returnDates.add(existingReturnDate);
	    }

	    System.out.println("Requested Quantity: " + quantity);

	    if (quantity <= 0) {
	        for (int i = 0; i < issueDates.size(); i++) {
	            LocalDate existingIssueDate = issueDates.get(i);
	            LocalDate existingReturnDate = returnDates.get(i);

	            if (newIssueDate.isBefore(existingReturnDate) && newReturnDate.isAfter(existingIssueDate)) {
	                return false;  
	            }
	        }
	    } else {
	     return true;
	    }
 return true;
}
	
    public static boolean dateCheckingForReturn(String issueDate, String returnDate, int bookId)
    {
    	   List<IssueBookDTO> list = IssueBookDAO.fetchDates(bookId);
   	    
   	    LocalDate newIssueDate = LocalDate.parse(issueDate);
   	    LocalDate newReturnDate = LocalDate.parse(returnDate);

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
   	        
   	     if (availableQuantity < 0 || availableQuantity == 0) {
   	        if (newIssueDate.isBefore(existingReturnDate) && newReturnDate.isAfter(existingIssueDate)) {
   	            return false;
   	        }
   	        }
   	    }
   	    return true;
   	}
}