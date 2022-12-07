package com.agile.customerservice.services;

import com.agile.customerservice.common.Brand;

public interface ICreditEligibilityService {

	boolean isEligible(String name, Brand vehicle);

}