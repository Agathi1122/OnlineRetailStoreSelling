package com.example.productervice.controller;

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

import com.example.productervice.Service.ProductService;
import com.example.productervice.controller.entity.Product;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;

	@GetMapping("/api/products")
	public List<Product> getProducts() {

	return service.getProducts();

	}

	@PostMapping("/api/products")
	public ResponseEntity<Product> createProduct (@RequestBody Product product){

	return service.createProduct(product);

	}

	@GetMapping(value = "/api/products/{product_id}")
	public Product getProduct (@PathVariable int product_id) {// @Pathvariable

	Product product = service.getProduct(product_id);

	return product;

	}

	@PutMapping("/api/products/{product_id}")
	public Product updateProduct (@PathVariable int product_id, @RequestBody Product product) {
			Product productUpdate = service.updateProduct (product_id, product);
	

	return productUpdate;

	}

	@DeleteMapping("/api/products/{product_id}")
	public Product deleteProduct (@PathVariable int product_id) { 
		Product productDelete = service.deleteProduct(product_id);

	return productDelete;

	}

}
