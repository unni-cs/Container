package com.agile.customerservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agile.customerservice.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
