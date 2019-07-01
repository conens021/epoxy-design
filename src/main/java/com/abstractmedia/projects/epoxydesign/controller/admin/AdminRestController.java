package com.abstractmedia.projects.epoxydesign.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abstractmedia.projects.epoxydesign.features.randomString.Chars;
import com.abstractmedia.projects.epoxydesign.features.randomString.Size;
import com.abstractmedia.projects.epoxydesign.features.randomString.StringPatterns;
import com.abstractmedia.projects.epoxydesign.mode.product.ProductResponse;
import com.abstractmedia.projects.epoxydesign.model.Category;
import com.abstractmedia.projects.epoxydesign.model.Subcategory;
import com.abstractmedia.projects.epoxydesign.model.product.Product;
import com.abstractmedia.projects.epoxydesign.model.product.ProductImages;
import com.abstractmedia.projects.epoxydesign.model.product.ProductValidation;
import com.abstractmedia.projects.epoxydesign.services.CategoryRepository;
import com.abstractmedia.projects.epoxydesign.services.ProductRepository;
import com.abstractmedia.projects.epoxydesign.services.SubcategoryRepository;

@RestController
public class AdminRestController {


	@Autowired
	private StringPatterns stringPatterns;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private SubcategoryRepository subcategoryRepository;
	@Autowired
	private ProductValidation productValidation;
	
	 //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D:\\eclipse-workspace\\epoxy-design\\src\\main\\resources\\static\\images\\";
	
	@PostMapping("/djeke-djole/upload-product")
	public ResponseEntity<ProductResponse> uploadProduct(Model model, @RequestParam(name="images") MultipartFile files[],
											 @RequestParam(name="productName") String productName,
											 @RequestParam(name="productTitle") String productTitle,
											 @RequestParam(name="category",required=false) Integer category,
											 @RequestParam(name="subcategory",required=false) Integer subcategory,
											 @RequestParam(name="onSale",required=false) Boolean onSale,
											 @RequestParam(name="saleAmount",required=false) String saleAmount,
											 @RequestParam(name="price",required=false) String price,
											 @RequestParam(name="description",required=false) String description
											 ) {
		
		List<ProductImages> images = new ArrayList<>();
		ProductResponse productResponse = new ProductResponse(); 
		

		
		Product p = new Product();
		
		if(onSale!= null && onSale) {
			p.setOnSale(true);
			if(isNumeric(saleAmount)) {
				p.setSaleAmount(Integer.valueOf(saleAmount));
			}
			else {
				productResponse.setMsg("Not a valid sale amount(Not valid number)");
				productResponse.setValid(false);
				return new ResponseEntity<ProductResponse>(productResponse,HttpStatus.NOT_ACCEPTABLE);
			}
			
		}else {
			p.setOnSale(false);
		}
		
		
		
		
		p.setName(productName);
		p.setTitle(productTitle);
		p.setDescription(description);
		
		if(isDecimal(price)) {
			p.setPrice(new BigDecimal(price));
		}else {
			productResponse.setMsg("Not a valid product price(Not decimal number) Valid : 4.52 try '.' instead ','");
			productResponse.setValid(false);
			return new ResponseEntity<ProductResponse>(productResponse,HttpStatus.NOT_ACCEPTABLE);
		}
		
		
		
	
		Optional<Category> prodCategory = categoryRepository.findById(category);
		
		
		p.setProdCategory(prodCategory.get());
		
		if(subcategory != null) {
			Optional<Subcategory> prodSubc = subcategoryRepository.findById(subcategory);
			
			p.setSubcategory(prodSubc.get());
		}
		if(files != null) {
	
			for(MultipartFile file : files) {
				if(!file.isEmpty()) {
				    try {
				    	StringBuilder fileName = new StringBuilder();
				    	fileName.append(stringPatterns.generate(Chars.LETTER_CHARS, Size.MEDIUM_SIZE));
				    	fileName.append(file.getOriginalFilename());
				    	ProductImages prodImage = new ProductImages(fileName.toString());
				    	prodImage.setProduct(p);
				    	images.add(prodImage);
				    	
			            // Get the file and save it somewhere
			            byte[] bytes = file.getBytes();
			            Path path = Paths.get(UPLOADED_FOLDER  + fileName.toString());
			            Files.write(path, bytes);
			        
			          
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			}
		

			}
		}
		p.setImages(images);
		
		productValidation.setProduct(p);
		if(productValidation.validate()) {

			productRepository.save(p);
			productResponse.setMsg("Product created successfuly");
			productResponse.setValid(true);
			return new ResponseEntity<ProductResponse>(productResponse,HttpStatus.CREATED);
		}else {
			productResponse.setMsg("You have some errors above. Check it manualy");
			productResponse.setValid(false);
			return new ResponseEntity<ProductResponse>(productResponse,HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	public static boolean isDecimal(String str) { 
		  try {  
			 Double.valueOf(str);
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
}
