package com.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AdminDAO;
import com.DAO.UserDAO;


class App {
	static Random random=new Random();
	public static long genrateNumber(String role)
	{
			return Math.abs(random.nextLong()%1000000);
	}
	//static long number=Math.abs(random.nextLong()%100000000);
    public static void start(String pas,String email,long number) {
           //String str=String.valueOf(number);
         GmailSender gmailSender=new GmailSender();
         String from="cs20.utsavsingh@svceindore.ac.in";
         String to=email;
         String subject="Welcome to the Smart Library";
        String body="Dear : "+to+"\n"
        		+ "Your membership number- "+number+"\n"
        		+ "Your Pssword- "+pas+"\n"
        		+ "\r\n"
        		+ "Welcome to the Smart Library\r\n"
        		+ "\r\n"
        		+ "We are delighted to have you with us and excited for \r\n"
        		+ "you to explore oue extensive collection and innovative \r\n"
        		+ "resources. if you have any questions or need\r\n"
        		+ "assistance, please don't hesitate to reach out.\r\n"
        		+ "\r\n"
        		+ "we lookforward to supporting your learning and\r\n"
        		+ "research needs.\r\n"
        		+ "\r\n"
        		+ "Best regards. \r\n"
        		+ "\r\n"
        		+ from+"\n"
        		+ "Smart Library Support Team"+"\n"
        		+ "Smart Library"+"\n";
       boolean b=gmailSender.sendEmail(from,to,subject,body);
       if(b)
       {
           System.out.println("Email Sent successfully");
       }
       else{
           System.out.println("Eamil failed");
       }
      
    }
}

@WebServlet("/registerpageuser")
public class GmailServletUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        App a=new App();
//        System.out.println("Your number is that : "+App.number);
        String name = req.getParameter("name");
        String libr = req.getParameter("library");
        String address = req.getParameter("add");
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        String role = req.getParameter("role");
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_project","root","4093");
            String s = "insert into student(name,email,role,password,membernumber) values(?,?,?,?,?)";
            ps = con.prepareStatement(s);
            if(UserDAO.getEmail(email).size()==0) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, role);
            ps.setString(4, password);
            long number=App.genrateNumber(role);
            ps.setLong(5, number);
            App.start(password,email,number);
            int i = ps.executeUpdate();
            if (i == 1) {
                resp.sendRedirect("Home.jsp");
            } else {
            	resp.sendRedirect("Errorjsp.jsp");
        }
            HttpSession session=req.getSession();
            session.setAttribute("getName", name);
            session.setAttribute("getEmail", email);
            }
            else {
          	  out.println("This Email is Alerady Exist");
          	  RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
      	        dispatcher.include(req, resp);
            }
        } catch (Exception e) {
           System.out.println(e);
            out.println("Error: " + e.getMessage());
        }
    }
}
