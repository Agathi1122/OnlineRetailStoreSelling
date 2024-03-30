package com.example.orderservice.controller;

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

import com.example.orderservice.entity.Orderinfo;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService service;

	@GetMapping("/api/orders")
	public List<Orderinfo> getOrders() {
		return service.getOrders();
	}

	@PostMapping("/api/orders")
	public ResponseEntity<Orderinfo> createOrder (@RequestBody Orderinfo order){

	  return service.createOrder(order);

	}

	@GetMapping(value = "/api/orders/{orderid}")
	public Orderinfo getOrder(@PathVariable int orderid) {// @Pathvariable refers

	Orderinfo order = service.getOrder(orderid);

	return order;

	}

	@PutMapping("/api/orders/{orderid}")
	public Orderinfo updateOrder(@PathVariable int orderid, @RequestBody Orderinfo order) {
		Orderinfo	UpdateOrder= service.updateOrder(orderid, order);

	return UpdateOrder;

	}

	@DeleteMapping("/api/orders/{orderid}")
	public Orderinfo deleteOrder(@PathVariable int orderid) {
		Orderinfo orderDelete = service.deleteOrder(orderid);

	return orderDelete;

	}
}
