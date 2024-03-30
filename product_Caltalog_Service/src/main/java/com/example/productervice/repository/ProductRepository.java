package com.example.productervice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productervice.controller.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

}
