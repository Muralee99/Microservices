package com.firstdelivery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.firstdelivery.model.Inventory;
import com.firstdelivery.model.Order;
import com.firstdelivery.service.OrderService;

/*
 * 
 */

@RestController
public class OrderController {
	
	protected final Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired(required = true)
	private OrderService orderService;
	
    RestTemplate restTemplate = new RestTemplate();

	
	@RequestMapping(value = "/api/v1/order", method = RequestMethod.POST, consumes={"application/json"})
	public ResponseEntity<Order> placeOrder(@RequestBody Order order){
		Order newOrder = null;
		String inventoryStatus = null;
		try {
			/*
			 * localhost:20128// Order orderR = restTemplate
			 * .getForObject("https://api.github.com/users/{username}", Order.class,
			 * order.getOrderId()); // return user;
			 */
			
			Inventory orderTempResponse = restTemplate.getForObject("http://localhost:20128/api/v1/inventory/12345678/item/item1", Inventory.class);
			inventoryStatus = orderTempResponse.getInventoryStatus();
			
			//newOrder = orderService.createOrder(order);
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		if(order != null && inventoryStatus.equals("A")) {
			return new ResponseEntity<Order>(order, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/api/v1/order", method = RequestMethod.PUT)
	public ResponseEntity<Order> updateOrder(@RequestBody Order order){
		Order orderUpdated = null;
		try {
			orderUpdated = orderService.updateOrder(order);
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		if(orderUpdated != null) {
			return new ResponseEntity<Order>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/api/v1/order/{orderId}", method = RequestMethod.GET)
	public Order getOrders(@PathVariable String orderId){
		Order order = null;
		
		try {
			order = orderService.findOrder(orderId);
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		if(order != null) {
			return order;
		}else {
			return null;
		}
	}
	
	@RequestMapping(value = "/api/v1/order", method = RequestMethod.DELETE)
	public ResponseEntity<Order> deleteOrder(String orderId){
		boolean orderDeleted = false;
		
		try {
			orderDeleted = orderService.deleteOrder(new Order(orderId));
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		if(orderDeleted) {
			return new ResponseEntity<Order>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Generate JWT token
	/*
	 * public String getToken(final String username, final String password) throws
	 * Exception { return (Jwts.builder().setSubject(username)
	 * .claim(user.getUserRole(), user.getUserId()).setIssuedAt(new Date())
	 * .signWith(SignatureAlgorithm.HS256, "secretkey").compact());
	 * 
	 * }
	 */
}
