package com.rakesh.milk.dairy.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;

import com.rakesh.milk.dairy.entity.MilkEntity;
import com.rakesh.milk.dairy.message.Milk;

public class MilkToEntityConverter implements Function<Milk, MilkEntity>{

	@Autowired
	private CustomerConverter customerConverter;
	
	@Override
	public MilkEntity apply(Milk milk) {
		
		MilkEntity milkEntity = new MilkEntity();
		if(milk != null) {
			milkEntity.setCustomerEntity(customerConverter.convertToCustomerEntity(milk.getCustomer()));
			milkEntity.setFat(milk.getFat());
			milkEntity.setMilkDate(milk.getMilkDate());
			milkEntity.setPrice(milk.getPrice());
			milkEntity.setWeight(milk.getWeight());
			milkEntity.setPeriod(milk.getPeriod());
			
		}
		
		return milkEntity;
	}

}
