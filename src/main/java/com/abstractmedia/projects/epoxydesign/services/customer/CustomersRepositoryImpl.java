package com.abstractmedia.projects.epoxydesign.services.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.abstractmedia.projects.epoxydesign.model.Customer;

@Service
public class CustomersRepositoryImpl {

	
	@Autowired
	private CustomersRepistory customersRepistory;
	
	
	public Page<Customer> getAll(String page,String direction,String sortBy,Integer perPage){
		
		return customersRepistory.findAll(PageRequest.of(
	            Integer.valueOf(page) -1 , perPage,
	            direction.equalsIgnoreCase("asc")? Direction.ASC : Direction.DESC,
	            sortBy ));
	
	}
	
	
	public Customer getByEmail(String email) {
		Optional<Customer> optional = customersRepistory.findByEmail(email);
		if(optional.isPresent())
			return optional.get();
		
		else
			return new Customer();
	}
	
	public Customer getById(Integer id) {
		Optional<Customer> optional = customersRepistory.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		
		else {
			return new Customer();
		}
	}
}
