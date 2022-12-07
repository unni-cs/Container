package com.agile.customerservice.controllers;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.agile.customerservice.models.BuyCreditRequest;
import com.agile.customerservice.models.Customer;
import com.agile.customerservice.models.CustomerCreditResponse;
import com.agile.customerservice.services.ICustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;

	@GetMapping("/api/health")
	public ResponseEntity<String> health() {	
		return ResponseEntity.ok("success");
	}
	
	@GetMapping("/api/customers")
	public ResponseEntity<Iterable<Customer>> customers() {	
		return ResponseEntity.ok(customerService.customers());
	}
	
	@GetMapping("/api/customer/{name}")
	public ResponseEntity<Customer> customer(@PathVariable String name) throws NotFoundException {	
		Customer customer = customerService.getCustomer(name);
		
		if(customer != null)
			return ResponseEntity.ok(customer);
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/api/customer/buycredit")
	public ResponseEntity<CustomerCreditResponse> buyCredit(@RequestBody BuyCreditRequest creditRequest) {	
		
		//don't have a service to purchase credit, so simply update the customer with new credit
	    Customer customer = customerService.purchaseCredit(creditRequest.name, creditRequest.credit);
	    
	    CustomerCreditResponse response = new CustomerCreditResponse();
	    response.setName(customer.getName());
	    response.setCredit(customer.getCredit());
	    response.message = "Credit added successfuly";
	    response.creditPurchased = creditRequest.credit;
		
		return ResponseEntity.ok(response);
	}
}
