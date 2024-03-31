package com.example.compmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.compmicroservice.Entity.ProductInventory;

public interface ProductInventory_Repo extends JpaRepository<ProductInventory,Integer> {

	@Query("select prod.productname from ProductInventory prod where productname=:productname")
	public String getProductInventoryByProductname(@Param("productname") String productname);
	
	@Query("select prod.productdes from ProductInventory prod where productdes=:productdes")
	public String getProductInventoryByProductdes(@Param("productdes") String productdes);
}
