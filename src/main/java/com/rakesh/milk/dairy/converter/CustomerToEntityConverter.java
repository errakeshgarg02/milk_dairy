package com.rakesh.milk.dairy.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.rakesh.milk.dairy.entity.CustomerEntity;
import com.rakesh.milk.dairy.message.Customer;

@Component
public class CustomerToEntityConverter implements Function<Customer, CustomerEntity> {

	@Override
	public CustomerEntity apply(Customer customer) {
		CustomerEntity customerEntity = new CustomerEntity();
		if (customer != null) {
			customerEntity.setActive(customer.getActive());
			customerEntity.setCustomerCode(customer.getCustomerCode());
			customerEntity.setAddress(customer.getAddress());
			customerEntity.setFatherName(customer.getFatherName());
			customerEntity.setFirstName(customer.getFirstName());
			customerEntity.setLastName(customer.getLastName());
			customerEntity.setMobileNumber(customer.getMobileNumber());			
		}
		return customerEntity;
	}

}
