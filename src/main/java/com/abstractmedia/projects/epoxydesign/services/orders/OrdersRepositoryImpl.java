package com.abstractmedia.projects.epoxydesign.services.orders;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.abstractmedia.projects.epoxydesign.model.order.Orders;

@Service
public class OrdersRepositoryImpl {

	@Autowired
	private OrdersRepository ordersRepsitory;
	
	public Page<Orders> getAll(String page,String direction,String sortBy,Integer perPage){
		
		return ordersRepsitory.findAll(PageRequest.of(
	            Integer.valueOf(page) -1 , perPage,
	            direction.equalsIgnoreCase("asc")? Direction.ASC : Direction.DESC,
	            sortBy ));
	}
	
	
	public Orders getById(Integer id) {
		Optional<Orders> optional = ordersRepsitory.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return new Orders();
		}
	}
}
