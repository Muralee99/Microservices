package com.firstdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstdelivery.model.Inventory;
import com.firstdelivery.model.Item;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{
	
	public Inventory findByItemId(String itemId);
	
	//public Item findItemFromInventory(Long inventoryId, String itemId);
	
}
