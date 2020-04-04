package com.firstdelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FIRSTDELIVERY_DELIVERY")
public class Delivery {
	
	@Id
	@Column(name="DELIVERY_ID")
	private Long deliveryId;
	
	@Column(name="ORDER_ID")
	private String orderId;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="STATUS")
	private String status;

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
