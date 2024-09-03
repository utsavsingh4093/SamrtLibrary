package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.IssueBookDAO;
import com.DTO.IssueBookDTO;

@WebServlet("/newbooks")
public class RenewBookServlet extends HttpServlet{

    private static final long serialVersionUID = -5220487406753468154L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            
            IssueBookDTO issueBookDTO = IssueBookDAO.fetchSingleUserForReturnDate(id);
            String dateOfReturn = issueBookDTO.getReturnDate();
            LocalDate returnDate = LocalDate.parse(dateOfReturn);
            
            LocalDate currentDate = LocalDate.now();
            LocalDate afterDays = returnDate.plusDays(30);
            
            if(currentDate.isEqual(returnDate)) {
            	HttpSession session1=req.getSession();
            	session1.setAttribute("messages", "You can't Renew Book now becase is alerady reserved by another user");
            	
            }
           
                if (currentDate.isBefore(afterDays)) {
                    int result = IssueBookDAO.renewBook(currentDate.toString(), afterDays.toString(), id);
                    if (result > 0) 
                    {
                        HttpSession session = req.getSession();
                        session.setAttribute("message", "Book renewed successfully. You can renew again on " + afterDays + ". Thank you.");
                        resp.sendRedirect("RenewBook.jsp");
                    } else {
                        resp.sendRedirect("UserHome.jsp");
                    }
                } else {
                    HttpSession session = req.getSession();
                    session.setAttribute("mess", "You can't renew the book now. You can renew book after the return date: " + returnDate + ". Thank you.");
                    resp.sendRedirect("RenewBook.jsp");
                }
            
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            //resp.sendRedirect("ErrorPage.jsp");
        }
    }
}
