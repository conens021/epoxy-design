package com.abstractmedia.projects.epoxydesign.model.product;

import org.springframework.stereotype.Service;

@Service
public class ProductValidation {
	
	private Product product;
	
	
	public ProductValidation() {
		this.product = new Product();
	}
	
	
	public ProductValidation(Product product) {
		this.product = product;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	public boolean validate() {
	
		
		if(this.product.getName().length() >=2 && this.product.getTitle().length() >= 2 && 
				this.product.getPrice() != null &&
				this.product.getDescription().length() >=15) {
			return true;
		}
		
		else return false;
		
	}
}
