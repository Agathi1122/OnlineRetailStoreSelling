package com.example.compmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import com.example.compmicroservice.Entity.Customer;

public interface Customer_Repo extends JpaRepository<Customer, String>  {

	@Query("select cust.customername from Customer cust where customername=:customername")
	public String getCustomerByCustomerName(@Param("customername") String customername);
	
	@Query("select cust.customeremail from Customer cust where customeremail=:customeremail")
	public String getCustomerByCustomerEmail(@Param("customeremail") String customeremail);
}
