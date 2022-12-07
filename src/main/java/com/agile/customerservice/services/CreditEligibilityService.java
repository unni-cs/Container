package com.agile.customerservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.customerservice.common.Brand;
import com.agile.customerservice.models.Credit;
import com.agile.customerservice.models.Customer;

@Service
public class CreditEligibilityService implements ICreditEligibilityService {
	
	@Autowired
    private	ICustomerService customerService;
	
	@Autowired ICreditService creditService;
	
	
	@Override
	public boolean isEligible(String name, Brand vehicle) {
		Customer customer = customerService.getCustomer(name);
		Credit vechicle= creditService.getCredit(vehicle);
		
		return customer.getCredit() >= vechicle.getCredit();		
	}

}
