package com.example.compmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.compmicroservice.Entity.CustomerOrder;
import com.example.compmicroservice.repository.CustomerOrder_Repo;

@Service
public class CustomerOrderService {

	@Autowired
	CustomerOrder_Repo src;
	
	public CustomerOrder  saveCustomerOrder(CustomerOrder cust)
	{
		return src.save(cust);
	}
	
	public List<CustomerOrder> findById(Integer id)
	{
		return src.findBycustomerId(id);
	}
	
}
