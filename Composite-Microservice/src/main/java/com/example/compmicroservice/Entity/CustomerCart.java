package com.example.compmicroservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer cartId;
	private Integer customerId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public CustomerCart(Integer id, Integer cartId, Integer customerId) {
		super();
		this.id = id;
		this.cartId = cartId;
		this.customerId = customerId;
	}
	public CustomerCart() {
		super();
	}
	@Override
	public String toString() {
		return "CustomerCart [id=" + id + ", cartId=" + cartId + ", customerId=" + customerId + "]";
	}
	
	
}
