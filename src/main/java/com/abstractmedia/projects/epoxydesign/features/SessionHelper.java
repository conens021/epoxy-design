package com.abstractmedia.projects.epoxydesign.features;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import com.abstractmedia.projects.epoxydesign.model.Category;
import com.abstractmedia.projects.epoxydesign.model.product.Product;
import com.abstractmedia.projects.epoxydesign.services.CategoryRepository;
import com.abstractmedia.projects.epoxydesign.services.ProductRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionHelper {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepositoryImpl productRepositoryImpl;
    
    public List<Category> getCategories(HttpSession session) {
        if (session.getAttribute("categories") != null) {

            return (List<Category>) session.getAttribute("categories");
        } else {

            List<Category> categories = categoryRepository.findAll();
            session.setAttribute("categories", categories);
            return categories;
        }
    }

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