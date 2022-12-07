package com.agile.customerservice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.agile.customerservice.common.WebRequestHandler;
import com.agile.customerservice.services.ITokenService;

@Configuration
@ComponentScan({"com.agile.customerservice.repositories, com.agile.customerservice.services, com.agile.customerservice.common"})
public class CustomerServiceConfiguration implements WebMvcConfigurer{
	
	private ITokenService tokenService;
	
	public CustomerServiceConfiguration(DataInitializers dataInitializers, ITokenService tokenService) {
		this.tokenService = tokenService;
		dataInitializers.initializeCustomers();
		dataInitializers.initializeVehicles();
		dataInitializers.initializeInventory();
		dataInitializers.initializeCredits();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new WebRequestHandler(tokenService));
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
