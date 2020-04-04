package com.firstdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firstdelivery.model.Inventory;
import com.firstdelivery.model.Item;
import com.firstdelivery.service.InventoryService;

@RestController
public class InventoryController {
	
	@Autowired(required = true)
	private InventoryService inventoryService;
	
	@RequestMapping(value="/api/v1/inventory/{inventoryId}", method=RequestMethod.GET)
	public ResponseEntity<Inventory> getInventory(@PathVariable(value = "inventoryId") Long inventoryId){
		Inventory inventory =  inventoryService.findInventoryById(inventoryId);
		return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/v1/inventory/{inventoryId}/item/{itemId}", method=RequestMethod.GET)
	public ResponseEntity<Inventory> getInventoryItem(@PathVariable String inventoryId, @PathVariable String itemId){
		Inventory inventory =  inventoryService.findItemFromInventory(Long.valueOf(inventoryId), itemId);
		return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/v1/inventory", method=RequestMethod.POST)
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory){
		inventoryService.createInventory(inventory);
		return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/v1/inventory", method=RequestMethod.PUT)
	public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory){
		inventoryService.createInventory(inventory);
		return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/v1/inventory/{inventoryId}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteInventory(@PathVariable(value = "inventoryId") Long inventoryId){
		inventoryService.deleteInventory(inventoryId);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

}
