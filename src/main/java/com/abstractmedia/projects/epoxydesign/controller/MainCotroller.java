package com.abstractmedia.projects.epoxydesign.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abstractmedia.projects.epoxydesign.features.Cart;
import com.abstractmedia.projects.epoxydesign.features.DomainInfo;
import com.abstractmedia.projects.epoxydesign.features.SessionHelper;
import com.abstractmedia.projects.epoxydesign.model.Category;
import com.abstractmedia.projects.epoxydesign.model.Customer;
import com.abstractmedia.projects.epoxydesign.model.product.Product;
import com.abstractmedia.projects.epoxydesign.services.product.ProductRepository;
import com.abstractmedia.projects.epoxydesign.services.product.ProductRepositoryImpl;

@Controller
public class MainCotroller {
	
	
	@Autowired
	private ProductRepositoryImpl productRepositoryImpl;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SessionHelper sessionHelper;

	@Autowired
	private Cart cart;

	
	/* INDEX PAGE */
	@GetMapping("/")
	public String getIndex(Model model) {
		
		
		

		return "index";
	}

	/* SHOP PAGE */
	@GetMapping("/products")
	public String getShop(Model model,HttpSession session,
							@RequestParam(value="page",required = false,defaultValue = "1") String page,
							@RequestParam(value="sb",required = false,defaultValue = "saleAmount")String sortBy,
							@RequestParam(value="sd",required = false,defaultValue = "DESC")String direction) {
	
		
		Page<Product> products = productRepositoryImpl.findAllProducts(page, direction, sortBy,20);
		
		model.addAttribute("products",products);
		model.addAttribute("sb", sortBy);
		model.addAttribute("sd", direction);
		
		
		List<Category> categories = sessionHelper.getCategories(session);
		
		List<String> categoryNames = new ArrayList<>();
		
		for(Category c : categories) {
			categoryNames.add(c.getName());
		}
			
		
		model.addAttribute("title",String.format("%s %s",DomainInfo.getDomainName(),StringUtils.join(categoryNames,',')));
		
		model.addAttribute("categories",categories);
		
		
		
		Map<Integer,Product> sessionCart = sessionHelper.getCart(session);
		List<Product> cartItems = cart.getCartItems(sessionCart);
		model.addAttribute("cartItems", cartItems);
		model.addAttribute("cartTotal", cart.calcCartSubTotal(cartItems));
		
		return "all-products";
	}




	@GetMapping("/checkout")
	public String getCheckout(Model model,HttpSession session) {


		model.addAttribute("categories",sessionHelper.getCategories(session));
		Map<Integer,Product> sessionCart = sessionHelper.getCart(session);
		List<Product> cartItems = cart.getCartItems(sessionCart);
		model.addAttribute("cartItems", cartItems);
		model.addAttribute("cartTotal", cart.calcCartSubTotal(cartItems));
	
	
       
        BigDecimal cartSubtotal = cart.calcCartSubTotal(cartItems).setScale(2, RoundingMode.HALF_EVEN);
	
        BigDecimal tax = cart.getTAX(cartSubtotal).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal total = cart.cartTotal(tax, cartSubtotal).setScale(2, RoundingMode.HALF_EVEN);

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("cartSubtotal", cartSubtotal);
        model.addAttribute("cartTotal", total);
        model.addAttribute("tax", tax);
        model.addAttribute("customer",new Customer());
        model.addAttribute("title",String.format("Checkout - %s",DomainInfo.getDomainName()));
		return "checkout";
	}


	@GetMapping("/cart")
    public String getCart(Model model, HttpSession session) {

        model.addAttribute("categories", sessionHelper.getCategories(session));
        
        Map<Integer,Product> sessionCart = sessionHelper.getCart(session);
		
        List<Product> cartItems = cart.getCartItems(sessionCart);
       
        BigDecimal cartSubtotal = cart.calcCartSubTotal(cartItems).setScale(2, RoundingMode.HALF_EVEN);
	
        BigDecimal tax = cart.getTAX(cartSubtotal).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal total = cart.cartTotal(tax, cartSubtotal).setScale(2, RoundingMode.HALF_EVEN);

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("cartSubtotal", cartSubtotal);
        model.addAttribute("cartTotal", total);
        model.addAttribute("tax", tax);
        model.addAttribute("title",String.format("Shoping Cart - %s",DomainInfo.getDomainName()));
        return "cart";
    }
	
	
	@GetMapping("/favicon.ico")
	public String getFavicon() {
		return "images/favicon.ico";
	}
	
	


}
