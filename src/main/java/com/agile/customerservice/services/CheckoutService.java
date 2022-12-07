package com.agile.customerservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.customerservice.common.Brand;
import com.agile.customerservice.models.CheckoutResponse;

@Service
public class CheckoutService implements ICheckoutService {

	@Autowired
	private IInventoryService inventoryService;
	
	@Autowired
	private ICreditEligibilityService creditEligibilityService;
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private ICreditService creditService;
	
	private static final int NEGATIVECREDIT = -1;
	private static final int VEHICLECOUNT = 1;
	
	@Override
	public CheckoutResponse checkout(Brand vehicle, String customer) {
		CheckoutResponse response = new CheckoutResponse();		
		response.customer = customer;
		response.vehicle = vehicle;
		
		if(!inventoryService.isAvailable(vehicle)) {
			response.Message = "Vehicle not available now";
			response.checkoutStatus = "Failed! Unavailable";
			return response;
		}
		
		if(!creditEligibilityService.isEligible(customer, vehicle)) {
			response.Message = "Your credit is low to buy this vehicle, please add credit";
			response.checkoutStatus = "Failed! low credit";
			return response;
		}
		
		int creditDeduction =  creditService.getCredit(vehicle).getCredit() * NEGATIVECREDIT;	
		customerService.purchaseCredit(customer, creditDeduction);
		
		inventoryService.removeStock(vehicle, VEHICLECOUNT);
		
		response.Message = "Congragulations. Your order is successful";
		response.checkoutStatus = "Success";
		return response;
	}
}
