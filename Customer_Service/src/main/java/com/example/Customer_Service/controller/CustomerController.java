package com.example.Customer_Service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Customer_Service.entity.Customer;
import com.example.Customer_Service.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService service;

	@GetMapping("/api/customers")
	public List<Customer> getCustomers() 
	{ return 
			service.getCustomers();
	}

	@PostMapping("/api/customers")
	public ResponseEntity<Customer> createCustomer (@RequestBody Customer customer){

	return service.createCustomer(customer);
	}

	@GetMapping(value="/api/customers/{customerid}")
	public Customer getCustomer(@PathVariable int customerid) {// @Pathvariable refers to local variabl

	Customer customer = service.getCustomer(customerid);

	return customer;
	}

	@PutMapping("/api/customers/{customerid}")
	public Customer updateCustomer (@PathVariable int customerid, @RequestBody Customer customer) {
		Customer UpdateCustomer =  service.updateCustomer(customerid, customer);
		return UpdateCustomer;
	}

	

	@DeleteMapping("/api/customers/{customerid}")
	public Customer deleteCustomer (@PathVariable int customerid) {
		Customer DeleteCustomer = service.deleteCustomer(customerid);

	return DeleteCustomer;
	}
	
}
