package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.BookUserDAO;
import com.DTO.BookUser;

@WebServlet("/updatepagedata")
public class UpdateBookServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 resp.setContentType("text/html");
     PrintWriter po = resp.getWriter();
     String idParam = req.getParameter("id");
     String bookName1 = req.getParameter("bookname");
     String authorName1 = req.getParameter("author");
     String edition1 = req.getParameter("edition");
     String quantity1 = req.getParameter("quantity");
     int id = Integer.parseInt(idParam);  
     BookUser bookUser=new BookUser();
     bookUser.setId(id);
     bookUser.setBookName(bookName1);
     bookUser.setAuthorName(authorName1);
     bookUser.setEdition(edition1);
     bookUser.setQuantity(quantity1); 
     
     try {
            
         int i=BookUserDAO.EditBookByID(bookUser);
         if(i>0) {
         	resp.sendRedirect("ViewBook.jsp");
         }
       
         
     } catch (Exception e) {
        e.printStackTrace();
     }

     
}
}
