package com.agile.customerservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.agile.customerservice.common.Brand;

@Entity
public class Credit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Brand brand;
	private int credit;
	
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public Brand getBrand() {
		return this.brand;
	}
	
	public int getCredit() {
		return this.credit;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
}
