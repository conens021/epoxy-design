package com.abstractmedia.projects.epoxydesign.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abstractmedia.projects.epoxydesign.model.order.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
