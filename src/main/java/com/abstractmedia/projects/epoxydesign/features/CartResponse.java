package com.abstractmedia.projects.epoxydesign.features;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.abstractmedia.projects.epoxydesign.model.product.Product;

public class CartResponse implements Serializable{

    private static final long serialVersionUID = 1L;


    private List<Product> products;
    private int quantity;
    private BigDecimal cartTotal;
    private BigDecimal cartSubtotal;
    private BigDecimal tax;


    public CartResponse(){
        super();
    }

    public CartResponse( List<Product> products , int quantity,BigDecimal cartSubtotal){
        this.products = products;
        this.quantity = quantity;
        this.cartSubtotal = cartSubtotal;
    }

    public CartResponse(List<Product> items,BigDecimal cartSubtotal,BigDecimal cartTotal,BigDecimal tax,int quantity){
        this.products = items;
        this.cartSubtotal = cartSubtotal;
        this.cartTotal = cartTotal;
        this.tax = tax;
        this.quantity  = quantity;
    }

    /**
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }
    /**
     * @param products the products to set
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @param cartTotal the cartTotal to set
     */
    public void setCartTotal(BigDecimal cartTotal) {
        this.cartTotal = cartTotal;
    }

    /**
     * @return the cartTotal
     */
    public BigDecimal getCartTotal() {
        return cartTotal;
    }

    /**
     * @return the cartSubtotal
     */
    public BigDecimal getCartSubtotal() {
        return cartSubtotal;
    }

    /**
     * @return the tax
     */
    public BigDecimal getTax() {
        return tax;
    }


    /**
     * @param cartSubtotal the cartSubtotal to set
     */
    public void setCartSubtotal(BigDecimal cartSubtotal) {
        this.cartSubtotal = cartSubtotal;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
}