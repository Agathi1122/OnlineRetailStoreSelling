package com.example.compmicroservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.compmicroservice.Entity.ProductInventory;

public interface Product_Rpeo extends JpaRepository<ProductInventory,Integer> {
	
	Optional<ProductInventory> findByProductname(String productName);

}
