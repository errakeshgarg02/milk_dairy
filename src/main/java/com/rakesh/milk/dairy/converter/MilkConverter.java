package com.rakesh.milk.dairy.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakesh.milk.dairy.entity.MilkEntity;
import com.rakesh.milk.dairy.message.Milk;

/**
 * 
 * @author rakesh.kumar
 *
 */
@Component
public class MilkConverter {

	@Autowired
	private MilkToEntityConverter milkToEntityConverter;
	@Autowired
	private EntityToMilkConverter entityToMilkConverter;
	
	public MilkEntity convertToMilkEntity(Milk milk) {
		
		MilkEntity milkEntity = milkToEntityConverter.apply(milk);
		return milkEntity;
	}
	
	
	public List<Milk> convertToMilkView(List<MilkEntity> milkEntities) {
		
		return milkEntities.stream().map(entityToMilkConverter).collect(Collectors.<Milk>toList());

		
	}

	public Milk convertToMilkView(MilkEntity milkEntity) {
		
		Milk milk = entityToMilkConverter.apply(milkEntity);
		return milk;
	}
	
}
