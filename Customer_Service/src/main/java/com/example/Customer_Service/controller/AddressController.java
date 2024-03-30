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

import com.example.Customer_Service.entity.CustomerAddress;
import com.example.Customer_Service.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	AddressService service;

	@GetMapping("/api/address")
	public List<CustomerAddress> getAdderss() {

	return service.getAddress();
	}

	@PostMapping("/api/address")
	public ResponseEntity<CustomerAddress> createAddress(@RequestBody CustomerAddress address) {

	return service.createAddress(address);
	}

	@GetMapping(value="/api/address/{addressid}")
	public CustomerAddress getAdd(@PathVariable int addressid) {// @Pathvariable refers to local variable

	CustomerAddress address =service.getAdd(addressid);

	return address;
	}

	@PutMapping("/api/address/{addressid}")
	public CustomerAddress updateAddress(@PathVariable int addressid, @RequestBody CustomerAddress address) {
		CustomerAddress UpdateAddress= service.updateAddress(addressid, address);

	return UpdateAddress;
}

	@DeleteMapping("/api/address/(addressid)")
	public CustomerAddress deleteAddress(@PathVariable int addressid) {

	CustomerAddress DeleteAddress = service.deleteAddress(addressid);

	return DeleteAddress;

	}
}
