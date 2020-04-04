package com.firstdelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DELIVERY_INVENTORY")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INVENTORY_ID")
	private Long id;
	
	@Column(name="ITEM_ID")
	private String itemId;
	
	@Column(name="REQUEST_DATE")
	private String requestDate;
	
	@Column(name="INVENTORY_STATUS")
	private String inventoryStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(String inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	
	
	
}
