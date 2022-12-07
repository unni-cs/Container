package com.agile.customerservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agile.customerservice.models.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

}
