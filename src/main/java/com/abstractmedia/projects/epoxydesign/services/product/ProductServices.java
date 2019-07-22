package com.abstractmedia.projects.epoxydesign.services.product;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PresignedUrlUploadRequest;

import io.netty.handler.codec.http.HttpRequest;

@Service
public class ProductServices {

	
	
	@Autowired
	private StringPatterns stringPatterns;
	
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private SubcategoryRepository subcategoryRepository;
	
	
	@Autowired
	private FileStorageServiceImpl fileStorageServiceImpl; 
	
	
	

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
				  
				    	StringBuilder fileName = new StringBuilder();
				    	fileName.append(stringPatterns.generate(Chars.LETTER_CHARS, Size.SMALL_SIZE));
				    	fileName.append(file.getOriginalFilename());
				    	ProductImages prodImage = new ProductImages(fileName.toString());
				    	prodImage.setProduct(p);
				    	images.add(prodImage);
				    	
				    	
				    	try {
							fileStorageServiceImpl.saveFile(file, fileName.toString());
						} catch (IOException e) {
							// TODO Auto-generated catch block
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
	
