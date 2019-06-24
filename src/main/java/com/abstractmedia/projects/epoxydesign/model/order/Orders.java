package com.abstractmedia.projects.epoxydesign.model.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.abstractmedia.projects.epoxydesign.model.Customer;

@Entity
public class Orders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4919548017016303036L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	@NotNull

	private BigDecimal subtotal;
	
	@NotNull

	private BigDecimal total;
	
	@NotNull

	private BigDecimal tax;
	
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
	private List<ProductOrders> productOrders;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(
			BigDecimal subtotal,
			 BigDecimal total,
			 BigDecimal tax,
			List<ProductOrders> productOrders) {
		super();
	
		this.subtotal = subtotal;
		this.total = total;
		this.tax = tax;
		for(ProductOrders producOrders : productOrders) {
			producOrders.setOrders(this);
		}
		this.productOrders = productOrders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

	public List<ProductOrders> getProductOrders() {
		return productOrders;
	}

	public void setProductOrders(List<ProductOrders> productOrders) {
		this.productOrders = productOrders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + id;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((productOrders == null) ? 0 : productOrders.hashCode());
		result = prime * result + ((subtotal == null) ? 0 : subtotal.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id != other.id)
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (productOrders == null) {
			if (other.productOrders != null)
				return false;
		} else if (!productOrders.equals(other.productOrders))
			return false;
		if (subtotal == null) {
			if (other.subtotal != null)
				return false;
		} else if (!subtotal.equals(other.subtotal))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

	

	
	
	
	
	
}
