package com.example.orderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.orderservice.Repository.OrderRepository;
import com.example.orderservice.entity.Orderinfo;
import com.example.orderservice.exception.Exception_class;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;

	public List<Orderinfo> getOrders() {

	List<Orderinfo> orders= (List<Orderinfo>) repo.findAll();

	//System.out.println("customer 11111--->"+customers);

	return orders;
	}

	public ResponseEntity<Orderinfo> createOrder (Orderinfo order) {

	Orderinfo createOrder =repo.save(order);

	  return new ResponseEntity<Orderinfo>(createOrder, HttpStatus.CREATED);

	}
	
public Orderinfo getOrder(int orderid) {
		Optional<Orderinfo> orders = repo.findById(orderid);

	if (orders.isEmpty()) {

	throw new Exception_class("OrderId doesn't exists--># "+ orderid);

	}

	Orderinfo order =orders.get();

	if (order== null) {

	throw new Exception_class("OrderId doesn't exists-->#" +orderid);

	} 
	 
	   return order;
	}



		public Orderinfo updateOrder(int orderid, Orderinfo order) {

		Optional<Orderinfo> orders =repo.findById(orderid);
		 if (orders.isEmpty()) {
		throw new Exception_class("OrderId doesn't exists-->#" + orderid);
		 }

		Orderinfo ordering =orders.get();

		if (ordering == null) {

		throw new Exception_class("OrderId doesn't exists-->#" + orderid);
		}

		ordering.setItem(order.getItem());

		return repo.save(ordering);

		}

		public Orderinfo deleteOrder(int orderid) { 

		Optional <Orderinfo> orders =repo.findById(orderid);
		if (orders.isEmpty()) {

		throw new Exception_class("OrderId doesn't exists--># "+ orderid);

		}

		Orderinfo deleteOrder = orders.get();

		if (deleteOrder == null) {

		throw new Exception_class("OrderId doesn't exists--#" + orderid);

		} 
		repo.deleteById(orderid);

		return deleteOrder;

		}
		 }
