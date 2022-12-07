package com.agile.customerservice.services;

import com.agile.customerservice.models.Customer;

public interface ICustomerService {
	Customer save(Customer customer);
	Iterable<Customer> customers();
	Customer getCustomer(String name);
	Customer purchaseCredit(String name, int credit);
}
