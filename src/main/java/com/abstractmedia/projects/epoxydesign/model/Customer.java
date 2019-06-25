package com.abstractmedia.projects.epoxydesign.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.abstractmedia.projects.epoxydesign.model.order.Orders;

@Entity
public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8336625768984575570L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Cannot be empty")
	
	private String firstName;
	
	@NotNull(message = "Cannot be empty")

	private String lastName;
	
	@NotNull(message ="Cannot be empty")
	@Email(message = "Email not valid")
	private String email;
	
	private String note;
	
	@NotNull(message = "Cannot be empty")
	private String phoneNumber;
	
	@NotNull
	@Size(min=6,message="Not valid personal id")
	private String personalId;
	
	private String company;
	
	
	@OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
	private List<Orders> orders;
	
	
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Customer(int id,
			@NotNull(message = "Cannot be empty") @Min(value = 2, message = "First name to short (min 2 characters)") String firstName,
			@NotNull(message = "Cannot be empty") @Min(value = 2, message = "Last name to short (min 2 characters)") String lastName,
			@NotNull(message = "Cannot be empty") @Email(message = "Email not valid") String email, String note,
			@NotNull(message = "Cannot be empty") String phoneNumber,
			@NotNull @Size(min = 6, message = "Not valid personal id") String personalId, String company,
			List<Orders> orders) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.note = note;
		this.phoneNumber = phoneNumber;
		this.personalId = personalId;
		this.company = company;
		this.orders = orders;
	}








	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getNote() {
		return note;
	}




	public void setNote(String note) {
		this.note = note;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getCompany() {
		return company;
	}




	public void setCompany(String company) {
		this.company = company;
	}




	public List<Orders> getOrders() {
		return orders;
	}




	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public String getPersonalId() {
		return personalId;
	}








	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}








	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + ((personalId == null) ? 0 : personalId.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		Customer other = (Customer) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (personalId == null) {
			if (other.personalId != null)
				return false;
		} else if (!personalId.equals(other.personalId))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}










	
	
	
	
	
	

}
