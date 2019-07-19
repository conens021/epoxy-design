package com.abstractmedia.projects.epoxydesign.services.product;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abstractmedia.projects.epoxydesign.features.randomString.Chars;
import com.abstractmedia.projects.epoxydesign.features.randomString.Size;
import com.abstractmedia.projects.epoxydesign.features.randomString.StringPatterns;
import com.abstractmedia.projects.epoxydesign.model.Category;
import com.abstractmedia.projects.epoxydesign.model.Subcategory;
import com.abstractmedia.projects.epoxydesign.model.product.Product;
import com.abstractmedia.projects.epoxydesign.model.product.ProductImages;
import com.abstractmedia.projects.epoxydesign.model.product.ProductResponse;
import com.abstractmedia.projects.epoxydesign.services.categories.CategoryRepository;
import com.abstractmedia.projects.epoxydesign.services.categories.SubcategoryRepository;

@Service
public class ProductServices {

	
	
	@Autowired
	private StringPatterns stringPatterns;
	
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private SubcategoryRepository subcategoryRepository;
	
	

	 //Save the uploaded file to this folder
   private static final String UPLOADED_FOLDER = "D:\\eclipse-workspace\\epoxy-design\\src\\main\\resources\\static\\images\\";
	
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

	public  ProductResponse setProductFields(Product p , String name,String tittle,Boolean onSale,
			String saleAmount,String descritption,String price,String onStock,Integer category,Integer subcategory,String additionalInfo) {
		ProductResponse productResponse = new ProductResponse(); 
		if(onSale!= null && onSale) {
			p.setOnSale(true);
			if(isNumeric(saleAmount)) {
				p.setSaleAmount(Integer.valueOf(saleAmount));
			}
			else {
				productResponse.setMsg("Not a valid sale amount(Not valid number)");
				productResponse.setValid(false);
				return productResponse;
			}
			
		}else {
			p.setOnSale(false);
			p.setSaleAmount(0);
		}
		
		
		
		p.setName(name);
		p.setTitle(tittle);
		p.setDescription(descritption);
		p.setAdditionalInfo(additionalInfo);
		
		
		if(isDecimal(price)) {
			p.setPrice(new BigDecimal(price));
		}else {
			productResponse.setMsg("Not a valid product price(Not decimal number) Valid : 4.52 try '.' instead ','");
			productResponse.setValid(false);
			return productResponse;
		}
		
		p.setOnStock(Integer.valueOf(onStock));
		
		Optional<Category> prodCategory = categoryRepository.findById(category);
		
		
		p.setProdCategory(prodCategory.get());
		
		if(subcategory != null) {
			Optional<Subcategory> prodSubc = subcategoryRepository.findById(subcategory);
			
			p.setSubcategory(prodSubc.get());
		}
		
		productResponse.setValid(true);
		
		return productResponse;
	}
	
	
	
	public void saveProductImages(MultipartFile files[],List<ProductImages> images,Product p) {
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
			p.setImages(images);
		}
	}

	public SortedMap<String,String>  getAdditionalValues(String additionalInfo) {
		SortedMap<String,String> additionalValues = new  TreeMap<>();
		
		if(additionalInfo!= null && !additionalInfo.trim().equals("")) {	
		
		
			
			String[] lines = additionalInfo.split("&");
			
			System.out.println(lines.length);
	
			
			for(String line : lines) {
				additionalValues.put(line.split("=")[0].trim(),line.split("=")[1].trim());
			}
			
	
			return additionalValues; 
		}
		return additionalValues; 
	}

	public static String getUploadedFolder() {
		return UPLOADED_FOLDER;
	}
	
	
	
	
}
	
