package com.nt.entity;

import java.io.Serializable;

public class Product  implements Serializable{
	
	private int pid;
	private String pname;
	private float price;
	private float qty;
	
	// setters and getters
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setQty(float qty) {
		this.qty = qty;
	}
	public int getPid() {
		return pid;
	}
	public String getPname() {
		return pname;
	}
	public float getPrice() {
		return price;
	}
	public float getQty() {
		return qty;
	}
	
}
