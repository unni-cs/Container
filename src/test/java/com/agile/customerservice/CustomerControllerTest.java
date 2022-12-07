package com.agile.customerservice;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.agile.customerservice.controllers.CustomerController;
import com.agile.customerservice.models.Customer;
import com.agile.customerservice.services.CustomerService;

public class CustomerControllerTest {
	
	@Test
	public void givenValidCustomerName_ShouldReturnCustomerDetails() throws NotFoundException {
		//Given
		CustomerService customerService = mock(CustomerService.class);
		CustomerController controller = new CustomerController();
		
		
		Customer expected = new Customer();		
		expected.setName("jay");
		expected.setCredit(4300);			
		when(customerService.getCustomer("jay")).thenReturn(expected);
		
		//When		
		ResponseEntity<Customer> response = controller.customer("jay");
				
		//Then
		assertNotNull(response);
		
	}
	
	
	@Test
	public void whenICallTheHealthCheckAPI_ShouldReturnSuccess() {
		//Arrange
		CustomerController controller = new CustomerController();
		
		//Act
		ResponseEntity<String> response = controller.health();
		
		//Assert
		assertNotNull(response);
		assertEquals( "success",response.getBody());
	}
}
