package com.agile.customerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agile.customerservice.models.Vehicle;
import com.agile.customerservice.services.IVehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	private IVehicleService vehicleService;
	
	@GetMapping("/api/vehicles")
	public ResponseEntity<Iterable<Vehicle>> vehicles() {	
		return ResponseEntity.ok(vehicleService.vehicles());
	}
}
