package com.example.Customer_Service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Customer_Service.Repository.CustomerRepository;
import com.example.Customer_Service.entity.Customer;
import com.example.Customer_Service.exception.Exception_class;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository repo;
	
	public List<Customer> getCustomers() {
		List<Customer> customers = (List<Customer>) repo.findAll(); //System.out.println("customer 11111--->"+customers);
	      return customers;
	}

	public ResponseEntity<Customer> createCustomer (Customer customer) { 
		Customer createCustomer = repo.save(customer);
	return new ResponseEntity<Customer>(createCustomer, HttpStatus.CREATED);
	}


	public Customer getCustomer(int customerid) {

	Optional<Customer> customers =repo.findById(customerid);

	if ( customers.isEmpty()) {
		throw new Exception_class("1... Customer doesn't exists--> "+ customerid);
	}
     Customer customer = customers.get();

	

	if (customer == null) {

	throw new Exception_class("2...Customer doesn't exists--> "+customerid);
	}

	  return customer;
	}
	
	public Customer updateCustomer(int customerid, Customer cust) {
		Optional<Customer> customers= repo.findById(customerid);

	if (customers.isEmpty()) {

		throw new Exception_class("1... Customer doesn't exists--> "+ customerid);
	}	

	Customer customer= customers.get();

	if (customer == null) {

		throw new Exception_class("1... Customer doesn't exists--> "+ customerid);
	}

	customer.setCustomername(cust.getCustomername()); customer.setCustomeremail(cust.getCustomeremail());

	customer.setBillingaddress(cust.getBillingaddress());

	customer.setShippingaddress (cust.getShippingaddress());

	return repo.save(customer);
	
	}

	public Customer deleteCustomer(int customerid) {

	Optional<Customer> customers = repo.findById(customerid);

	if (customers.isEmpty()) {

		throw new Exception_class("1... Customer doesn't exists--> "+ customerid);
	} 
	Customer deleteCustomer= customers.get();

	if (deleteCustomer == null) {

		throw new Exception_class("1... Customer doesn't exists--> "+ customerid);
	} 

	repo.deleteById(customerid);

	return deleteCustomer;

	}

}
