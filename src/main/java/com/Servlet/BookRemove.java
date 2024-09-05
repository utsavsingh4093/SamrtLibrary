package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.DAO.BookUserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletebook")
public class BookRemove extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	        PrintWriter po = resp.getWriter();
	        resp.setContentType("text/html");
	        int bookId = Integer.parseInt(req.getParameter("id"));
	         int i=BookUserDAO.deleteBookById(bookId);
	         if(i>0)
	         {
	        	 resp.sendRedirect("ViewBook.jsp");
	         }
	         else{
	        	 resp.sendRedirect("Error.jsp");
	         }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
