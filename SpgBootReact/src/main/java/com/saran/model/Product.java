package com.saran.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int prdId;
	private String prdName;
	private int prdPrice;

	public Product() {}
	
	public Product(String prdName, int prdPrice) {
		super();
		
		this.prdName = prdName;
		this.prdPrice = prdPrice;
	}
	public int getPrdId() {
		return prdId;
	}
	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public int getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}
	
}
