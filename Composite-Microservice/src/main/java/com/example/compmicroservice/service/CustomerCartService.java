package com.example.compmicroservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.compmicroservice.Entity.CustomerCart;
import com.example.compmicroservice.repository.CustomerCart_Repo;

@Service
public class CustomerCartService {

	@Autowired
	CustomerCart_Repo src;
	
	public CustomerCart saveCart(CustomerCart cart)
	{
		return src.save(cart);
	}
	
	public Optional<CustomerCart> findById(Integer id)
	{
		return src.findByCustomerId(id);
	}
}
