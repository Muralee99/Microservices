package com.firstdelivery.service;

import java.util.List;

import com.firstdelivery.model.Inventory;
import com.firstdelivery.model.Item;

public interface InventoryService {
	
	//public Inventory findInventoryByOrderId(String orderId);
	
	//public List<Inventory> findInventory(String inventoryId);
	
	public Inventory createInventory(Inventory inventory);
	
	//spublic Inventory updateInventory(Inventory inventory);
	
	public void deleteInventory(Long inventoryId);

	public List<Inventory> getAllInventory();
	
	public Inventory updateInventory(Inventory inventory);
	
	public Inventory findInventoryById(Long inventoryId);
	
	public Inventory findItemFromInventory(Long inventoryId, String itemId);

	
}
