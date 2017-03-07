package com.rakesh.milk.dairy.message;

import java.util.Date;

public class Milk {
	private Integer id;		
	private Customer customer;	
	private double weight;	
	private double fat;	
	private double price;	
	private Date milkDate;		
	private String period;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getMilkDate() {
		return milkDate;
	}
	public void setMilkDate(Date milkDate) {
		this.milkDate = milkDate;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	@Override
	public String toString() {
		return "Milk [id=" + id + ", customer=" + customer + ", weight=" + weight + ", fat=" + fat + ", price=" + price
				+ ", milkDate=" + milkDate + ", period=" + period + "]";
	}
	
	
	
}
