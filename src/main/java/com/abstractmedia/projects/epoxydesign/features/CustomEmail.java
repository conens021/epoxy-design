package com.abstractmedia.projects.epoxydesign.features;

import java.io.IOException;

import java.util.Date;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;



import org.springframework.stereotype.Component;

@Component
public class  CustomEmail  {


	private final String HOST_NAME = "smtp.googlemail.com";
	private final int PORT_NUMBER = 587;
	private final String USERNAME = "nikolakobas111";
	private final String PASSWORD = "klisa021";
	private String from;
	private String fromName;
	private String subject;
	private String msg;


	
	public CustomEmail() {
		
	}
	
	
	public CustomEmail(String from,String subject,String msg) {
		
		this.from = from;
		this.subject = subject;
		this.msg = msg;
	
	}
	
	

	
	public void setFrom(String from) {
		this.from = from;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getFrom() {
		return from;
	}

	public String getSubject() {
		return subject;
	}

	public String getMsg() {
		return msg;
	}


	public String getFromName() {
		return fromName;
	}


	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public void sendMessage() throws AddressException, MessagingException, IOException {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", HOST_NAME);
		   props.put("mail.smtp.port", PORT_NUMBER);
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication(USERNAME, PASSWORD);
		      }
		   });
		   Message msg = new MimeMessage(session);
		  
		   InternetAddress address = new InternetAddress(this.getFrom());
		   
		   address.setPersonal(this.getFromName());
		   
		  
		   
		   msg.setFrom(address);
		  
		  

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("n.rackovic021@gmail.com"));
		   msg.setSubject(this.getSubject());
		 
		   msg.setSentDate(new Date());
		   msg.setText(this.getMsg());
		  
		   Transport.send(msg);   
		}

	
	

}
