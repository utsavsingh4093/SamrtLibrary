package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.http.HttpSession;

import com.dao.BookUserDAO;
import com.dto.BookUser;

@WebServlet("/addingbook")
@MultipartConfig
public class AddBookServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter po = resp.getWriter();
		try {
			String bookName = req.getParameter("bookname");
			String authorName = req.getParameter("author");
			String edition = req.getParameter("edition");
			String quantity = req.getParameter("quantity");
			Part part = req.getPart("bimg");
			String fileName = part.getSubmittedFileName();

			// System.out.println(bookName + " : " + authorName + " : " + edition + " : " +
			// quantity + " : " + fileName);
			BookUser bookUser = new BookUser();
			bookUser.setBookName(bookName);
			bookUser.setAuthorName(authorName);
			bookUser.setEdition(edition);
			bookUser.setQuantity(quantity);
			bookUser.setBookimg(fileName);

			int i = BookUserDAO.insertBook(bookUser);
			if (i >= 0) {
				String path = getServletContext().getRealPath("") + "Book";
				System.out.println(path);
				File file = new File(path);
				part.write(path + File.separator + fileName);
				resp.sendRedirect("AdminHome.jsp");
				HttpSession session = req.getSession();
				session.setAttribute("session", "Profile.jsp");
				session.setAttribute("getMessage", "Book is Added Successfully in Library Thank you...");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminHome.jsp");
				requestDispatcher.forward(req, resp);
				po.close();
			} else {
				resp.sendRedirect("Login.jsp");
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}
}