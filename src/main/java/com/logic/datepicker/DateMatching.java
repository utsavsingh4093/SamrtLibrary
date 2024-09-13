package com.logic.datepicker;
import java.time.LocalDate;
import java.util.List;

import com.dao.BookUserDAO;
import com.dao.IssueBookDAO;
import com.dto.BookUser;
import com.dto.IssueBookDTO;

public class DateMatching {
    
	public static boolean dateChecking(String issueDate, String returnDate, int bookId, int quantity) {
	    // Fetch existing issue dates for the book
	    List<IssueBookDTO> list = IssueBookDAO.fetchDates(bookId);
	    
	    // Parse the new issue and return dates
	    LocalDate newIssueDate = LocalDate.parse(issueDate);
	    LocalDate newReturnDate = LocalDate.parse(returnDate);

	    // Fetch all books and determine available quantity
	   

	    System.out.println("Requested Quantity: " + quantity);

	    // Check if requested quantity exceeds available quantity
	    if (quantity != 0) {
	        return true;
	    }
	    // Check for overlapping date ranges
	    for (IssueBookDTO issueBookDTO : list) {
	        LocalDate existingIssueDate = LocalDate.parse(issueBookDTO.getIssueDate());
	        LocalDate existingReturnDate = LocalDate.parse(issueBookDTO.getReturnDate());

	        System.out.println("Existing Issue Date: " + existingIssueDate);
	        System.out.println("Existing Return Date: " + existingReturnDate);

	        // Check for overlap
	        if (newIssueDate.isBefore(existingReturnDate) && newReturnDate.isAfter(existingIssueDate)) {
	            return false; // Dates overlap
	        }
	    }

	    // No overlap found and quantity is sufficient
	    return true;
	}
	
    public static boolean dateCheckingForReturn(String issueDate, String returnDate, int bookId)
    {
    	   List<IssueBookDTO> list = IssueBookDAO.fetchDates(bookId);
   	    
   	    // Parse the new issue and return dates
   	    LocalDate newIssueDate = LocalDate.parse(issueDate);
   	    LocalDate newReturnDate = LocalDate.parse(returnDate);

   	    // Check availability of books
   	    List<BookUser> bookList = BookUserDAO.fetchAllBooks();
   	    int availableQuantity = 0;

   	    for (BookUser bookUser : bookList) {
   	        if (bookUser.getId() == bookId) { 
   	            availableQuantity = Integer.parseInt(bookUser.getQuantity());
   	            break;
   	        }
   	    }

         // If no existing records, simply return true
         if (list.isEmpty()) {
             return true;
         }
   	    // Check for overlapping date ranges
   	    for (IssueBookDTO issueBookDTO : list) {
   	        LocalDate existingIssueDate = LocalDate.parse(issueBookDTO.getIssueDate());
   	        LocalDate existingReturnDate = LocalDate.parse(issueBookDTO.getReturnDate());
   	        
   	        // Check for overlap
   	     if (availableQuantity < 0 || availableQuantity == 0) {
   	        if (newIssueDate.isBefore(existingReturnDate) && newReturnDate.isAfter(existingIssueDate)) {
   	            return false;
   	        }
   	        }
   	    }
   	    return true;
   	}
}