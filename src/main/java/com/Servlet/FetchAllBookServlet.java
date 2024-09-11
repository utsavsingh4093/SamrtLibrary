package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.BookUser;

@WebServlet("/viewbook")
public class FetchAllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 765784629764287163L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewBook.jsp");
		requestDispatcher.forward(req, resp);

	}
}
