package com.abstractmedia.projects.epoxydesign.features;


public class CartUpdateRequest{

    private int id;
    private int quantity;


    public CartUpdateRequest(int id,int quantity){
        this.id = id;
        this.quantity = quantity;
    }


    /**
     * @return the id
     */
    public int getId() {
        return id;
    }


    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
}