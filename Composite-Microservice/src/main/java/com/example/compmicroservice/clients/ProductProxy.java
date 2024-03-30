package com.example.compmicroservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.compmicroservice.Entity.Inventory;
import com.example.compmicroservice.Entity.Product;
import com.example.compmicroservice.Entity.ProductInventory;

@FeignClient(name="Product-Service",fallback=ProductServiceFallBack.class)
public interface ProductProxy  {


	@GetMapping("/api/products")
	public List<Product> getProducts(List<Inventory> list);

	@PostMapping("/api/products")
	public ProductInventory createProduct (@RequestBody ProductInventory product);

	@GetMapping(value = "/api/products/{product_id}")
	public Product getProduct (@PathVariable int product_id);

	@PutMapping("/api/products/{product_id}")
	public Product updateProduct (@PathVariable int product_id, @RequestBody Product product);

	@DeleteMapping("/api/products/{product_id}")
	public Product deleteProduct (@PathVariable int product_id);
}

@Component
class ProductServiceFallBack implements ProductProxy{

	@Override
	public List<Product> getProducts(List<Inventory> list) {
		// TODO Auto-generated method stub
		return  null;
	}

	@Override
	public ProductInventory createProduct(ProductInventory product) {
		// TODO Auto-generated method stub
		return new ProductInventory(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public Product getProduct(int product_id) {
		// TODO Auto-generated method stub
		return new Product();
	}

	@Override
	public Product updateProduct(int product_id, Product product) {
		// TODO Auto-generated method stub
		return new Product(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public Product deleteProduct(int product_id) {
		// TODO Auto-generated method stub
		return new Product(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
