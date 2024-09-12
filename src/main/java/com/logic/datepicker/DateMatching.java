package com.logic.datepicker;
import java.time.LocalDate;
import java.util.List;

import com.dao.BookUserDAO;
import com.dao.IssueBookDAO;
import com.dto.BookUser;
import com.dto.IssueBookDTO;

public class DateMatching {
    
    public static boolean dateChecking(String issueDate, String returnDate, int bookId, int quantity) {
        IssueBookDTO issueBookDTO = IssueBookDAO.fetchDates(bookId);
        
        if (issueBookDTO == null) {
            return true;
        }

        // getting the existing issue dates
        LocalDate existingIssueDate = LocalDate.parse(issueBookDTO.getIssueDate());
        LocalDate existingReturnDate = LocalDate.parse(issueBookDTO.getReturnDate());
        
        // getting  new issue dates
        LocalDate newIssueDate = LocalDate.parse(issueDate);
        LocalDate newReturnDate = LocalDate.parse(returnDate);

        List<BookUser> bookList = BookUserDAO.fetchAllBooks();
        int availableQuantity = 0;

        for (BookUser bookUser : bookList) {
            if (bookUser.getId() == bookId) { 
                availableQuantity = Integer.parseInt(bookUser.getQuantity());
                System.out.println(availableQuantity);
                break;
            }
        }
System.out.println(quantity);
if (availableQuantity >= quantity) {
            if(quantity==1) {
            	if(newIssueDate.isEqual(existingIssueDate))
            	{
            		return true;
            	}
            }
            if (quantity == 0) {
                if (newIssueDate.isBefore(existingReturnDate) && newReturnDate.isAfter(existingIssueDate)) {
                    
                    return false;
                }
            }
            
            return true;
        }

        
        return false;
    }
    
    
    public static boolean dateCheckingForReturn(String issueDate, String returnDate, int bookId)
    {
IssueBookDTO issueBookDTO = IssueBookDAO.fetchDates(bookId);
        if (issueBookDTO == null) {
            return true;
        }
        
        LocalDate existingIssueDate = LocalDate.parse(issueBookDTO.getIssueDate());
        LocalDate existingReturnDate = LocalDate.parse(issueBookDTO.getReturnDate());
        
        
        LocalDate newIssueDate = LocalDate.parse(issueDate);
        LocalDate newReturnDate = LocalDate.parse(returnDate);
        List<BookUser> bookList = BookUserDAO.fetchAllBooks();
        int availableQuantity = 0;

        for (BookUser bookUser : bookList) {
            if (bookUser.getId() == bookId) { 
                availableQuantity = Integer.parseInt(bookUser.getQuantity());
                System.out.println(availableQuantity);
                break;
            }
        }
      
       if (availableQuantity == 0) {
                
                if (newIssueDate.isBefore(existingReturnDate) && newReturnDate.isAfter(existingIssueDate)) {
                  
                    return false;
                }
            
            return true;
        }

        return false;
    }
}
