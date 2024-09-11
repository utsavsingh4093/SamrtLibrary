package com.thirdparty.server;

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

        Properties properties=new Properties();
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.host","smtp.gmail.com");

        final String username="smartlibrary40@gmail.com";
        final String password="yfkr moxe tbrw zdlh";
       
	Session session=Session.getInstance(properties, new Authenticator() {
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
		e.printStackTrace();
	}
        return status;
    }
}