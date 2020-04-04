package com.firstdelivery.service;

import java.util.List;

import com.firstdelivery.model.Order;

public interface OrderService {

	public Order findOrder(String orderId);
	
	public Order createOrder(Order order);
	
	public Order updateOrder(Order order);
	
	public boolean deleteOrder(Order order);
	
}
