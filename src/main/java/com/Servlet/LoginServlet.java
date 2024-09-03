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
import com.DAO.AdminDAO;
import com.DAO.UserDAO;
import com.DTO.Admin;
import com.DTO.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter printWriter=resp.getWriter();
	resp.setContentType("text/html");
	String mebershipNumber=req.getParameter("number");
	String password=req.getParameter("pass");
	
	PrintWriter po=resp.getWriter();
	 resp.setContentType("text/html");
	 if(mebershipNumber.length()==8) {
	 if(AdminDAO.getUserByNumberAndPassword(mebershipNumber, password)!=null)
		{
		 Admin admin = AdminDAO.getUserByNumberAndPassword(mebershipNumber, password);
		 HttpSession session=req.getSession();
		
		 session.setAttribute("getEmail",admin.getEmail());
		 session.setAttribute("getName",admin.getName());
		 session.setAttribute("message","Login Successfuly..");
		 RequestDispatcher requestDispatcher=req.getRequestDispatcher("AdminHome.jsp");
		 requestDispatcher.forward(req, resp);
		 }
		else {
			 resp.setContentType("text/html");
				//po.print("<h3 style='color:red'>Member Ship Number and Password didn't Match");
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("Login.jsp");
				 requestDispatcher.forward(req, resp);
			//resp.sendRedirect("Errorjsp.jsp");
		}
}
	 else if(mebershipNumber.length()==6)
	 {
		 if(UserDAO.getUserByNumberAndPassword(mebershipNumber, password)!=null)
		{
			 User user=UserDAO.getUserByNumberAndPassword(mebershipNumber, password);
			 
		 HttpSession session=req.getSession();
		 session.setAttribute("getsId", user.getId());
		 session.setAttribute("getemail",user.getEmail());
		 session.setAttribute("getName", user.getName());
		 session.setAttribute("message","Login Successfuly..");
		 RequestDispatcher requestDispatcher=req.getRequestDispatcher("UserHome.jsp");
		 requestDispatcher.forward(req, resp);
		 }
		else {
			 resp.setContentType("text/html");
				po.print("<h3 style='color:red'>Member Ship Number and Password didn't Match");
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("Login.jsp");
				 requestDispatcher.forward(req, resp);
			//resp.sendRedirect("Errorjsp.jsp");
		}
	 }
	 else {
		 resp.setContentType("text/html");
			po.print("<h3 style='color:red'>Member Ship Number and Password didn't Match");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("Login.jsp");
			 requestDispatcher.forward(req, resp);
	 }
	 
}
}
