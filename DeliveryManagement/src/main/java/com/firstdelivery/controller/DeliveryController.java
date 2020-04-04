package com.firstdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firstdelivery.model.Delivery;
import com.firstdelivery.service.DeliveryService;

@RestController
public class DeliveryController {
	
	@Autowired
	public DeliveryService deliveryService;
	
	@RequestMapping(value = "/api/v1/delivery/{orderId}", method=RequestMethod.GET)
	public ResponseEntity<Delivery> getDelivery(@PathVariable Long orderId){
		
		Delivery delivery = null;
		
		delivery = deliveryService.getDelivery(orderId);
		
		return new ResponseEntity<Delivery>(delivery, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/api/v1/delivery", method=RequestMethod.POST)
	public ResponseEntity<Delivery> saveDelivery(@RequestBody Delivery delivery){
		
		deliveryService.saveDelivery(delivery);
		
		return new ResponseEntity<Delivery>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/api/v1/delivery", method=RequestMethod.PUT)
	public ResponseEntity<Delivery> updateDelivery(@RequestBody Delivery delivery){
		
		deliveryService.saveDelivery(delivery);
		
		return new ResponseEntity<Delivery>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/api/v1/delivery", method=RequestMethod.DELETE)
	public ResponseEntity<Delivery> saveDelivery(@PathVariable Long deliveryId){
		
		deliveryService.deleteDelivery(deliveryId);
		
		return new ResponseEntity<Delivery>(HttpStatus.OK);
		
	}

}
