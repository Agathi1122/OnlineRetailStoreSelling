package com.example.compmicroservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressid;
	private int doorno;
	private String streetname;
	private String layout;
	private String city;
	private int pincode;
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public int getDoorno() {
		return doorno;
	}
	public void setDoorno(int doorno) {
		this.doorno = doorno;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public CustomerAddress(int addressid, int doorno, String streetname, String layout, String city, int pincode) {
		super();
		this.addressid = addressid;
		this.doorno = doorno;
		this.streetname = streetname;
		this.layout = layout;
		this.city = city;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "CustomerAddress [addressid=" + addressid + ", doorno=" + doorno + ", streetname=" + streetname
				+ ", layout=" + layout + ", city=" + city + ", pincode=" + pincode + "]";
	}
	public CustomerAddress() {
		super();
	}
	
	
}
