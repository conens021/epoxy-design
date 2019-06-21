package com.abstractmedia.projects.epoxydesign.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.abstractmedia.projects.epoxydesign.features.Cart;
import com.abstractmedia.projects.epoxydesign.features.CartResponse;
import com.abstractmedia.projects.epoxydesign.features.CartUpdateRequest;
import com.abstractmedia.projects.epoxydesign.features.SessionHelper;

import com.abstractmedia.projects.epoxydesign.model.product.Product;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private SessionHelper sessionHelper;

    @Autowired
    private Cart cart;


  

    @PostMapping("/add-to-cart")
   
    public CartResponse addToCart(HttpSession session, @RequestParam int id, @RequestParam int quantity) {
       
        Map<Integer,Product> sessionCart = cart.addToCart(session, id, quantity);

        List<Product> cartItems = cart.getCartItems(sessionCart);
        
        for(Product p : cartItems) {
        	System.out.println(p.getName() + " Q;" + p.getQuantity() );
        }

        return new CartResponse(cartItems, cartItems.size(),cart.calcCartSubTotal(cartItems));
    }

    @PostMapping("/remove-from-cart")
   
    public ResponseEntity<CartResponse> removeFromCart(HttpSession session,@RequestParam int id){

       if(cart.removeFromCart(session, id)){
           
            List<Product> items = cart.getCartItems(sessionHelper.getCart(session));
            BigDecimal subtotal = cart.calcCartSubTotal(items);
            BigDecimal tax = cart.getTAX(subtotal);
            BigDecimal total = cart.cartTotal(tax, subtotal);

            return new ResponseEntity<CartResponse>(new CartResponse(items,subtotal,total,tax,items.size()), HttpStatus.OK);
       }

       else return new ResponseEntity<CartResponse>(new CartResponse(),HttpStatus.NOT_FOUND);
        
    }


    @PostMapping(path = "/update-cart",consumes ="application/json;charset=UTF-8")

    public ResponseEntity<CartResponse> updateCart(HttpSession session ,
     @RequestBody List<CartUpdateRequest> products){

        Map<Integer,Product> sessionCart = sessionHelper.getCart(session);

        for(CartUpdateRequest cp : products){
            if(sessionCart.containsKey(cp.getId())){
                Product p = sessionCart.get(cp.getId());
                p.setQuantity(cp.getQuantity());
            }
        }

        session.setAttribute("cart", sessionCart);
        
        List<Product> items = cart.getCartItems(sessionHelper.getCart(session));
        BigDecimal subtotal = cart.calcCartSubTotal(items);
        BigDecimal tax = cart.getTAX(subtotal);
        BigDecimal total = cart.cartTotal(tax, subtotal);

        return new ResponseEntity<CartResponse>(new CartResponse(items,subtotal,total,tax,items.size()), HttpStatus.OK);
    }
 
}