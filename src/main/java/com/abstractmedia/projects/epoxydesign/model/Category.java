package com.abstractmedia.projects.epoxydesign.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.abstractmedia.projects.epoxydesign.model.product.Product;

@Entity

public class Category implements Serializable{
	private static final long serialVersionUID = 7016137043505199950L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private int id;
	
	private String name;
	private String title;
	@Column(name="category_link")
	private String categoryLink;
	private String description;
	
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
	List<Subcategory> subcategories;
	

	@OneToMany(mappedBy = "prodCategory",fetch = FetchType.LAZY)
	List<Product> products;
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Category(int id, String name, String title, String categoryLink,String description) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.categoryLink = categoryLink;
		this.description = description;
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategoryLink() {
		return categoryLink;
	}

	public void setCategoryLink(String categoryLink) {
		this.categoryLink = categoryLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Subcategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
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
	
	
}
