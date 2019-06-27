package com.abstractmedia.projects.epoxydesign.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	private final Map<String,Boolean> validation;

	
	public Message() {
		super();
		this.name = "";
		this.email = "";
		this.subject = "";
		this.phone = "";
		this.message = "";
		this.validation  = new HashMap<>();
		
		
	}
	public Message(String name, String email, String phone, String subject, String message) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.subject = subject;
		this.message = message;
		this.validation  = new HashMap<>();

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
		
		boolean valid = false;
		
		addValidation("name", (this.getName().length() >= 4));
		addValidation("email", emailvalidation(this.getEmail()));
		addValidation("subject", (this.getSubject().length() >= 2));
		if(this.getPhone().length() > 0)
			addValidation("phoneNumber", phoneValidation(this.getPhone()));
		else 
			addValidation("phoneNumber", true);
		addValidation("message", (this.getMessage().length() >= 15));
		
		for(Entry<String, Boolean> set : this.validation.entrySet()) {
			if(!set.getValue()) {
				valid = false;
				return valid;
			}
			else
				valid = true;
		}
		
		return valid;
	}
	
	
	
	
	public void addValidation(String key,boolean check) {
		this.validation.put(key,check);

	}
	
	
	public boolean emailvalidation(String email) {
		Pattern emailValidation = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher match = emailValidation.matcher(email);
		return match.find();
	}
	
	public boolean phoneValidation(String phoneNumber) {
		Pattern phoneValidation = Pattern.compile("^\\+?([0-9]{3})\\)?[-. ]?([0-9]{2})[-. ]?([0-9]{6,7})$", Pattern.CASE_INSENSITIVE);
		Matcher match = phoneValidation.matcher(phoneNumber);
		return match.find();
	}
	
	
	//getters and setters
	
	
	@Override
	public String toString() {
		return "Message [name=" + name + ", email=" + email + ", phone=" + phone + ", subject=" + subject + ", message="
				+ message + "]";
	}
	public Map<String, Boolean> getValidation() {
		return validation;
	}
	
	
	
}
