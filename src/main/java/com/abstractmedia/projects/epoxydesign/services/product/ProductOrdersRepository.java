package com.abstractmedia.projects.epoxydesign.services.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abstractmedia.projects.epoxydesign.model.order.ProductOrders;

public interface ProductOrdersRepository extends JpaRepository<ProductOrders, Integer> {

}
