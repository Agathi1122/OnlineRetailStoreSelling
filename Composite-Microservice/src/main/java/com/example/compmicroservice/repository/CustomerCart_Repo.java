package com.example.compmicroservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.compmicroservice.Entity.CustomerCart;

public interface CustomerCart_Repo extends JpaRepository<CustomerCart,Integer> {
	
	Optional<CustomerCart> findByCustomerId(Integer id);
	

}
