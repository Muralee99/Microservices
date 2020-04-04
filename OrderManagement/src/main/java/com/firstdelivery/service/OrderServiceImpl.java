package com.firstdelivery.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstdelivery.model.Order;
import com.firstdelivery.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository OrderRepository;

	@Override
	public Order findOrder(String orderId) {
		Optional<Order> order = OrderRepository.findById(orderId);
		return order.get();
	}

	@Override
	public Order createOrder(Order order) {
		Order createdOrder = OrderRepository.save(order);
		return createdOrder;
	}

	@Override
	public Order updateOrder(Order order) {
		Order updatedOrder = OrderRepository.save(order);
		return updatedOrder;
	}

	@Override
	public boolean deleteOrder(Order order) {
		OrderRepository.delete(order);
		return true;
	}

}
