package com.rakesh.milk.dairy.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakesh.milk.dairy.entity.CustomerEntity;
import com.rakesh.milk.dairy.message.Customer;

/**
 * 
 * @author rakesh.kumar
 *
 */
@Component
public class CustomerConverter {

	@Autowired
	private CustomerToEntityConverter customerToEntityConverter;
	@Autowired
	private EntityToCustomerConverter entityToCustomerConverter;
	
	public CustomerEntity convertToCustomerEntity(Customer customer) {
		
		CustomerEntity customerEntity = customerToEntityConverter.apply(customer);
		return customerEntity;
	}
	
	
	public List<Customer> convertToCustomerView(List<CustomerEntity> customerEntities) {
		
		return customerEntities.stream().map(entityToCustomerConverter).collect(Collectors.<Customer>toList());

		
	}

	public Customer convertToCustomerView(CustomerEntity customerEntity) {
		
		Customer customer = entityToCustomerConverter.apply(customerEntity);
		return customer;
	}
	
}
