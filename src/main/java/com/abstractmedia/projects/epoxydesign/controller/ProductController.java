package com.abstractmedia.projects.epoxydesign.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.abstractmedia.projects.epoxydesign.features.Cart;
import com.abstractmedia.projects.epoxydesign.features.DomainInfo;
import com.abstractmedia.projects.epoxydesign.features.SessionHelper;
import com.abstractmedia.projects.epoxydesign.model.product.Product;
import com.abstractmedia.projects.epoxydesign.services.ProductRepository;
import com.abstractmedia.projects.epoxydesign.services.ProductRepositoryImpl;

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

    @GetMapping("/product/{name}")
    public String getProductPage(Model model, HttpSession session, @PathVariable(required = true) String name) {

        try {
            Integer id = Integer.valueOf(name.split("-")[0].trim());
            Optional<Product> product = productRepository.findById(id);

            if (product.isPresent()) {

                Page<Product> releatedProducts = productRepositoryImpl.getReleated(product.get().getProdCategory(), "1",
                        "asc", "onStock", 8, id);
                model.addAttribute("releated", releatedProducts.getContent());

                model.addAttribute("categories", sessionHelper.getCategories(session));
                model.addAttribute("product", product.get());

                Map<Integer,Product> sessionCart = sessionHelper.getCart(session);
                List<Product> cartItems = cart.getCartItems(sessionCart);
                model.addAttribute("cartItems", cartItems);
                model.addAttribute("cartTotal", cart.calcCartSubTotal(cartItems));
        		model.addAttribute("title",
    					String.format("%s - %s", product.get().getTitle(), DomainInfo.getDomainName()));
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