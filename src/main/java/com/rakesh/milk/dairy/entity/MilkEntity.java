package com.rakesh.milk.dairy.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Rakesh Kumar
 *
 */
@Entity
@Table(name="MILK",schema="milk_dairy_schema")
public class MilkEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4198447267217968746L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;	
	@ManyToOne
	@JoinColumn(name="CUST_ID", nullable=false)
	private CustomerEntity customerEntity;
	@Column(name="WEIGHT",nullable=false)
	private double weight;
	@Column(name="FAT",nullable=false)
	private double fat;
	@Column(name="PRICE",nullable=false)
	private double price;
	@Column(name="MILK_DATE",nullable=false)
	private Date milkDate;
	@Column(name="CREATED_DATE", insertable=false,updatable=false)
	private Date createdDate;
	@Column(name="MODIFIED_DATE", insertable=false,updatable=false)
	private Date modifiedDate;
	@Column(name="PERIOD", nullable=false)
	private String period;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}
	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	@Override
	public String toString() {
		return "MilkEntity [id=" + id + ", customerEntity=" + customerEntity + ", weight=" + weight + ", fat=" + fat
				+ ", price=" + price + ", milkDate=" + milkDate + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", period=" + period + "]";
	}	

}
