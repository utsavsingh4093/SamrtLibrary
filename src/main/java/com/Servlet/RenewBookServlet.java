package com.servlet;

import java.io.IOException;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.IssueBookDAO;
import com.dto.IssueBookDTO;

@WebServlet("/newbooks")
public class RenewBookServlet extends HttpServlet {

	private static final long serialVersionUID = -5220487406753468154L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		// PrintWriter printWriter = resp.getWriter();

		try {
			int id = Integer.parseInt(req.getParameter("id"));

			IssueBookDTO issueBookDTO = IssueBookDAO.fetchSingleUserForReturnDate(id);
			String dateOfReturn = issueBookDTO.getReturnDate();

			LocalDate currentDate = LocalDate.now();

			String issueDate = String.valueOf(req.getParameter("issuedate"));
			// New Return Date
			String returnDatee = String.valueOf(req.getParameter("returndate"));

			System.out.println("Date Of Return : " + dateOfReturn);
			System.out.println("Date Of Current : " + currentDate);
			System.out.println("Date Of issue : " + issueDate);
			System.out.println("Date Of returndate : " + returnDatee);

			if (currentDate.isEqual(LocalDate.parse(dateOfReturn))) {
				String status = "Issued";
				String status1 = "Reserved";
				int i = IssueBookDAO.updateBookstatus(status, status1);
				if (i > 0) {
					int j = IssueBookDAO.updateBookDetails("NotIssued", "0", id);
					if (j > 0) {
						HttpSession session = req.getSession();
						session.setAttribute("messages",
								"You can't Renew Book now becase is alerady reserved by another user");
						resp.sendRedirect("RenewBook.jsp");
					}
				} else {
					resp.sendRedirect("UserHome.jsp");
				}
			}

			else if (currentDate.isBefore(LocalDate.parse(returnDatee))) {
				int result = IssueBookDAO.renewBook(returnDatee, issueDate, id);
				if (result > 0) {
					HttpSession session = req.getSession();
					session.setAttribute("message",
							"Book renewed successfully. You can renew again on " + returnDatee + ". Thank you.");
					resp.sendRedirect("RenewBook.jsp");
				} else {
					resp.sendRedirect("UserHome.jsp");
				}
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("mess", "You can't renew the book now. You can renew book on the return date: "
						+ returnDatee + ". Thank you.");
				resp.sendRedirect("RenewBook.jsp");
			}

		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();

		}

	}
}
