package com.abstractmedia.projects.epoxydesign.services.customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abstractmedia.projects.epoxydesign.model.Customer;

public interface CustomersRepistory extends JpaRepository<Customer,Integer>  {
	
	Optional<Customer> findByEmail(String email);

}
