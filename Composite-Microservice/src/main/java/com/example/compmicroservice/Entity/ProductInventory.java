package com.example.compmicroservice.Entity;

import org.springframework.http.HttpStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productname;
	private String productdes;
	private String productprice;
	int quantity;
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
	public String getProductprice() {
		return productprice;
	}
	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductInventory(int productId, String productname, String productdes, String productprice, int quantity) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.productdes = productdes;
		this.productprice = productprice;
		this.quantity = quantity;
	}
	public ProductInventory() {
		super();
	}
	public ProductInventory(HttpStatus internalServerError) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductInventory [productId=" + productId + ", productname=" + productname + ", productdes="
				+ productdes + ", productprice=" + productprice + ", quantity=" + quantity + "]";
	}
	
	
}
