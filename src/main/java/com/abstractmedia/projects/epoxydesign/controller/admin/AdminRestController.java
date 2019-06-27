package com.abstractmedia.projects.epoxydesign.controller.admin;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abstractmedia.projects.epoxydesign.features.randomString.Chars;
import com.abstractmedia.projects.epoxydesign.features.randomString.Size;
import com.abstractmedia.projects.epoxydesign.features.randomString.StringPatterns;
import com.abstractmedia.projects.epoxydesign.model.Category;
import com.abstractmedia.projects.epoxydesign.model.Subcategory;
import com.abstractmedia.projects.epoxydesign.model.product.Product;
import com.abstractmedia.projects.epoxydesign.model.product.ProductImages;
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
	
	 //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D:\\eclipse-workspace\\epoxy-design\\src\\main\\resources\\static\\images\\";
	
	@PostMapping("/djeke-djole/upload-product")
	public String uploadProduct(Model model, @RequestParam(name="images") MultipartFile files[],
											 @RequestParam(name="productName") String productName,
											 @RequestParam(name="productTitle") String productTitle,
											 @RequestParam(name="category",required=false) Integer category,
											 @RequestParam(name="subcategory",required=false) Integer subcategory,
											 @RequestParam(name="onSale",required=false) Boolean onSale,
											 @RequestParam(name="saleAmount",required=false) Integer saleAmount,
											 @RequestParam(name="price",required=false) BigDecimal price,
											 @RequestParam(name="description",required=false) String description
											 ) {
		
		List<ProductImages> images = new ArrayList<>();
	
		
		
		
		
		Product p = new Product();
		
		if(onSale!= null && onSale) {
			p.setOnSale(true);
			p.setSaleAmount(saleAmount);
		}else {
			p.setOnSale(false);
		}
		
		p.setName(productName);
		p.setTitle(productTitle);
		p.setDescription(description);
		p.setPrice(price);
		
	
		Optional<Category> prodCategory = categoryRepository.findById(category);
		
		
		p.setProdCategory(prodCategory.get());
		
		if(subcategory != 0) {
			Optional<Subcategory> prodSubc = subcategoryRepository.findById(subcategory);
			
			p.setSubcategory(prodSubc.get());
		}
		if(files != null) {
			System.out.println("Found files");
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
		
		productRepository.save(p);
		
		return "redirect:/djeke-djole/list-products";
	}
	
	
}
