package com.agile.customerservice.services;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.customerservice.common.Brand;
import com.agile.customerservice.models.Credit;
import com.agile.customerservice.repositories.CreditRepository;

@Service
public class CreditService implements ICreditService, ICreditServiceInternal {

	@Autowired
	private CreditRepository creditRepository;
	
	public Iterable<Credit> credits(){
		return creditRepository.findAll();
	}
	
	public Credit getCredit(Brand brand) {
		Optional<Credit> optionalCredit = StreamSupport.stream(credits().spliterator(), false).filter(x-> x.getBrand().equals(brand)).findFirst();
		
		return optionalCredit.isEmpty() ? null : optionalCredit.get();
	}
	
	public Credit save(Credit credit) {
		return creditRepository.save(credit);
	}
}
