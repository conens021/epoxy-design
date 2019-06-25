package com.abstractmedia.projects.epoxydesign.features;

import org.springframework.stereotype.Component;

@Component
public class MessageResponse {
	private boolean success;

	public MessageResponse(boolean success) {
		super();
		this.success = success;
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
	
}
