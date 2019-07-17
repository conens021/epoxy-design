package com.abstractmedia.projects.epoxydesign.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;

import javax.servlet.http.HttpSession;

import com.abstractmedia.projects.epoxydesign.features.Cart;
import com.abstractmedia.projects.epoxydesign.features.DomainInfo;
import com.abstractmedia.projects.epoxydesign.features.SessionHelper;
import com.abstractmedia.projects.epoxydesign.model.product.Product;
import com.abstractmedia.projects.epoxydesign.services.product.ProductRepository;
import com.abstractmedia.projects.epoxydesign.services.product.ProductRepositoryImpl;
import com.abstractmedia.projects.epoxydesign.services.product.ProductServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    private ProductRepositoryImpl productRepositoryImpl;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SessionHelper sessionHelper;

    @Autowired
    private Cart cart;
    
    
    @Autowired
    private ProductServices productServices;
    
    
    @GetMapping("/product/{name}")
    public String getProductPage(Model model, HttpSession session, @PathVariable(required = true) String name) {

        try {
            Integer id = Integer.valueOf(name.split("-")[0].trim());
            Optional<Product> product = productRepository.findById(id);

            if (product.isPresent()) {
            	
                Page<Product> releatedProducts = productRepositoryImpl.getReleated(product.get().getProdCategory(), "1",
                        "asc", "onStock", 8, id);
               

                
                SortedMap<String, String> additionalValues = productServices.getAdditionalValues(product.get().getAdditionalInfo());
                
                
       
                
                Map<Integer,Product> sessionCart = sessionHelper.getCart(session);
                List<Product> cartItems = cart.getCartItems(sessionCart);
                model.addAttribute("releated", releatedProducts.getContent());

                model.addAttribute("categories", sessionHelper.getCategories(session));
                model.addAttribute("product", product.get());
                model.addAttribute("additionalInfo",additionalValues.entrySet());
                model.addAttribute("cartItems", cartItems);
                model.addAttribute("cartTotal", cart.calcCartSubTotal(cartItems));
        		model.addAttribute("title",
    					String.format("%s - %s", product.get().getTitle(), DomainInfo.getDomainName()));
        		 model.addAttribute("description", "Bla bla");
        		 String fbImage = product.get().getImages().get(0).getImageUrl();
        		 model.addAttribute("fbImage",fbImage);
                return "shop-single";
            }
    		model.addAttribute("title",
					String.format("Page Not Found - %s", DomainInfo.getDomainName()));
            model.addAttribute("categories", sessionHelper.getCategories(session));
            return "404";
        } catch (NumberFormatException ex) {
        	model.addAttribute("title",
					String.format("Page Not Found - %s", DomainInfo.getDomainName()));
        	model.addAttribute("categories", sessionHelper.getCategories(session));
            return "404";
        }

    }
    


}