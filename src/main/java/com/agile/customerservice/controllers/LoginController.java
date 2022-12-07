package com.agile.customerservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
	
	@PostMapping("/api/login")
	@ResponseBody
	public ResponseEntity<String> checkout(@RequestHeader String Authorization) {
		return ResponseEntity.ok(Authorization);
	}
}
