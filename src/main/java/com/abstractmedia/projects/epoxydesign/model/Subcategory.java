package com.abstractmedia.projects.epoxydesign.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.abstractmedia.projects.epoxydesign.model.product.Product;


@Entity

public class Subcategory implements Serializable{
	private static final long serialVersionUID = 4450598580372217373L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_subcategory")
	private int id;
	
	private String name;
	private String title;
	private String link;
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id", nullable=false)
	private Category category;
	

	@OneToMany(cascade =  CascadeType.ALL,mappedBy = "subcategory")
	private List<Product> products;
	
	
	public Subcategory() {
		super();
	}
	
	public Subcategory(int id, String name, String title, String link,String description) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.link = link;
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


	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
