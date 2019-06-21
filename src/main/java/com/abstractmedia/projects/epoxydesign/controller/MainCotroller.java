package com.abstractmedia.projects.epoxydesign.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
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
import com.abstractmedia.projects.epoxydesign.model.product.Product;

import com.abstractmedia.projects.epoxydesign.services.ProductRepositoryImpl;

@Controller
public class MainCotroller {
	
	
	@Autowired
	private ProductRepositoryImpl productRepositoryImpl;

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
							@RequestParam(value="sb",required = false,defaultValue = "onStock")String sortBy,
							@RequestParam(value="sd",required = false,defaultValue = "ASC")String direction) {
	
		
		Page<Product> products = productRepositoryImpl.findAllProducts(page, direction, sortBy,20);
		
		model.addAttribute("products",products);

		model.addAttribute("sb", sortBy);
		model.addAttribute("sd", direction);
		
		model.addAttribute("title",String.format("Shop - %s",DomainInfo.getDomainName()));
		
		model.addAttribute("categories",sessionHelper.getCategories(session));
		
		
		for(Category cat : sessionHelper.getCategories(session)) {
			System.out.println(cat.getName());
		}
		
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
	
	
       
        BigDecimal cartSubtotal = cart.calcCartSubTotal(cartItems);
	
        BigDecimal tax = cart.getTAX(cartSubtotal);
        BigDecimal total = cart.cartTotal(tax, cartSubtotal);

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("cartSubtotal", cartSubtotal);
        model.addAttribute("cartTotal", total);
        model.addAttribute("tax", tax);
		return "checkout";
	}


	@GetMapping("/cart")
    public String getCart(Model model, HttpSession session) {

        model.addAttribute("categories", sessionHelper.getCategories(session));
        
        Map<Integer,Product> sessionCart = sessionHelper.getCart(session);
		
        List<Product> cartItems = cart.getCartItems(sessionCart);
       
        BigDecimal cartSubtotal = cart.calcCartSubTotal(cartItems);
	
        BigDecimal tax = cart.getTAX(cartSubtotal);
        BigDecimal total = cart.cartTotal(tax, cartSubtotal);

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("cartSubtotal", cartSubtotal);
        model.addAttribute("cartTotal", total);
        model.addAttribute("tax", tax);
        return "cart";
    }

}
