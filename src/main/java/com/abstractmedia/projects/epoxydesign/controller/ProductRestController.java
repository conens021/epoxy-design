package com.abstractmedia.projects.epoxydesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abstractmedia.projects.epoxydesign.model.product.Product;
import com.abstractmedia.projects.epoxydesign.services.product.ProductRepositoryImpl;

@RestController
public class ProductRestController {

	@Autowired
	private ProductRepositoryImpl productRepositoryImpl;
	
	@GetMapping("/product/quick-view/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer id){
		Product byId = productRepositoryImpl.getById(id);
		if(byId.getId() != 0) {
			return new ResponseEntity<Product>(byId,HttpStatus.OK);
			
		}
		
		return new ResponseEntity<Product>(byId,HttpStatus.NOT_FOUND);
		
	}
	
}
