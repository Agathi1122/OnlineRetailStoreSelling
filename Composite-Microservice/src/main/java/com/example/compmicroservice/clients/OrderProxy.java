package com.example.compmicroservice.clients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.compmicroservice.Entity.Orderinfo;

@FeignClient(name="Order-Service",fallback=OrderServiceFallBack.class)
public interface OrderProxy {

	@GetMapping("/api/orders")
	public List<Orderinfo> getOrders();

	@PostMapping("/api/orders")
	public ResponseEntity<Orderinfo> createOrder (@RequestBody Orderinfo order);

	@GetMapping(value = "/api/orders/{orderid}")
	public Orderinfo getOrder(@PathVariable int orderid);

	@PutMapping("/api/orders/{orderid}")
	public Orderinfo updateOrder(@PathVariable int orderid, @RequestBody Orderinfo order);
}

@Component
class OrderServiceFallBack implements OrderProxy{

	@Override
	public List<Orderinfo> getOrders() {
		// TODO Auto-generated method stub
		return new ArrayList<Orderinfo>();
	}

	@Override
	public ResponseEntity<Orderinfo> createOrder(Orderinfo order) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Orderinfo>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public Orderinfo getOrder(int orderid) {
		// TODO Auto-generated method stub
		return new Orderinfo();
	}

	@Override
	public Orderinfo updateOrder(int orderid, Orderinfo order) {
		// TODO Auto-generated method stub
		return new Orderinfo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
