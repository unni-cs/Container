package com.agile.customerservice.services;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.customerservice.common.Brand;
import com.agile.customerservice.models.Inventory;
import com.agile.customerservice.repositories.InventoryRepository;

@Service
public class InventoryService implements IInventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public Inventory save(Inventory inventory) {
		Inventory existing = getInventory(inventory.getVehicle());
		if(existing != null) {
			existing.setStockCount(inventory.getstockCount());
			return inventoryRepository.save(existing);
		}
		
		return inventoryRepository.save(inventory);
	}
	
	public Inventory getInventory(Brand brand) {
		Optional<Inventory> optionalInventory = StreamSupport.stream(inventory().spliterator(), false).filter(x-> x.getVehicle().equals(brand)).findFirst();
		
		return optionalInventory.isEmpty() ? null : optionalInventory.get();
	}

	public Iterable<Inventory> inventory() {
		return inventoryRepository.findAll();
	}
	
	public boolean isAvailable(Brand vehicle) {
		return StreamSupport.stream(inventory().spliterator(), false).anyMatch(x-> x.getVehicle().equals(vehicle) && x.getstockCount() > 0);
	}
	
	public Inventory removeStock(Brand vehicle, int removeCount) {
		Inventory existing = getInventory(vehicle);
		existing.setStockCount(existing.getstockCount() - removeCount);
		return inventoryRepository.save(existing);
	}
}
