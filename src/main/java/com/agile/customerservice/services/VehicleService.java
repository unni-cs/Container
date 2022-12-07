package com.agile.customerservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.customerservice.models.Vehicle;
import com.agile.customerservice.repositories.VehicleRepository;

@Service
public class VehicleService implements IVehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	public Iterable<Vehicle> vehicles() {
		return vehicleRepository.findAll();
	}
}
