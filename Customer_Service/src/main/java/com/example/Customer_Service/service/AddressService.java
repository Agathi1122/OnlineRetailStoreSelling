package com.example.Customer_Service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Customer_Service.Repository.AddressRepository;
import com.example.Customer_Service.entity.CustomerAddress;
import com.example.Customer_Service.exception.Exception_class;

@Service
public class AddressService {

   @Autowired
	AddressRepository repo;

	public List<CustomerAddress> getAddress() {
	List<CustomerAddress> address = (List<CustomerAddress>) repo.findAll(); //System.out.println("customer 11111>"+customers);
	return address;
	}

	public ResponseEntity<CustomerAddress> createAddress (CustomerAddress address) {
		CustomerAddress createAddress  =repo.save(address);
	return new ResponseEntity<CustomerAddress> (createAddress, HttpStatus.CREATED);
	}

	public CustomerAddress getAdd(int addressid) {

	Optional<CustomerAddress> address =repo.findById(addressid);

	if (address.isEmpty()) {

	throw new Exception_class("Address doesn't exists-->#"+ addressid);
	}

	CustomerAddress add =address.get();

	if (add  == null) {

	throw new Exception_class("Address doesn't exists--> "+addressid);

	}

	return add;
	}

	public CustomerAddress updateAddress (int addressid, CustomerAddress add) { 
		Optional<CustomerAddress> address = repo.findById(addressid);
	if (address.isEmpty()) {

	throw new Exception_class("Address doesn't exists-> "+ addressid); }

	CustomerAddress addres = address.get();

	if (addres == null) {

	throw new Exception_class("Address doesn't exists-->#"+ addressid);
	}

	addres.setDoorno (add.getDoorno());
	addres.setCity(add.getCity());
	addres.setLayout(add.getLayout());

	addres.setStreetname(add.getStreetname());

	addres.setPincode(add.getPincode());

	return repo.save(addres);
	}
	public CustomerAddress deleteAddress(int addressid) {

	Optional<CustomerAddress> address =repo.findById(addressid);

	if (address == null) {

	throw new Exception_class("Address doesn't exists--># "+ addressid);
	}
	CustomerAddress deleteAddress = address.get();

	if (deleteAddress == null) {

	throw new Exception_class("Address doesn't exists-->#" + addressid);
	}
	repo.deleteById(addressid);

	return deleteAddress;
}
}