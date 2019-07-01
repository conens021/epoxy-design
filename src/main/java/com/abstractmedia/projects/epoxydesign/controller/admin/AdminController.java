package com.abstractmedia.projects.epoxydesign.controller.admin;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abstractmedia.projects.epoxydesign.model.product.Product;
import com.abstractmedia.projects.epoxydesign.services.ProductRepositoryImpl;


@Controller
public class AdminController {
	
	
	@Autowired
	private ProductRepositoryImpl productRepositoryImpl;

	
	@GetMapping("/djeke-djole/create-product")
	public String createProduct() {
		return "create-product";
	}
	
	
	
	@GetMapping(value = {"/djeke-djole","/djeke-djole/list-products"})
	public String listProducts(@RequestParam(name="page",required = false,defaultValue = "1")String page,
								@RequestParam(name="sd",required = false,defaultValue = "ASC")String sd,
								@RequestParam(name="sb",required = false,defaultValue = "name")String sb,
								@RequestParam(name="pn",required = false,defaultValue = "none")String pn,
								Model model) {
		
		
		Page<Product> productPage = null;
		
		if(pn.equalsIgnoreCase("none")) {
			 productPage = productRepositoryImpl.findAllProducts(page,sd, sb, 20);
		}
		else {
			productPage = productRepositoryImpl.getByName(pn, page, sd, sb, 20);
		}
		
		
		
		model.addAttribute("products",productPage);
		model.addAttribute("sortBy",sb);
		model.addAttribute("sortDirection",sd.toUpperCase());
		
		return "list-products";
	}
	
	
	@GetMapping("/uploadStatus")
	public String getUploadStatus() {
		return "uploadStatus";
	}
	
}
