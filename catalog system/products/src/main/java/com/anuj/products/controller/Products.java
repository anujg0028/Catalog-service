package com.anuj.products.controller;

import java.util.HashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.anuj.prices.Prices;

@Entity
@Table(name="products")
public class Products {
	
	//default constructor
	public Products()
	{
		pid=0;
		name="";
		price=null;
	}
	
	//product id
	@Id
	@Column(name="ID")
	private int pid;
	
	//product name
	@Column(name="NAME")
	private String name;
	
	//used to store product price in term of half and full price
	//@Column(name="PRICE")
	@OneToOne(cascade=CascadeType.ALL)
	private Prices price;
	
	
	
	public Prices getPrice() {
		return price;
	}

	public void setPrice(Prices price) {
		this.price = price;
	}

	public int getPid() {
		return pid;
	}
	
	@Override
	public String toString() {
		return "Products [pid=" + pid + ", name=" + name + ", map=" + price + "]";
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
