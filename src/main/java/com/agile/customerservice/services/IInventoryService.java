package com.agile.customerservice.services;

import com.agile.customerservice.common.Brand;
import com.agile.customerservice.models.Inventory;

public interface IInventoryService {

	Inventory save(Inventory inventory);
	
	Inventory getInventory(Brand brand);

	Iterable<Inventory> inventory();

	boolean isAvailable(Brand vehicle);
	
	Inventory removeStock(Brand vehicle, int removeCount);

}