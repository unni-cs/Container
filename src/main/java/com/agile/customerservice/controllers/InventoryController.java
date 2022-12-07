package com.agile.customerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agile.customerservice.models.Inventory;
import com.agile.customerservice.services.IInventoryService;

@RestController
public class InventoryController {

	@Autowired
	private IInventoryService inventoryService;
	
	@GetMapping("/api/inventory")
	public ResponseEntity<Iterable<Inventory>> getAll() {	
		return ResponseEntity.ok(inventoryService.inventory());
	}
	
	@PostMapping("/api/inventory/update")
	public ResponseEntity<Inventory> update(@RequestBody Inventory inventory) {	
		Inventory updatedInventory = inventoryService.save(inventory);
		return ResponseEntity.ok(updatedInventory);
	}
	
}
