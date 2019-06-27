package com.abstractmedia.projects.epoxydesign.features;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageResponse {
	private boolean success;
	private Map<String,Boolean>validation = new HashMap<>();

	public MessageResponse(boolean success) {
		super();
		this.success = success;
	}
	public MessageResponse(boolean success,Map<String,Boolean> validation) {
		super();
		this.success = success;
		this.validation = validation;
	}

	public MessageResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Map<String, Boolean> getValidations() {
		return validation;
	}
	public void setValidation(Map<String, Boolean> validation) {
		this.validation = validation;
	}
	
	
	
}
