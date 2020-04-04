package com.firstdelivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstdelivery.model.Inventory;
import com.firstdelivery.model.Item;
import com.firstdelivery.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();
	}
	
	@Override
	public Inventory createInventory(Inventory inventory) {
		Inventory createdInventory = inventoryRepository.save(inventory);
		return createdInventory;
	}

	@Override
	public Inventory updateInventory(Inventory inventory) {
		Inventory updatedInventory = inventoryRepository.save(inventory);
		return updatedInventory;
	}
	
	@Override
	public Inventory findInventoryById(Long inventoryId) {
		Optional<Inventory> inventory = inventoryRepository.findById(inventoryId);
		return inventory.get();
	}

	@Override
	public void deleteInventory(Long inventoryId) {
		Inventory inventory = new Inventory();
		inventory.setId(inventoryId);
		inventoryRepository.delete(inventory); 
	}

	@Override
	public Inventory findItemFromInventory(Long inventoryId, String itemId) {
		return inventoryRepository.findByItemId(itemId);
	}
	 
}
