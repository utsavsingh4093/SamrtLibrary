package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

@WebServlet("/editdatabook")
public class UpdateBook1 extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter po=resp.getWriter();
	 resp.setContentType("text/html"); 
	 int id=Integer.parseInt(req.getParameter("id"));
    HttpSession session=req.getSession();
	 session.setAttribute("getid",id);
	 
RequestDispatcher requestDispatcher=req.getRequestDispatcher("/UpdateBook.jsp");
requestDispatcher.forward(req, resp);
}
}
