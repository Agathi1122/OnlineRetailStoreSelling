package com.example.compmicroservice.Entity;

import java.util.List;

public class CustomerOrderDetails {

	Customer customer;
	List<Orderinfo> order;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Orderinfo> getOrder() {
		return order;
	}
	public void setOrder(List<Orderinfo> order) {
		this.order = order;
	}
	public CustomerOrderDetails(Customer customer, List<Orderinfo> order) {
		super();
		this.customer = customer;
		this.order = order;
	}
	public CustomerOrderDetails() {
		super();
	}
	@Override
	public String toString() {
		return "CustomerOrderDetails [customer=" + customer + ", order=" + order + "]";
	}
	
}
