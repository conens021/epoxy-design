package com.abstractmedia.projects.epoxydesign.model.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity

public class ProductImages implements Serializable{

    private static final long serialVersionUID = -2356082404412614442L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_product_image")
    private int id;

    @Column(name="image_url")
    private String imageUrl;


    @JsonIgnore
    @JoinColumn(name="product_id",referencedColumnName = "product_id")
    @ManyToOne(optional = false)
    private Product product;


    public ProductImages(){
        super();
    }

    public ProductImages(String imageUrl){
        this.imageUrl = imageUrl;
    }

    
    public ProductImages(int id,String imageUrl){
        this.id = id;
        this.imageUrl = imageUrl;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }
    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @param imageUrl the imageUrl to set
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }
    
}