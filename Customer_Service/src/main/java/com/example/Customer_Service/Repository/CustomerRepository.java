package com.example.Customer_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Customer_Service.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
