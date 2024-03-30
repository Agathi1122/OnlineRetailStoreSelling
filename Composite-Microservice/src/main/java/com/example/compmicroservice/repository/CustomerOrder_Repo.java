package com.example.compmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.compmicroservice.Entity.CustomerOrder;

public interface CustomerOrder_Repo extends JpaRepository<CustomerOrder,Integer> {

	List<CustomerOrder> findBycustomerId(Integer customerId);
}
