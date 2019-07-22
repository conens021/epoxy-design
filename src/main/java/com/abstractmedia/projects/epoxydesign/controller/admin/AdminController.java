package com.abstractmedia.projects.epoxydesign.controller.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abstractmedia.projects.epoxydesign.model.Category;
import com.abstractmedia.projects.epoxydesign.model.Customer;
import com.abstractmedia.projects.epoxydesign.model.Subcategory;
import com.abstractmedia.projects.epoxydesign.model.order.Orders;
import com.abstractmedia.projects.epoxydesign.model.order.ProductOrders;
import com.abstractmedia.projects.epoxydesign.model.product.Product;
import com.abstractmedia.projects.epoxydesign.model.product.ProductImages;
import com.abstractmedia.projects.epoxydesign.services.categories.CategoryRepository;
import com.abstractmedia.projects.epoxydesign.services.categories.SubcategoryRepository;
import com.abstractmedia.projects.epoxydesign.services.customer.CustomersRepositoryImpl;
import com.abstractmedia.projects.epoxydesign.services.orders.OrdersRepositoryImpl;
import com.abstractmedia.projects.epoxydesign.services.product.ProductRepositoryImpl;
import com.abstractmedia.projects.epoxydesign.services.product.ProductServices;


@Controller
public class AdminController {
	
	
	@Autowired
	private ProductRepositoryImpl productRepositoryImpl;
	@Autowired
	private OrdersRepositoryImpl ordersRepositoryImpl;
	@Autowired
	private CustomersRepositoryImpl customersRepositoryImpl;

	@Autowired
	private CategoryRepository categoryRepositroy;

	@Autowired
	private SubcategoryRepository subcategoryRepository;

	

	
	@GetMapping("/djeke-djole/create-product")
	public String createProduct(Model model) {
		model.addAttribute("product",new Product());
		List<Category> categories = categoryRepositroy.findAll();
		
		List<Subcategory> subcategories = subcategoryRepository.findAll();
		
		model.addAttribute("categories" , categories);
		model.addAttribute("subcategories" , subcategories);
		
		
		return "create-product";
	}
	
	
    @GetMapping("/djeke-djole/edit-product/{id}")
    public String editProduct(@PathVariable Integer id,Model model) {
    	
    	Product product = productRepositoryImpl.getById(id);
    	
    	
    	if(product.getId()==0) {
    		return "404";
    	}
    	
    	List<Category> categories = categoryRepositroy.findAll();
		
		List<Subcategory> subcategories = subcategoryRepository.findAll();
		
		model.addAttribute("categories" , categories);
		model.addAttribute("subcategories" , subcategories);
    	
    	model.addAttribute("product",product);
    	
    	return "create-product";
    }
    
    
    
    @GetMapping("/djeke-djole/delete-product/{id}")
    public String deleteProduct(@PathVariable Integer id,Model model) {
    	
    	
    	Product product = productRepositoryImpl.getById(id);
    	
    	
    	if(product.getId() == 0) {
    		return "404";
    	}
    	
    	
    	//First Delete All Images Releated to This Product
    	List<ProductImages> images = product.getImages();
    	
    	for(ProductImages pi : images) {
    		StringBuilder filePath = new StringBuilder();
    		filePath.append(ProductServices.getUploadedFolder());
    		filePath.append(pi.getImageUrl());
    		File file = new File(filePath.toString());
    		file.delete();
    		
    	}
    	
    	
    	
    	
    
    	
    	
    	
    	
    	productRepositoryImpl.deleteProduct(product);
    		
    			
    	Page<Product> productPage = productRepositoryImpl.findAllProducts("1","DESC","lastUpdated", 20);
      	model.addAttribute("products",productPage);
    	model.addAttribute("sortBy","lastUpdated");
    	model.addAttribute("sortDirection","DESC");	
    	return "list-products";
    	
    	

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
	
	
	
	@GetMapping("/djeke-djole/orders")
	public String getOrders(@RequestParam(name="page",required = false,defaultValue = "1")String page,
							@RequestParam(name="sd",required = false,defaultValue = "DESC")String sd,
							@RequestParam(name="sb",required = false,defaultValue = "orderDate")String sb,
							Model model) {
		
		Page<Orders> orders = ordersRepositoryImpl.getAll(page, sd, sb, 20);
		
		model.addAttribute("orders", orders);
		model.addAttribute("sortBy",sb);
		model.addAttribute("sortDirection",sd.toUpperCase());
		
		
		return "orders";
	}
	
	
	@GetMapping("/djeke-djole/order/{orderId}")
	public String getOrder(@PathVariable Integer orderId,Model model) {
		Orders order = ordersRepositoryImpl.getById(orderId);
		if(order.getId() != 0) {
		
			List<Product> products = new ArrayList<>();
			
			List<ProductOrders> productOrders = order.getProductOrders();
			
			for(ProductOrders po : productOrders) {
				Product p = po.getProduct();
				p.setQuantity(po.getQuantity());
				products.add(p);
			}
			
			model.addAttribute("order",order);
			model.addAttribute("customer",order.getCustomer());
			model.addAttribute("products",products);
			
			return "order-single";
		}
		else {
			return "/404";
		}
	}
	
	@GetMapping("/djeke-djole/customers")
	public String getCustomers(@RequestParam(name="page",required = false,defaultValue = "1")String page,
			@RequestParam(name="sd",required = false,defaultValue = "DESC")String sd,
			@RequestParam(name="sb",required = false,defaultValue = "firstName")String sb,
			Model model) {
		
		Page<Customer> customers = customersRepositoryImpl.getAll(page, sd, sb, 20);
		
		model.addAttribute("customers", customers);
		model.addAttribute("sortBy",sb);
		model.addAttribute("sortDirection",sd.toUpperCase());
		
		
		
		return "customers";
		
	}
	
	@GetMapping("/djeke-djole/customer/{customerId}")
	public String getCustomer(@PathVariable Integer customerId,Model model) {
		Customer customer = customersRepositoryImpl.getById(customerId);
		if(customer.getId() != 0) {
		
		
			
			model.addAttribute("customer",customer);
			model.addAttribute("orders",customer.getOrders());

			
			return "customer-single";
		}
		else {
			return "/404";
		}
	}
	
	
	
	@GetMapping("/djeke-djole/categories")
	public String getCategories(Model model) {
		List<Category> categories = categoryRepositroy.findAll();
		model.addAttribute("categories",categories);
		return "categories-managment";
	}
	
	@GetMapping("/djeke-djole/category/{id}")
	public String getCategory(Model model,@PathVariable Integer id) {
		
		Optional<Category> category = categoryRepositroy.findById(id);
		
		if(!category.isPresent()) {
			model.addAttribute("error","Category Not Found");
			return "errorPage";
		}
		
		Category category2 = category.get();
		
		
		
		
		model.addAttribute("category",category2);
		
		model.addAttribute("subcategories",category2.getSubcategories());
		return "category-single";
	}
	
	@PostMapping("/djeke-djole/edit-category/{id}")
	public String editCategory(Model model,@PathVariable Integer id,@RequestParam(required = true,name="categoryName") String name) {
		
		
		Optional<Category> category = categoryRepositroy.findById(id);
		
		
		if(!category.isPresent()) {
			model.addAttribute("error","Kategorija sa datim ID-om ne postoji!");
			return "errorPage";
		}
		
		
		Category category2 = category.get();
		
		
		category2.setName(name);
		
		categoryRepositroy.save(category2);
		
		List<Category> categories = categoryRepositroy.findAll();
		model.addAttribute("categories",categories);
		return "categories-managment";
	}
	
	
	@PostMapping("/djeke-djole/save-category")
	public String saveCategory(Model model,@RequestParam("categoryName")String name,
			@RequestParam("description")String description,@RequestParam("title")String title) {
		
		
		Category category = new Category();

		String link = name.trim().toLowerCase().replace(" ", "-");

		
		category.setName(name);

		category.setCategoryLink(link);
		category.setDescription(description);
		category.setTitle(title);
		categoryRepositroy.save(category);
		
		
		
		List<Category> categories = categoryRepositroy.findAll();
		model.addAttribute("categories",categories);
		return "categories-managment";
		
	}
	
	@PostMapping("/djeke-djole/edit-subcategory/{id}")
	public String editSubCategory(Model model,@PathVariable Integer id,@RequestParam(required = true,name="subcategoryName") String name) {
		
		
		Optional<Subcategory> subcategory = subcategoryRepository.findById(id);
		
		
		if(!subcategory.isPresent()) {
			model.addAttribute("error","Podkategorija sa datim ID-om ne postoji!");
			return "errorPage";
		}
		
		
		Subcategory subcategory2 = subcategory.get();
		
		
		subcategory2.setName(name);
		
		subcategoryRepository.save(subcategory2);
		
		Category category = subcategory2.getCategory();
		
		
		List<Subcategory> subcategories = subcategoryRepository.findAll();
		model.addAttribute("category",category);
		model.addAttribute("subcategories",subcategories);
		return "category-single";
	}
	
	@PostMapping("/djeke-djole/save-subcategory")
	public String saveSubcategory(Model model,@RequestParam("subcategoryName")String name,
			@RequestParam("description")String description,@RequestParam("title")String title,@RequestParam("categoryId")Integer categoryId) {
		
		
		Subcategory subcategory = new Subcategory();

		String link = name.trim().toLowerCase().replace(" ", "-");

		
		subcategory.setName(name);
		subcategory.setLink(link);
		
		subcategory.setDescription(description);
		subcategory.setTitle(title);
		Optional<Category> category = categoryRepositroy.findById(categoryId);
		if(!category.isPresent()) {
			model.addAttribute("error","Kategorija sa datim ID-om ne postoji!");
			return "errorPage";
		}
		subcategory.setCategory(category.get());
		subcategoryRepository.save(subcategory);
		
		
		
		
		
		List<Subcategory> subcategories = subcategoryRepository.findAll();
		model.addAttribute("category",category.get());
		model.addAttribute("subcategories",subcategories);
		
		return "category-single";
		
	}
	
	
	@PostMapping("/djeke-djole/delete-category")
	public String deleteCategory(Model model, @RequestParam("categoryId") Integer id) {
		
		
		
		categoryRepositroy.deleteById(id);
		
		List<Category> categories = categoryRepositroy.findAll();
		model.addAttribute("categories",categories);
		return "categories-managment";
	}
	
	
	@PostMapping("/djeke-djole/delete-subcategory")
	public String deleteSubcategory(Model model, @RequestParam("subcategoryId") Integer id) {
		
		
		Optional<Subcategory> subcategory = subcategoryRepository.findById(id);
		
		
		
		
		if(!subcategory.isPresent()) {
			model.addAttribute("error","Podkategorija sa datim ID-om ne postoji!");
			return "errorPage";
		}
		
		
		Category category = subcategory.get().getCategory();

		subcategoryRepository.delete(subcategory.get());
		
		List<Subcategory> subcategories = subcategoryRepository.findAll();
		model.addAttribute("category",category);
		model.addAttribute("subcategories",subcategories);
		
		return "category-single";
	}
	
}
