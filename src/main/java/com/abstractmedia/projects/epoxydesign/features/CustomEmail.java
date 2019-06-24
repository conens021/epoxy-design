package com.abstractmedia.projects.epoxydesign.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Component;

@Component
public class  CustomEmail {
	
	
	
	private Email simpleEmail;
	private final String HOST_NAME = "smtp.googlemail.com";
	private final int PORT_NUMBER = 465;
	private final String USERNAME = "nikolakobas111";
	private final String PASSWORD = "klisa021";
	private String from;
	private String fromName;
	private String subject;
	private String msg;

	private final List<String> SEND_TO = Arrays.asList("n.rackovic021@gmail.com");
	
	private  List<InternetAddress>  adresses = new ArrayList<InternetAddress>();
	

	
	public CustomEmail() {
		this.simpleEmail = new SimpleEmail();
		this.simpleEmail.setHostName(HOST_NAME);
		this.simpleEmail.setSmtpPort(PORT_NUMBER);
		this.simpleEmail.setAuthentication(USERNAME, PASSWORD);
		this.simpleEmail.setSSLOnConnect(true);
		
		try {
			for(String address : SEND_TO) {
				adresses.add(new InternetAddress(address));
			}
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public CustomEmail(String from,String subject,String msg) {
		this.simpleEmail = new SimpleEmail();
		this.simpleEmail.setHostName(HOST_NAME);
		this.simpleEmail.setSmtpPort(PORT_NUMBER);
		this.simpleEmail.setAuthentication(USERNAME, PASSWORD);
		this.simpleEmail.setSSLOnConnect(true);
		this.from = from;
		this.subject = subject;
		this.msg = msg;
		try {
			for(String address : SEND_TO) {
				adresses.add(new InternetAddress(address));
			}
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public void sendMessage() {
		try {
			this.simpleEmail.setFrom(this.from,this.fromName);
			this.simpleEmail.setSubject(this.subject);
			this.simpleEmail.setMsg(this.msg);
			this.simpleEmail.setTo(adresses);
			this.simpleEmail.send();
			
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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



	
	

}
