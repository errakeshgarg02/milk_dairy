package com.rakesh.milk.dairy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;

import com.rakesh.milk.dairy.converter.CustomerConverter;
import com.rakesh.milk.dairy.converter.CustomerToEntityConverter;
import com.rakesh.milk.dairy.converter.EntityToCustomerConverter;
import com.rakesh.milk.dairy.converter.EntityToMilkConverter;
import com.rakesh.milk.dairy.converter.MilkToEntityConverter;
import com.rakesh.milk.dairy.dao.CustomerDAO;
import com.rakesh.milk.dairy.dao.MilkDAO;
import com.rakesh.milk.dairy.prop.MyDataSourceProperties;
import com.rakesh.milk.dairy.prop.MyJpaProperties;
import com.rakesh.milk.dairy.service.CustomerService;
import com.rakesh.milk.dairy.service.impl.CustomerServiceImpl;

/**
 * 
 * @author rakesh.kumar
 *
 */
public class RegisterBeans {

	private static Log LOG = LogFactory.getLog(RegisterBeans.class);
	
	@Bean
	public MyDataSourceProperties getMyDataSourceProperties() {
		LOG.info("registering bean MyDataSourceProperties");
		return new MyDataSourceProperties();
	}
	
	@Bean
	public MyJpaProperties getMyJpaProperties() {
		LOG.info("registering bean MyJpaProperties");
		return new MyJpaProperties();
	}
	
	@Bean
	public CustomerDAO getCustomerDAO() {
		LOG.info("registering bean getCustomerDAO");
		return new CustomerDAO();
	}
	
	@Bean
	public CustomerConverter getCustomerConverter() {
		LOG.info("registering bean CustomerConverter");
		return new CustomerConverter();
	}
	
	@Bean
	public CustomerToEntityConverter getCustomerToEntityConverter() {
		LOG.info("registering bean CustomerToEntityConverter");
		return new CustomerToEntityConverter();
	}
	
	@Bean
	public EntityToCustomerConverter getEntityToCustomerConverter() {
		LOG.info("registering bean EntityToCustomerConverter");
		return new EntityToCustomerConverter();
	}
	
	@Bean
	public EntityToMilkConverter getEntityToMilkConverter() {
		return new EntityToMilkConverter();
	}

	@Bean
	public MilkToEntityConverter getMilkToEntityConverter() {
		return new MilkToEntityConverter();
	}
	
	@Bean
	public MilkDAO getMilkDAO() {
		return new MilkDAO();
	}

	
}
