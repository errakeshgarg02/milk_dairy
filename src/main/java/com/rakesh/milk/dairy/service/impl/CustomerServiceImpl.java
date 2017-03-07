package com.rakesh.milk.dairy.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rakesh.milk.dairy.converter.CustomerConverter;
import com.rakesh.milk.dairy.dao.CustomerDAO;
import com.rakesh.milk.dairy.entity.CustomerEntity;
import com.rakesh.milk.dairy.exception.DAOException;
import com.rakesh.milk.dairy.message.Customer;
import com.rakesh.milk.dairy.service.CustomerService;

/**
 * 
 * @author rakesh.kumar
 *
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private static Log LOG = LogFactory.getLog(CustomerServiceImpl.class);
	@Autowired
	private CustomerDAO  customerDAO;
	@Autowired
	private CustomerConverter customerConverter;
	
	@Override
	public void registerCustomer(Customer customer) {
		LOG.info("CustomerServiceImpl.registerCustomer method");
		try {
			CustomerEntity customerEntity = customerConverter.convertToCustomerEntity(customer);
			customerDAO.save(customerEntity);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> showAllCustomer() {
		LOG.info("CustomerServiceImpl.showAllCustomer method");
		List<Customer> customers = null;
		try {
			List<CustomerEntity> customerEntities = customerDAO.findAll(CustomerEntity.class);
			customers = customerConverter.convertToCustomerView(customerEntities);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer getLastRecord() {
		LOG.info("CustomerServiceImpl.getLastRecord method");
		Customer customer = null;
		try {
			CustomerEntity customerEntity = (CustomerEntity) customerDAO.getLastRecord(CustomerEntity.class);			
			LOG.info("customerEntity::"+customerEntity);
			customer = customerConverter.convertToCustomerView(customerEntity);
			LOG.info("customer::"+customer);
			if(customer != null && customer.getCustomerCode() != null) {
				String code = customer.getCustomerCode();
				
				String[] split = code.split("((?<=[a-zA-Z])(?=[0-9]))|((?<=[0-9])(?=[a-zA-Z]))");
				Integer c = new Integer(split[1].trim());
				c += 1;
				customer.setCustomerCode(split[0]+c);
				LOG.info("Next customer code is ::"+customer.getCustomerCode());
			}else {
				customer = new Customer("PA1");
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Customer> getCustomer(String name) {
		LOG.info("CustomerServiceImpl.getCustomer method with name::"+name);
		List<Customer> customers = null;
		try {
			List<CustomerEntity> customerEntities = customerDAO.findByValue(CustomerEntity.class, "firstName", name);			
			customers = customerConverter.convertToCustomerView(customerEntities);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public void updateCustomer(Customer customer) {
		LOG.info("CustomerServiceImpl.updateCustomer method");
		try {
			CustomerEntity customerEntity = customerConverter.convertToCustomerEntity(customer);
			customerDAO.update(customerEntity);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Customer getCustomer(Integer id) {
		LOG.info("Getting customer with id ::"+id);
		Customer customer = null;
		try {
			List<CustomerEntity> findByValue = customerDAO.findByValue(CustomerEntity.class, "id", id);
			customer = customerConverter.convertToCustomerView(findByValue.get(0));
			
		}catch (DAOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return customer;
	}

}
