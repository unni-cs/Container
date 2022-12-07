package com.agile.customerservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agile.customerservice.models.Credit;

@Repository
public interface CreditRepository extends CrudRepository<Credit, Long>{

}
