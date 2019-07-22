package com.abstractmedia.projects.epoxydesign.features;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import com.abstractmedia.projects.epoxydesign.model.product.Product;

import org.springframework.stereotype.Service;

@Service
public class SessionHelper {

  

    @SuppressWarnings("unchecked")
	public Map<Integer, Product> getCart(HttpSession session) {
        if (session.getAttribute("cart") != null) {
            return (Map<Integer, Product>) session.getAttribute("cart");
        } else {
            Map<Integer, Product> cart = new HashMap<>();
            session.setAttribute("cart", cart);
            return cart;
        }
    }

}