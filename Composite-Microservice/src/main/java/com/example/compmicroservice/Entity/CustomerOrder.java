package com.example.compmicroservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer orderId;
	private Integer customerId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public CustomerOrder(Integer id, Integer orderId, Integer customerId) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.customerId = customerId;
	}
	public CustomerOrder() {
		super();
	}
	@Override
	public String toString() {
		return "CustomerOrder [id=" + id + ", orderId=" + orderId + ", customerId=" + customerId + "]";
	}
	public CustomerOrder(Integer orderId, Integer customerId) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
	}
	
	
}
