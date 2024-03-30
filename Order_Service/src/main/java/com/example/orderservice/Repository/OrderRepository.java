package com.example.orderservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orderservice.entity.Orderinfo;

@Repository
public interface OrderRepository extends JpaRepository<Orderinfo,Integer> {

}
