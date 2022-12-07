package com.agile.customerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.customerservice.common.Brand;
import com.agile.customerservice.models.Credit;
import com.agile.customerservice.models.Customer;
import com.agile.customerservice.models.Inventory;
import com.agile.customerservice.models.Vehicle;
import com.agile.customerservice.services.ICreditServiceInternal;
import com.agile.customerservice.services.ICustomerService;
import com.agile.customerservice.services.IInventoryService;
import com.agile.customerservice.services.IVehicleService;

@Service
public class DataInitializers {
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IVehicleService vehicleService;
	
	@Autowired
	private IInventoryService inventoryService;
	
	@Autowired
	private ICreditServiceInternal creditService;
	

	public void initializeCustomers() {
		Customer customer1 = new Customer();
		customer1.setName("sean");
		customer1.setCredit(2500);
		customerService.save(customer1);
		
		Customer customer2 = new Customer();
		customer2.setName("jay");
		customer2.setCredit(4300);
		customerService.save(customer2);
	}
	
	public void initializeVehicles() {
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setName(Brand.Ford);
		vehicle1.setDescription("Ford car description");
		vehicleService.save(vehicle1);
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setName(Brand.Ferrari);
		vehicle2.setDescription("Ferrari car description");
		vehicleService.save(vehicle2);
		
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setName(Brand.Bmw);
		vehicle3.setDescription("BMW car description");
		vehicleService.save(vehicle3);
		
		Vehicle vehicle4 = new Vehicle();
		vehicle4.setName(Brand.AstonMartin);
		vehicle4.setDescription("AstonMartin car description");
		vehicleService.save(vehicle4);
		
		Vehicle vehicle5 = new Vehicle();
		vehicle5.setName(Brand.Audi);
		vehicle5.setDescription("Audi car description");
		vehicleService.save(vehicle5);
		
		Vehicle vehicle6 = new Vehicle();
		vehicle6.setName(Brand.Honda);
		vehicle6.setDescription("Honda car description");
		vehicleService.save(vehicle6);
	}
	
	public void initializeInventory() {
		Inventory inventory1 = new Inventory();
		inventory1.setVehicleName(Brand.Ford);
		inventory1.setStockCount(10);
		inventoryService.save(inventory1);
		
		Inventory inventory2 = new Inventory();
		inventory2.setVehicleName(Brand.Ferrari);
		inventory2.setStockCount(4);
		inventoryService.save(inventory2);		
		
		Inventory inventory3 = new Inventory();
		inventory3.setVehicleName(Brand.Bmw);
		inventory3.setStockCount(22);
		inventoryService.save(inventory3);
		
		Inventory inventory4 = new Inventory();
		inventory4.setVehicleName(Brand.Audi);
		inventory4.setStockCount(6);
		inventoryService.save(inventory4);	
		
		Inventory inventory5 = new Inventory();
		inventory5.setVehicleName(Brand.AstonMartin);
		inventory5.setStockCount(1);
		inventoryService.save(inventory5);
		
		Inventory inventory6 = new Inventory();
		inventory6.setVehicleName(Brand.Honda);
		inventory6.setStockCount(45);
		inventoryService.save(inventory6);	
	}
	
	public void initializeCredits() {
		Credit credit = new Credit();
		credit.setBrand(Brand.Ford);
		credit.setCredit(10000);
		creditService.save(credit);
		
		Credit credit2 = new Credit();
		credit2.setBrand(Brand.Ferrari);
		credit2.setCredit(42000);
		creditService.save(credit2);
		
		Credit credit3 = new Credit();
		credit3.setBrand(Brand.Audi);
		credit3.setCredit(22450);
		creditService.save(credit3);
		
		Credit credit4 = new Credit();
		credit4.setBrand(Brand.Bmw);
		credit4.setCredit(22800);
		creditService.save(credit4);
		
		Credit credit5 = new Credit();
		credit5.setBrand(Brand.AstonMartin);
		credit5.setCredit(46460);
		creditService.save(credit5);
		
		Credit credit6 = new Credit();
		credit6.setBrand(Brand.Honda);
		credit6.setCredit(10000);
		creditService.save(credit6);
	}
}
