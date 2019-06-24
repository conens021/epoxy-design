package com.abstractmedia.projects.epoxydesign.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.abstractmedia.projects.epoxydesign.features.Cart;
import com.abstractmedia.projects.epoxydesign.features.CustomEmail;

import com.abstractmedia.projects.epoxydesign.features.SessionHelper;
import com.abstractmedia.projects.epoxydesign.model.Customer;
import com.abstractmedia.projects.epoxydesign.model.order.Orders;
import com.abstractmedia.projects.epoxydesign.model.order.ProductOrders;
import com.abstractmedia.projects.epoxydesign.model.product.Product;
import com.abstractmedia.projects.epoxydesign.services.OrdersRepository;

@Controller
public class OrderController {
	
	
	@Autowired
	private SessionHelper sessionHelper;
	
	@Autowired
	private OrdersRepository ordersRepisotry;
	
	@Autowired 
	private Cart cart;
	
	@Autowired
	private CustomEmail email;

	
	
	@PostMapping(path="place-order",consumes = "application/x-www-form-urlencoded;charset=UTF-8")
	public String placeOrder(Model model,@Valid @ModelAttribute(name="customer")  Customer customer,BindingResult result
			,HttpSession session) {
		
		if(result.hasErrors()){
			return "/checkout";
		}
		
		
		Map<Integer, Product> sessionCart = sessionHelper.getCart(session);
		
		
		List<Product> cartItems = cart.getCartItems(sessionCart);
		
		
		List<ProductOrders> productOrders = new ArrayList<>();
		
		List<Product> items = cart.getCartItems(sessionHelper.getCart(session));
	    BigDecimal subtotal = cart.calcCartSubTotal(items);
	    BigDecimal tax = cart.getTAX(subtotal);
	    BigDecimal total = cart.cartTotal(tax, subtotal);
		
		for(Product p : cartItems) {
			ProductOrders po = new ProductOrders();
			
			po.setProduct(p);
			po.setQuantity(p.getQuantity());
			productOrders.add(po);
		}
		
		
		Orders order = new Orders(subtotal, total, tax, productOrders);
		order.setCustomer(customer);
		
		
		//Orders savedOrder = ordersRepisotry.save(order);
		

		
		
		email.setFrom(customer.getEmail());
		email.setFromName("Epoxy Design Orders");
		email.setSubject(String.format("Order %d", order.getId()));
		
		email.setMsg(String.format("You have new order\n"
				+ "Customer name : %s %s\n"
				+ "Email : %s\n"
				+ "Phone number : %s\n"
				+"Company : %s\n"
				+"Note : %s\n"
				+ "For more information about order follow next link:\nhttp://localhost:8081/admin/order/%s",
				customer.getFirstName(),customer.getLastName(),customer.getEmail()
				,customer.getPhoneNumber(),customer.getCompany(),customer.getNote(),order.getId()));
	
		email.sendMessage();
		
		
		session.setAttribute("cart", new HashMap<Integer,Product>());
		
		return "redirect:/products";
	}
	
}
