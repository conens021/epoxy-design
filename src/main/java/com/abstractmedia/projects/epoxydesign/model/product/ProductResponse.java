package com.abstractmedia.projects.epoxydesign.model.product;

public class ProductResponse {
	
	private boolean valid;
	private String msg;
	public ProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductResponse(boolean valid, String msg) {
		super();
		this.valid = valid;
		this.msg = msg;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	

}
