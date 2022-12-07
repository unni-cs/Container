package com.agile.customerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.agile.customerservice.models.CheckoutRequest;
import com.agile.customerservice.models.CheckoutResponse;
import com.agile.customerservice.services.ICheckoutService;

@RestController
public class CheckoutController {

	@Autowired
	private ICheckoutService checkoutService;
	
	@PostMapping("/api/checkout")
	@ResponseBody
	public ResponseEntity<CheckoutResponse> checkout(@RequestBody CheckoutRequest request) {
		
		CheckoutResponse response = checkoutService.checkout(request.vehicle, request.customer);
		
		return ResponseEntity.ok(response);
	}
}
