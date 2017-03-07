package com.rakesh.milk.dairy.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;

import com.rakesh.milk.dairy.entity.MilkEntity;
import com.rakesh.milk.dairy.message.Milk;

public class EntityToMilkConverter implements Function<MilkEntity, Milk>{

	@Autowired
	private CustomerConverter customerConverter;
	
	@Override
	public Milk apply(MilkEntity t) {
		Milk milk = new Milk();
		if(t != null) {
			milk.setCustomer(customerConverter.convertToCustomerView(t.getCustomerEntity()));
			milk.setFat(t.getFat());
			milk.setId(t.getId());
			milk.setMilkDate(t.getMilkDate());
			milk.setPeriod(t.getPeriod());
			milk.setPrice(t.getPrice());
			milk.setWeight(t.getWeight());
		}
		return milk;
	}

}
