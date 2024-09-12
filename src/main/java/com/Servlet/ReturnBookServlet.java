package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BookUserDAO;
import com.dao.IssueBookDAO;
import com.dto.BookUser;
import com.dto.IssueBookDTO;

@WebServlet("/returnbook")
public class ReturnBookServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter po = resp.getWriter();
		LocalDate returndate = LocalDate.now();
		HttpSession session = req.getSession();
		session.setAttribute("getingreturndate", returndate);
		int id = Integer.parseInt(req.getParameter("id"));//Here the issueBookId I am getting
		int bookid = Integer.parseInt(req.getParameter("bookid"));
		// po.print(id);
		IssueBookDTO issueBookDTO = IssueBookDAO.fetchSingleUser(id);
		BookUser bookUser = BookUserDAO.fetch(bookid);
		String bookQuantity = bookUser.getQuantity();// Total book quantity
		String updateQuantity = issueBookDTO.getIssueDate();// Getting User Issue Book Quantity

		String datareturn = String.valueOf(Integer.parseInt(bookQuantity) + Integer.parseInt(updateQuantity));// Updating
																												// The
																												// Quantity
		if (issueBookDTO != null) {
			issueBookDTO.setStatus("NotIssued");
			issueBookDTO.setReturnDate(String.valueOf(returndate));
			issueBookDTO.setUserBookQuantity("0");

			int i = 0;
			try {

				i = IssueBookDAO.updateBook(issueBookDTO);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (i > 0) {
				int j = BookUserDAO.updatebook(datareturn, bookid);
				if (j > 0) {
					session.setAttribute("message", "Book is Return to Library Successfully..Thank You.");
					resp.sendRedirect("ReturnBook.jsp");
				}
			} else {
				resp.sendRedirect("Bookissue.jsp");
			}
		}
		po.close();
	}

}
