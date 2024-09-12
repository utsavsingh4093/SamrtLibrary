package com.servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/issue")
public class IssueBooksServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWrite = resp.getWriter();
		resp.setContentType("text/html");
		int bookid = Integer.parseInt(req.getParameter("id"));
		int sid = Integer.parseInt(req.getParameter("sid"));
		String bookImg = req.getParameter("book");
		String studentName = req.getParameter("studentname");
		String bookName = req.getParameter("bookname");
		String authorName = req.getParameter("author");
		String edition = req.getParameter("edition");
		String bookQuantity = req.getParameter("bookquantity");
		String statue = req.getParameter("status");
		String issueDate = req.getParameter("issuedate");
		String returnDate = req.getParameter("returndate");

		IssueBookDTO issueBookDTO = new IssueBookDTO();
		issueBookDTO.setBookid(bookid);
		issueBookDTO.setSid(sid);
		issueBookDTO.setBook(bookImg);
		issueBookDTO.setStudentName(studentName);
		issueBookDTO.setBookName(bookName);
		issueBookDTO.setAuthor(authorName);
		issueBookDTO.setEdition(edition);
		issueBookDTO.setUserBookQuantity(bookQuantity);
		issueBookDTO.setStatus(statue);
		issueBookDTO.setIssueDate(issueDate);
		issueBookDTO.setReturnDate(returnDate);

		int i = IssueBookDAO.insetIssueBookData(issueBookDTO);
		if (i > 0) {
			String Quantity = req.getParameter("quantityInput");// Total Book Available in library
			String availableQuantity = String.valueOf(Integer.parseInt(Quantity) - Integer.parseInt(bookQuantity));
			int quantityData = Integer.parseInt(availableQuantity);
			int j = BookUserDAO.updatebook(availableQuantity, bookid);
			if (j > 0) {
				resp.sendRedirect("issueBooks.jsp");
				HttpSession session1 = req.getSession();
				session1.setAttribute("getavailbleQuantity", "data");
				session1.setAttribute("getmessage", "Your Book is issued successfully Thank you...");
				HttpSession ses = req.getSession();
				ses.setAttribute("getQuantity", availableQuantity);
			}
		} else {
			resp.sendRedirect("Bookissue.jsp");
		}

	}

}
