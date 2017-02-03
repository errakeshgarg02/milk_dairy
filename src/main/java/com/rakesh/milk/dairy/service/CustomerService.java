package com.rakesh.milk.dairy.service;

import java.util.List;

import com.rakesh.milk.dairy.message.Customer;

/**
 * 
 * @author rakesh.kumar
 *
 */
public interface CustomerService {
	
	public void registerCustomer(Customer customer);
	
	public List<Customer> showAllCustomer();
	
	public Customer getLastRecord();
	
}
