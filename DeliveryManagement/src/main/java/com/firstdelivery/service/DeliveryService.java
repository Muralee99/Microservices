package com.firstdelivery.service;

import com.firstdelivery.model.Delivery;

public interface DeliveryService {

	public Delivery getDelivery(Long deliveryId);
	
	public Delivery saveDelivery(Delivery delivery);
	
	public Delivery updateDelivery(Delivery delivery);
	
	public boolean deleteDelivery(Long deliveryId);
	
}
