package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookUserDAO;
import com.dto.BookUser;

@WebServlet("/updatepagedata")
public class UpdateBookServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter po = resp.getWriter();
		String bookId = req.getParameter("id");
		String bookName = req.getParameter("bookname");
		String authorName = req.getParameter("author");
		String bookEdition = req.getParameter("edition");
		String bookQuantity = req.getParameter("quantity");
		int id = Integer.parseInt(bookId);
		BookUser bookUser = new BookUser();
		bookUser.setId(id);
		bookUser.setBookName(bookName);
		bookUser.setAuthorName(authorName);
		bookUser.setEdition(bookEdition);
		bookUser.setQuantity(bookQuantity);

		try {

			int i = BookUserDAO.EditBookByID(bookUser);
			if (i > 0) {
				resp.sendRedirect("ViewBook.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
