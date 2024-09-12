package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/issuebooks")
public class IssueBookDataBaseServlet extends HttpServlet {

	private static final long serialVersionUID = 765784629764287163L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookId = Integer.parseInt(req.getParameter("id"));

		String driver = "com.mysql.cj.jdbc.Driver";
		HttpSession session = req.getSession();
		session.setAttribute("getdriver", driver);

		String url = "jdbc:mysql://localhost:3306/library_project";
		HttpSession session2 = req.getSession();
		session2.setAttribute("geturl", url);

		String user = "root";
		HttpSession session3 = req.getSession();
		session3.setAttribute("getUser", user);

		String pass = "4093";
		HttpSession session4 = req.getSession();
		session4.setAttribute("getPass", pass);

		HttpSession session5 = req.getSession();
		session.setAttribute("getBookId", bookId);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("issueBookDetails.jsp");
		requestDispatcher.forward(req, resp);

	}
}
