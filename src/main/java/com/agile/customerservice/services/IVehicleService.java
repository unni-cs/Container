package com.agile.customerservice.services;

import com.agile.customerservice.models.Vehicle;

public interface IVehicleService {

	Vehicle save(Vehicle vehicle);

	Iterable<Vehicle> vehicles();

}