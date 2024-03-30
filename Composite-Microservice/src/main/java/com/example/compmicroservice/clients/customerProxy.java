package com.example.compmicroservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.compmicroservice.Entity.Customer;


@FeignClient(name="Customer-Service",fallback=CustomerServiceFallBack.class)
public interface customerProxy {

	@GetMapping("/api/customers")
	public Customer getCustomers();
	

	@PostMapping("/api/customers")
	public Customer createCustomer (@RequestBody Customer customer);
}

@Component
class CustomerServiceFallBack implements customerProxy{

	@Override
	public Customer getCustomers() {
		// TODO Auto-generated method stub
		return new Customer();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
