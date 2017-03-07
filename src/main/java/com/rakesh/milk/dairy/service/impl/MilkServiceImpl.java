package com.rakesh.milk.dairy.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rakesh.milk.dairy.converter.MilkConverter;
import com.rakesh.milk.dairy.dao.MilkDAO;
import com.rakesh.milk.dairy.entity.MilkEntity;
import com.rakesh.milk.dairy.message.Milk;
import com.rakesh.milk.dairy.service.MilkService;

@Service
@Transactional
public class MilkServiceImpl implements MilkService{

	private static Log LOG = LogFactory.getLog(MilkServiceImpl.class);
	
	@Autowired
	private MilkDAO milkDAO;	
	
	@Autowired
	private MilkConverter milkConverter;
			
	@Override
	public void addCustomerMilk(Milk milk) {
		LOG.info("Entered MilkServiceImpl.addCustomerMilk method with oobject:"+milk);
		try {			
			 MilkEntity milkEntity = milkConverter.convertToMilkEntity(milk);
			 if(milkEntity != null) {
				 milkDAO.save(milkEntity);
			 }
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
