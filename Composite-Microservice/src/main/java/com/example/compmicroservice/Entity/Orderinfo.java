package com.example.compmicroservice.Entity;

import java.util.List;

import org.springframework.http.HttpStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Orderinfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Lineitem> item;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Lineitem> getItem() {
		return item;
	}

	public void setItem(List<Lineitem> item) {
		this.item = item;
	}

	public Orderinfo(int id, List<Lineitem> item) {
		super();
		this.id = id;
		this.item = item;
	}

	public Orderinfo() {
		super();
	}

	public Orderinfo(HttpStatus internalServerError) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Orderinfo [id=" + id + ", item=" + item + "]";
	}

	
	
	
}
