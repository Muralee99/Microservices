package com.firstdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstdelivery.model.Order;

public interface OrderRepository extends JpaRepository<Order, String>{
	
}
