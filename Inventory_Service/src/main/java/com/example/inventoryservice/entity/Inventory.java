package com.example.inventoryservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryid;
	private int productId;
	private int quantity;
	public int getInventoryid() {
		return inventoryid;
	}
	public void setInventoryid(int inventoryid) {
		this.inventoryid = inventoryid;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Inventory(int inventoryid, int productId, int quantity) {
		super();
		this.inventoryid = inventoryid;
		this.productId = productId;
		this.quantity = quantity;
	}
	public Inventory() {
		super();
	}
	@Override
	public String toString() {
		return "Inventory [inventoryid=" + inventoryid + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
	
	
}
