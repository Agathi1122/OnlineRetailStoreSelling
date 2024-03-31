package com.example.compmicroservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.compmicroservice.Entity.cart;

@FeignClient(name="Cart-Service",fallback=CartServiceFallBack.class)
public interface cartProxy {

	
	@PostMapping("/api/carts")
	public  cart createCart(@RequestBody cart cartData);

	
	@PutMapping("/api/carts/{cartid}")
	public cart updateCart( @PathVariable int cartid,@RequestBody cart cartData );
	
	@GetMapping("/api/carts/{cartid}")
	public cart getCart(@PathVariable int cartid);
	
	@GetMapping("/api/message")
	public String getMessage();
	
}

@Component
class CartServiceFallBack implements cartProxy{

	@Override
	public cart createCart(cart cartData) {
		// TODO Auto-generated method stub
		return new cart(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public cart updateCart(int cartid, cart cartData) {
		// TODO Auto-generated method stub
		return new cart(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public cart getCart(int cartid) {
		// TODO Auto-generated method stub
		return new cart();
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "fallback method";
	}
	
}
