package com.thirdparty.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;
import com.dao.UserDAO;
import com.dto.Admin;

class EmaildataForAdmin {
	private static Random random = new Random();

	public static long generateRandomNumber() {
		return Math.abs(random.nextLong() % 100000000);
	}

	public static void start(String password, String email, long meberShipNumber) {
		// String str=String.valueOf(number);
		GmailSender gmailSender = new GmailSender();
		String from = "smartlibrary40@gmail.com";
		String to = email;
		String subject = "Welcome to the Smart Library";
		String body = "Dear : " + to + "\n" + "Your membership number- " + meberShipNumber + "\n" + "Your Pssword- "
				+ password + "\n" + "\r\n" + "Welcome to the Smart Library\r\n" + "\r\n"
				+ "We are delighted to have you with us and excited for \r\n"
				+ "you to explore oue extensive collection and innovative \r\n"
				+ "resources. if you have any questions or need\r\n"
				+ "assistance, please don't hesitate to reach out.\r\n" + "\r\n"
				+ "we lookforward to supporting your learning and\r\n" + "research needs.\r\n" + "\r\n"
				+ "Best regards. \r\n" + "\r\n" + from + "\n" + "Smart Library Support Team" + "\n" + "Smart Library"
				+ "\n";
		boolean b = gmailSender.sendEmail(from, to, subject, body);
		if (b) {
			System.out.println("Email Sent successfully");
		} else {
			System.out.println("Eamil failed");
		}

	}

}

@WebServlet("/registerpageadmin")
public class GmailServletAdmin extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        EmaildataForAdmin emaildataForAdmin=new EmaildataForAdmin();
//        System.out.println("Your number is that : "+App.number);
        String name = req.getParameter("name");
        String libraryName = req.getParameter("library");
        String address = req.getParameter("add");
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        String role = req.getParameter("role");
        
        long meberShipNumber=EmaildataForAdmin.generateRandomNumber();
        String memberNumber=String.valueOf(meberShipNumber);
        if (email != null) {
			GmailChecking obj_validate_code_source = new GmailChecking();
			boolean exists = obj_validate_code_source.isAddressValid(email);
			if (exists == true) {
        
        try {
            if(AdminDAO.getEmail(email).size()==0 && UserDAO.getEmail(email).size()==0) {
            Admin admin=new Admin();
            
             admin.setName(name);
             admin.setLibraryName(libraryName);
             admin.setAddress(address);
             admin.setEmail(email);
             admin.setRole(role);
             admin.setPassword(password);
             admin.setMemberShipNumber(memberNumber);
             
            EmaildataForAdmin.start(password,email,meberShipNumber);
            int i = AdminDAO.InsertAdmin(admin);
            if (i == 1) {
            	HttpSession session=req.getSession();
            	session.setAttribute("getMessage", "Your Registration is Succsess fully Thank You...");
                resp.sendRedirect("Home.jsp");
            } else {
            	resp.sendRedirect("Errorjsp.jsp");
        }
            HttpSession session=req.getSession();
            session.setAttribute("getName", name);
            session.setAttribute("getEmail", email);
            }
            else {
            	HttpSession session=req.getSession();
            	session.setAttribute("getMessage", "This Email is Alerady Exist so please try again with another mail..");
          	    resp.sendRedirect("RegisterAdmin.jsp");
            }
        } catch (Exception e) {
           System.out.println(e);
            out.println("Error: " + e.getMessage());
        }
			}
			
        }
        else {
			HttpSession session = req.getSession();
			session.setAttribute("getMessage",
					"This Email Address is Not Exist try with another email...");
			resp.sendRedirect("RegisterUser.jsp");
		}
    }
}