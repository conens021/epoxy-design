package com.abstractmedia.projects.epoxydesign.model.product;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.abstractmedia.projects.epoxydesign.model.Category;
import com.abstractmedia.projects.epoxydesign.model.Subcategory;
import com.abstractmedia.projects.epoxydesign.model.order.ProductOrders;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Entity

public class Product implements Serializable {



	private static final long serialVersionUID = 5715207346367333377L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;

	private String name;
	private String title;
	private String description;
	private BigDecimal price;
	private Boolean sale;

	@Column(name="sale_amount")
	private int saleAmount;
	@Column(name="on_stock")
	private int onStock;
	
	private String additionalInfo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdated;


	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<ProductImages> images;


	@JsonIgnore
	@ManyToOne(optional = false,fetch =  FetchType.LAZY)
	@JoinColumn(name="id_subcategory")
	@Nullable
	private Subcategory subcategory;


	@JsonIgnore
	@ManyToOne(optional = false,fetch =  FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category prodCategory;

	@Transient
	private int quantity;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<ProductOrders> productOrders;

	

	public Product(){
		
		this.name = "";
		this.title = "";
		this.description = "";
		this.price = new BigDecimal(0.00);
		this.sale = false;
		this.saleAmount = 0;
		this.onStock = 0;
		this.images = new ArrayList<ProductImages>();
		this.quantity = 0;
		this.additionalInfo = "";
	}

	
	public Product( String name, String title, String description, BigDecimal price, Boolean sale,
			int saleAmount, int onStock, List<ProductImages> images,
			 int quantity,Date createdTime,Date lastUpdated,String additionalInfo) {
	
		
		this.name = name;
		this.title = title;
		this.description = description;
		this.price = price;
		this.sale = sale;
		this.saleAmount = saleAmount;
		this.onStock = onStock;
		this.images = images;
		this.createdTime =createdTime;
		this.quantity = quantity;
		this.lastUpdated = lastUpdated;
		this.additionalInfo = additionalInfo;
	}


	


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}/**
	 * @return the onStock
	 */
	public int getOnStock() {
		return onStock;
	}/**
	 * @return the price
	 */
	
	public BigDecimal getOriginalPrice() {
		return price.setScale(2,RoundingMode.HALF_EVEN);
	}
	public BigDecimal getPrice() {
		if(this.sale) {
			return calcDiscount().setScale(2,RoundingMode.HALF_EVEN);
		}
		return  price.setScale(2).setScale(2,RoundingMode.HALF_EVEN);
	}/**
	 * @return the sale
	 */
	public Boolean onSale() {
		return sale;
	}/**
	 * @return the saleAmount
	 */
	public int getSaleAmount() {
		return saleAmount;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}/**
	 * @param onStock the onStock to set
	 */
	public synchronized void  setOnStock(int onStock) {
		this.onStock = onStock;
	}/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}/**
	 * @param sale the sale to set
	 */
	public void setOnSale(Boolean sale) {
		this.sale = sale;
	}/**
	 * @param saleAmount the saleAmount to set
	 */
	public void setSaleAmount(int saleAmount) {
		this.saleAmount = saleAmount;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @param images the images to set
	 */
	public void setImages(List<ProductImages> images) {
		this.images = images;
	}
	/**
	 * @return the images
	 */
	public List<ProductImages> getImages() {
		return images;
	}

	/**
	 * @return the subcategory
	 */
	public Subcategory getSubcategory() {
		return subcategory;
	}

	/**
	 * @param subcategory the subcategory to set
	 */
	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}


	/**
	 * @return the prodCategory
	 */
	public Category getProdCategory() {
		return prodCategory;
	}

	/**
	 * @param prodCategory the prodCategory to set
	 */
	public void setProdCategory(Category prodCategory) {
		this.prodCategory = prodCategory;
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
	 * @param sale the sale to set
	 */
	public void setSale(Boolean sale) {
		this.sale = sale;
	}


	/**
	 * @return the sale
	 */
	public Boolean getSale() {
		return sale;
	}

	
	
	

	public Date getLastUpdated() {
		return lastUpdated;
	}
	
	


	public String getAdditionalInfo() {
		return additionalInfo;
	}


	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}


	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}


	public Date getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}


	public List<ProductOrders> getProductOrders() {
		return productOrders;
	}


	public void setProductOrders(List<ProductOrders> productOrders) {
		this.productOrders = productOrders;
	}


	public BigDecimal calcDiscount(){
		return this.price.subtract(
				this.price.multiply(new BigDecimal(this.saleAmount).divide(new BigDecimal(100)))).setScale(2,RoundingMode.HALF_EVEN) ; 
		

	}

	
	public BigDecimal calcSaveAmount() {
		return this.getOriginalPrice().multiply(new BigDecimal(this.saleAmount).divide(new BigDecimal(100))).setScale(2,RoundingMode.HALF_EVEN) ;
	}

	public BigDecimal totalPrice(){
		return this.getPrice().multiply(new BigDecimal(this.quantity)).setScale(2,RoundingMode.HALF_EVEN);
	}


}