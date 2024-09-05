package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/issuebooksdata")
public class BookServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter printWriter = resp.getWriter();
		resp.setContentType("text/html");

		int bookId = Integer.parseInt(req.getParameter("id"));
		HttpSession session = req.getSession();
		session.setAttribute("getid", bookId);

		String driver = "com.mysql.cj.jdbc.Driver";
		HttpSession session1 = req.getSession();
		session.setAttribute("getdriver", driver);

		String url = "jdbc:mysql://localhost:3306/library_project";
		HttpSession session2 = req.getSession();
		session.setAttribute("geturl", url);

		String user = "root";
		HttpSession session3 = req.getSession();
		session.setAttribute("getUser", user);

		String password = "4093";
		HttpSession session4 = req.getSession();
		session4.setAttribute("getPass", password);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Bookissue.jsp");
		requestDispatcher.forward(req, resp);
	}
}
