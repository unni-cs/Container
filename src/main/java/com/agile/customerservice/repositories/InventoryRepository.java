package com.agile.customerservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agile.customerservice.models.Inventory;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long>{

}
