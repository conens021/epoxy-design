package com.abstractmedia.projects.epoxydesign.model;

import java.io.Serializable;

public class Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8218139532501935453L;
	private String name;
	private String email;
	private String phone;
	private String subject;
	private String message;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(String name, String email, String phone, String subject, String message) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.subject = subject;
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public boolean isValid() {
		return true;
	}
}
