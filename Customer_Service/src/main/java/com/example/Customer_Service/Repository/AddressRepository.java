package com.example.Customer_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Customer_Service.entity.CustomerAddress;

public interface AddressRepository extends JpaRepository<CustomerAddress,Integer> {

}
