package com.firstdelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstdelivery.model.Delivery;
import com.firstdelivery.repository.DeliveryRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService{
	
	@Autowired
	public DeliveryRepository deliveryRepository;
	
	public Delivery getDelivery(Long deliveryId) {
		return deliveryRepository.findById(deliveryId).get();
	}

	public Delivery saveDelivery(Delivery delivery) {
		deliveryRepository.save(delivery);
		return delivery;
	}
	
	public Delivery updateDelivery(Delivery delivery) {
		deliveryRepository.save(delivery);
		return delivery;
	}
	
	public boolean deleteDelivery(Long deliveryId) {
		deliveryRepository.deleteById(deliveryId);
		return true;
	}
	
}
