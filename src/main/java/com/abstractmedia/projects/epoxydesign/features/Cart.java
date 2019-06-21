package com.abstractmedia.projects.epoxydesign.features;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import com.abstractmedia.projects.epoxydesign.model.product.Product;
import com.abstractmedia.projects.epoxydesign.services.ProductRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class Cart {

    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    ProductRepositoryImpl productRepositoryImpl;


    private final float TAX = 5.00f; 

    public List<Product> getCartItems(Map<Integer, Product> cart) {
        List<Product> list = new ArrayList<>();

        for (Entry<Integer, Product> p : cart.entrySet()) {
            list.add(p.getValue());
        }

        return list;
    }

    public Map<Integer, Product> addToCart(HttpSession session, int productId, int quantity) {

        Map<Integer, Product> cart = sessionHelper.getCart(session);

        if (cart.get(productId) != null) {
            System.out.println("update prod qunatity");
            Product prod = cart.get(productId);
            System.out.println(String.format("Prod q:%d adding q %d", prod.getQuantity(), quantity));
            prod.setQuantity(prod.getQuantity() + quantity);
            session.setAttribute("cart", cart);
        } else {
            System.out.println("Adding prod to cart");
            Product prod = productRepositoryImpl.getById(productId);
            prod.setQuantity(quantity);
            cart.put(productId, prod);
            session.setAttribute("cart", cart);
        }

        return cart;
    }

    public boolean removeFromCart(HttpSession session,Integer id){
        Map<Integer, Product> cart = sessionHelper.getCart(session);

        if(cart.containsKey(id)){
            cart.remove(id);
            session.setAttribute("cart",cart);
            return true;
        }

        return false;
    }

    public BigDecimal calcCartSubTotal(List<Product> products) {
        BigDecimal total = new BigDecimal(0.00);

        for (Product p : products) {
            total = total.add(p.getPrice().multiply(BigDecimal.valueOf(p.getQuantity())));
        }
        

        return total;
    }



	public BigDecimal getTAX(BigDecimal subtotal) {
		return subtotal.multiply(new BigDecimal(TAX)).divide(new BigDecimal(100.00));
	}
    
	public BigDecimal cartTotal(BigDecimal taxValue,BigDecimal subtotal){
		return subtotal.add(taxValue);
	}
}