package com.rakesh.milk.dairy.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author rakesh.kumar
 *
 */
@Entity
@Table(name="CUSTOMER")
public class CustomerEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1455687245881492469L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="FATHER_NAME")
	private String fatherName;
	@Column(name="CUSTOMER_CODE")
	private String customerCode;
	@Column(name="MOBILE_NUMBER")
	private Long mobileNumber;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="ACTIVE")
	private Boolean active;
	@Column(name="CREATED_DATE")
	private Date createdDate;
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
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
	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", fatherName="
				+ fatherName + ", customerCode=" + customerCode + ", mobileNumber=" + mobileNumber + ", address="
				+ address + ", active=" + active + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ "]";
	}	
	
}
