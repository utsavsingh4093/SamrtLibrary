package com.servlet;

import java.io.IOException;

import java.io.PrintWriter;
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
import com.logic.datepicker.BookIssueChecker;

@WebServlet("/issuebooksservel")
public class issueBooksDataSending extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWrite = resp.getWriter();
		resp.setContentType("text/html");

		int bookid = Integer.parseInt(req.getParameter("id"));
		int sid = Integer.parseInt(req.getParameter("sid"));
		String studentName = req.getParameter("studentname");

		BookUser bookUser = BookUserDAO.fetch(bookid);

		String bookImg = bookUser.getBookimg();
		String bookName = bookUser.getBookName();
		String authorName = bookUser.getAuthorName();
		String edition = bookUser.getEdition();

		String bookQuantity = "1";
		String statue = "Issued";

		String issueDate = String.valueOf(req.getParameter("issuedate"));
		String returnDate = String.valueOf(req.getParameter("returndate"));
		String Quantity = req.getParameter("bookQuantity");
		System.out.println("Requested Quantity: " + Quantity);
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
	
        int totalBooks = bookUser.getToatalBook();
         

		if (BookIssueChecker.dateChecking(issueDate, returnDate, bookid, totalBooks)) {
			int i = IssueBookDAO.insetIssueBookData(issueBookDTO);
			if (i > 0) {
				// Total Book Available in library
				String availableQuantity = String.valueOf(Integer.parseInt(Quantity) - Integer.parseInt(bookQuantity));

				//System.out.println("AvailableQuantity of Book : " + availableQuantity);
				int quantityData = Integer.parseInt(availableQuantity);
				int j = BookUserDAO.updatebook(availableQuantity, bookid);
				if (j > 0) {
					resp.sendRedirect("issueBooks.jsp");
					HttpSession session = req.getSession();
					session.setAttribute("getavailbleQuantity", "data");
					session.setAttribute("getmessage", "Your Book is issued successfully Thank you...");

					HttpSession ses = req.getSession();
					ses.setAttribute("getQuantity", availableQuantity);
				}
			} else {
				resp.sendRedirect("issueBooks.jsp");
			}
		} else {
//			issueBookDTO=IssueBookDAO.fetchReturnDate(bookid);
//			String returndate1=issueBookDTO.getReturnDate();
			HttpSession session = req.getSession();
			session.setAttribute("getmessage",
					"This Is Not Available For that Day Try with Date of issue Thank you...");
			resp.sendRedirect("issueBooks.jsp");
		}
	}
}
