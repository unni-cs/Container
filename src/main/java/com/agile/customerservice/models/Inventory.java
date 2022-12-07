package com.agile.customerservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.agile.customerservice.common.Brand;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Brand vehicle;
	private int stockCount;

	
	public Brand getVehicle() {
        return vehicle;
    }

    public void setVehicleName(Brand vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getstockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }
}
