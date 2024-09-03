package com.serv;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
public class GmailSender {
    public boolean sendEmail(String from,String to,String subject,String body)
    {
        boolean status=false;
//LOGIC
        Properties props=new Properties();
        props.put("mail.smtp.auth",true);
        props.put("mail.smtp.starttls.enable",true);
        props.put("mail.smtp.port","587");
        props.put("mail.smtp.host","smtp.gmail.com");

        final String username="smartlibrary40@gmail.com";
        final String password="yfkr moxe tbrw zdlh";
       
	Session session=Session.getInstance(props, new Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(username, password);
	}
	});
	try {
		Message message=new MimeMessage(session);
		message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
		message.setFrom(new InternetAddress(from));
		message.setSubject(subject);
		message.setText(body);  
		
		Transport.send(message);
		status=true;
	} catch (Exception e) {
		// TODO: handle exception
	}
        return status;
    }
}