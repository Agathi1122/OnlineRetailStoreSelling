package com.example.compmicroservice.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerid;
	private String customername;
	private String customeremail;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<CustomerAddress> billingaddress;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<CustomerAddress> shippingaddress;

	public Customer(int customerid, String customername, String customeremail, List<CustomerAddress> billingaddress,
			List<CustomerAddress> shippingaddress) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.customeremail = customeremail;
		this.billingaddress = billingaddress;
		this.shippingaddress = shippingaddress;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomeremail() {
		return customeremail;
	}

	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}

	public List<CustomerAddress> getBillingaddress() {
		return billingaddress;
	}

	public void setBillingaddress(List<CustomerAddress> billingaddress) {
		this.billingaddress = billingaddress;
	}

	public List<CustomerAddress> getShippingaddress() {
		return shippingaddress;
	}

	public void setShippingaddress(List<CustomerAddress> shippingaddress) {
		this.shippingaddress = shippingaddress;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", customeremail="
				+ customeremail + ", billingaddress=" + billingaddress + ", shippingaddress=" + shippingaddress + "]";
	}
	
	
	
	

}
