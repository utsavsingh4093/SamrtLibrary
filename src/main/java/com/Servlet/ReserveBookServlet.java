package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.IssueBookDAO;
import com.DTO.IssueBookDTO;

@WebServlet("/reservebook")
public class ReserveBookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter po = resp.getWriter();
		resp.setContentType("text/html");
		int bookid = Integer.parseInt(req.getParameter("id"));
		int sid = Integer.parseInt(req.getParameter("sid"));
		String studentName = req.getParameter("studentName");
		String bookImg = req.getParameter("book");
		String bookName = req.getParameter("bookname");
		String authorname = req.getParameter("author");
		String status = "Reserved";
		String edition = req.getParameter("edition");
		String bookQuantity = "1";

		String issuedate = req.getParameter("issuedate");
          //For gettting Local Date
		LocalDate date = LocalDate.parse(issuedate);
		LocalDate afterDays = date.plusDays(30);
		String returndate = String.valueOf(afterDays);
       
	   IssueBookDTO	issueBookDTO = new IssueBookDTO();
		issueBookDTO.setBookid(bookid);
		issueBookDTO.setSid(sid);
		issueBookDTO.setBook(bookImg);
		issueBookDTO.setStudentName(studentName);
		issueBookDTO.setBookName(bookName);
		issueBookDTO.setAuthor(authorname);
		issueBookDTO.setEdition(edition);
		issueBookDTO.setUserBookQuantity(bookQuantity);
		issueBookDTO.setStatus(status);
		issueBookDTO.setIssueDate(issuedate);
		issueBookDTO.setReturnDate(returndate);

		int i = IssueBookDAO.insetIssueBookData(issueBookDTO);
		if (i > 0) {
			HttpSession session = req.getSession();
			session.setAttribute("messages",
					"Your Book is Reserve Confirm you can get Your Book on " + issuedate + " Thank You");
			resp.sendRedirect("UserHome.jsp");
		}

	}
}
