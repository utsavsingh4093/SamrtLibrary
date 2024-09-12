package com.logic.datepicker;
import java.time.LocalDate;
import java.util.List;

import com.dao.BookUserDAO;
import com.dao.IssueBookDAO;
import com.dto.BookUser;
import com.dto.IssueBookDTO;

public class DateMatching {
    
    public static boolean dateChecking(String issueDate, String returnDate, int bookId, int quantity) {
        // Fetch the book's current details
        IssueBookDTO issueBookDTO = IssueBookDAO.fetchDates(bookId);
        
        if (issueBookDTO == null) {
            // If no issue information is found for the book, assume it can be issued
            return true;
        }

        // Parse existing issue dates
        LocalDate existingIssueDate = LocalDate.parse(issueBookDTO.getIssueDate());
        LocalDate existingReturnDate = LocalDate.parse(issueBookDTO.getReturnDate());
        
        // Parse new issue dates
        LocalDate newIssueDate = LocalDate.parse(issueDate);
        LocalDate newReturnDate = LocalDate.parse(returnDate);

        // Check the book's quantity availability
        List<BookUser> bookList = BookUserDAO.fetchAllBooks();
        int availableQuantity = 0;

        for (BookUser bookUser : bookList) {
            if (bookUser.getId() == bookId) { // Ensure we are checking the quantity for the correct book
                availableQuantity = Integer.parseInt(bookUser.getQuantity());
                System.out.println(availableQuantity);
                break;
            }
        }
System.out.println(quantity);
        // Check if the book can be issued based on quantity
if (availableQuantity >= quantity) {
            if(quantity==1) {
            	if(newIssueDate.isEqual(existingIssueDate))
            	{
            		return true;
            	}
            }
            if (quantity == 0) {
                // Check for date overlap
                if (newIssueDate.isBefore(existingReturnDate) && newReturnDate.isAfter(existingIssueDate)) {
                    // Overlap exists
                    return false;
                }
            }
            // No overlap or quantity is more than 1
            return true;
        }

        // If not enough quantity available
        return false;
    }
    
    
    public static boolean dateCheckingForReturn(String issueDate, String returnDate, int bookId)
    {
IssueBookDTO issueBookDTO = IssueBookDAO.fetchDates(bookId);
        if (issueBookDTO == null) {
            return true;
        }
        // Parse existing issue dates
        LocalDate existingIssueDate = LocalDate.parse(issueBookDTO.getIssueDate());
        LocalDate existingReturnDate = LocalDate.parse(issueBookDTO.getReturnDate());
        
        // Parse new issue dates
        LocalDate newIssueDate = LocalDate.parse(issueDate);
        LocalDate newReturnDate = LocalDate.parse(returnDate);
        List<BookUser> bookList = BookUserDAO.fetchAllBooks();
        int availableQuantity = 0;

        for (BookUser bookUser : bookList) {
            if (bookUser.getId() == bookId) { // Ensure we are checking the quantity for the correct book
                availableQuantity = Integer.parseInt(bookUser.getQuantity());
                System.out.println(availableQuantity);
                break;
            }
        }
      
       if (availableQuantity == 0) {
                // Check for date overlap
                if (newIssueDate.isBefore(existingReturnDate) && newReturnDate.isAfter(existingIssueDate)) {
                    // Overlap exists
                    return false;
                }
            
            return true;
        }

        return false;
    }
}
