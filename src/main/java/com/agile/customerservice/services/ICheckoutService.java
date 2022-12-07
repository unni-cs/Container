package com.agile.customerservice.services;

import com.agile.customerservice.common.Brand;
import com.agile.customerservice.models.CheckoutResponse;

public interface ICheckoutService {

	CheckoutResponse checkout(Brand vehicle, String customer);

}