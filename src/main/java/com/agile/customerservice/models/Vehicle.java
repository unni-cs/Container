package com.agile.customerservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.agile.customerservice.common.Brand;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Brand name;
	private String description;
	
	public void setName(Brand name) {
		this.name = name;
	}
	
	public Brand getName() {
		return this.name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
}
