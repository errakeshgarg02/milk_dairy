package com.rakesh.milk.dairy.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.rakesh.milk.dairy.entity.CustomerEntity;
import com.rakesh.milk.dairy.message.Customer;

@Component
public class EntityToCustomerConverter implements Function<CustomerEntity, Customer>{

	@Override
	public Customer apply(CustomerEntity customerEntity) {
		Customer customer = new Customer();
		customer.setActive(customerEntity.getActive());
		customer.setAddress(customerEntity.getAddress());
		customer.setCustomerCode(customerEntity.getCustomerCode());
		customer.setFatherName(customerEntity.getFatherName());
		customer.setFirstName(customerEntity.getFirstName());
		customer.setLastName(customerEntity.getLastName());
		customer.setMobileNumber(customerEntity.getMobileNumber());
		return customer;
	}

}
