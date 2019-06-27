package com.abstractmedia.projects.epoxydesign.controller.admin;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {

	
	@GetMapping("/djeke-djole/create-product")
	public String createProduct() {
		return "create-product";
	}
	
	
	
	@GetMapping("/djeke-djole/list-products")
	public String listProducts() {
		return "list-products";
	}
	
	
	@GetMapping("/uploadStatus")
	public String getUploadStatus() {
		return "uploadStatus";
	}
	
}
