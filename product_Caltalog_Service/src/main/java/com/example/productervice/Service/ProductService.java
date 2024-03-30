package com.example.productervice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.productervice.controller.entity.Product;
import com.example.productervice.controller.entity.exception.Exception_class;
import com.example.productervice.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repo;

	public List<Product> getProducts() {

	List<Product> products = (List<Product>) repo.findAll();

	//System.out.println("customer 11111--->"+customers);

	return products;
	}

	public ResponseEntity <Product> createProduct (Product product) {

	Product createProduct =repo.save(product);

	return new ResponseEntity<Product> (createProduct, HttpStatus.CREATED);

	}

	public Product getProduct(int productid) {

	Optional<Product> products =repo.findById(productid);

	if (products.isEmpty()) {

	throw new Exception_class(" Product doesn't exists--># "+ productid);

	}

	Product product =products.get();

	if (product == null) {

	throw new Exception_class("Product doesn't exists-->#" + productid);

	} 
	return product;

}

	public Product updateProduct(int productid, Product prod) { 
		Optional<Product> products = repo.findById(productid);

	if (products.isEmpty()) {

	throw new Exception_class("Product doesn't exists-->#" + productid);

	}

	Product product =products.get();

	if (product == null) {

	throw new Exception_class("Product doesn't exists-->#"+ productid);

	} 
	product.setProductname (prod.getProductname());

	product.setProductdes (prod.getProductdes()); 
	
	product.setProductprice(prod.getProductprice());

	return repo.save(product);
	}

	public Product deleteProduct(int product_id) {

	Optional<Product> products =repo.findById(product_id);

	if (products.isEmpty()) {

	throw new Exception_class("Product doesn't exists-->#" + product_id);

	}

	Product deleteProduct= products.get();

	if (deleteProduct ==null) {

	throw new Exception_class("Product doesn't exists-->#"+product_id + "not found.");

	}
	repo.deleteById(product_id);

	return deleteProduct;

	}

}
