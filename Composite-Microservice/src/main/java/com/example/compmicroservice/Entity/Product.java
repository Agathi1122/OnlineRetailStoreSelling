package com.example.compmicroservice.Entity;

import org.springframework.http.HttpStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productname;
	private String productdes;
	private float productprice;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdes() {
		return productdes;
	}
	public void setProductdes(String productdes) {
		this.productdes = productdes;
	}
	public float getProductprice() {
		return productprice;
	}
	public void setProductprice(float productprice) {
		this.productprice = productprice;
	}
	public Product(int productId, String productname, String productdes, float productprice) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.productdes = productdes;
		this.productprice = productprice;
	}
	public Product() {
		super();
	}
	public Product(HttpStatus internalServerError) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "product [productId=" + productId + ", productname=" + productname + ", productdes=" + productdes
				+ ", productprice=" + productprice + "]";
	}
	
	
}
