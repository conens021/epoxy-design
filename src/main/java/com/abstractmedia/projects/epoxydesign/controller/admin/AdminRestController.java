package com.abstractmedia.projects.epoxydesign.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abstractmedia.projects.epoxydesign.features.randomString.StringPatterns;
import com.abstractmedia.projects.epoxydesign.model.product.Product;
import com.abstractmedia.projects.epoxydesign.model.product.ProductImages;
import com.abstractmedia.projects.epoxydesign.model.product.ProductResponse;
import com.abstractmedia.projects.epoxydesign.services.categories.CategoryRepository;
import com.abstractmedia.projects.epoxydesign.services.categories.SubcategoryRepository;
import com.abstractmedia.projects.epoxydesign.services.product.ProductRepository;
import com.abstractmedia.projects.epoxydesign.services.product.ProductRepositoryImpl;
import com.abstractmedia.projects.epoxydesign.services.product.ProductServices;

@RestController
public class AdminRestController {

	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductRepositoryImpl productRepositoryImpl;
	
	
	@Autowired
	private ProductServices productServices;
	
	
	@PostMapping("/djeke-djole/upload-product")
	public ResponseEntity<ProductResponse> uploadProduct(Model model, @RequestParam(name="images") MultipartFile files[],
											 @RequestParam(name="productName") String productName,
											 @RequestParam(name="productTitle") String productTitle,
											 @RequestParam(name="category",required=false) Integer category,
											 @RequestParam(name="subcategory",required=false) Integer subcategory,
											 @RequestParam(name="onSale",required=false) Boolean onSale,
											 @RequestParam(name="saleAmount",required=false) String saleAmount,
											 @RequestParam(name="price",required=false) String price,
											 @RequestParam(name="description",required=false) String description,
											 @RequestParam(name="onStock",required=false) String onStock,
											 @RequestParam(name="productId",required=false) Integer id,
											 @RequestParam(name="additionalInfo",required=false) String additionalInfo
											 ) {
		
		
		  ProductResponse productResponse = null; Product p = null;
		  
		  //If product is being updated
		  if(id != 0) {
			  p = productRepositoryImpl.getById(id);
			  productResponse = productServices.setProductFields(p,
			  productName, productTitle, onSale,
			  saleAmount,description,price,onStock,category,subcategory, additionalInfo);
			  if(!productResponse.isValid()) { return new
			  ResponseEntity<ProductResponse>(productResponse,HttpStatus.NOT_ACCEPTABLE);
		  }
		  else {
		  
			  p.setLastUpdated(new Date()); productRepository.save(p);
		  
			  return new  ResponseEntity<ProductResponse>(productResponse,HttpStatus.CREATED);
		  
		  }
		  
		  
	 }
		  
		  
		  //If Product is being created 
		  List<ProductImages> images = new ArrayList<>();
		  
		  p = new Product();
		  
		  productResponse = productServices.setProductFields(p, productName, productTitle, onSale,
		  saleAmount,description,price,onStock,category,subcategory,additionalInfo);
		  
		  
		  //If product fields are not valid
		  if(!productResponse.isValid()) { 
			  return new ResponseEntity<ProductResponse>(productResponse,HttpStatus.NOT_ACCEPTABLE); 
		  }
		  
		  
		  
		  
		  productServices.saveProductImages(files, images, p); p.setCreatedTime(new Date());
		  p.setLastUpdated(new Date());
		  
		  productRepository.save(p);
		 			
		

		return new ResponseEntity<ProductResponse>(productResponse,HttpStatus.CREATED);
		
		
	}
	
	
}
	
	
	
	
	
	


