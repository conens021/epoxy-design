package com.abstractmedia.projects.epoxydesign.controller.admin;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.abstractmedia.projects.epoxydesign.model.Customer;
import com.abstractmedia.projects.epoxydesign.model.order.Orders;
import com.abstractmedia.projects.epoxydesign.model.order.ProductOrders;
import com.abstractmedia.projects.epoxydesign.model.product.Product;
import com.abstractmedia.projects.epoxydesign.services.customer.CustomersRepositoryImpl;
import com.abstractmedia.projects.epoxydesign.services.orders.OrdersRepositoryImpl;
import com.abstractmedia.projects.epoxydesign.services.product.ProductRepositoryImpl;


@Controller
public class AdminController {
	
	
	@Autowired
	private ProductRepositoryImpl productRepositoryImpl;
	@Autowired
	private OrdersRepositoryImpl ordersRepositoryImpl;
	@Autowired
	private CustomersRepositoryImpl customersRepositoryImpl;

	
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
	
	
	
	@GetMapping("/djeke-djole/orders")
	public String getOrders(@RequestParam(name="page",required = false,defaultValue = "1")String page,
							@RequestParam(name="sd",required = false,defaultValue = "ASC")String sd,
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
	
}
