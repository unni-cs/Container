package com.agile.customerservice.services;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.customerservice.models.Customer;
import com.agile.customerservice.repositories.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer save(Customer customer) {
		Customer existing = getCustomer(customer.getName());
		if(existing != null) {
			existing.setCredit(customer.getCredit());
			customerRepository.save(existing);
		}
		return customerRepository.save(customer);
	}

	public Iterable<Customer> customers() {
		return customerRepository.findAll();
	}
	
	public Customer getCustomer(String name) {
		Optional<Customer> optionalCustomer = StreamSupport.stream(customers().spliterator(), false).filter(x-> x.getName().equals(name)).findFirst();
		
		return optionalCustomer.isEmpty() ? null : optionalCustomer.get();
	}
	
	public Customer purchaseCredit(String name, int credit) {
		Customer existing = getCustomer(name);
		if(existing != null) {
			existing.setCredit(credit + existing.getCredit());
			return customerRepository.save(existing);
		}
		return null;
	}
}
