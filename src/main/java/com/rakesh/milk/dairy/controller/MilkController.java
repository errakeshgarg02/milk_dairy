package com.rakesh.milk.dairy.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.rakesh.milk.dairy.message.Customer;
import com.rakesh.milk.dairy.message.Milk;
import com.rakesh.milk.dairy.service.MilkService;

/**
 * 
 * @author Rakesh Kumar
 *
 */
@Controller
public class MilkController {
	
	private static Log LOG = LogFactory.getLog(MilkController.class);
	
	@Autowired
	private MilkService milkService;
	
	@RequestMapping(value = "/addMilkDataPage", method = RequestMethod.GET)
	public String getAddMilkDataPage(Model model,@RequestParam(value="customerId") Integer customerId, @RequestParam(value="customerCode") String customerCode) {
		LOG.info("opening addMilkDataPage.html page");
		try {
			LOG.info("request id "+customerId);
			LOG.info("request code "+customerCode);
			Milk milk = new Milk();
			Customer customer = new Customer();
			customer.setId(customerId);
			customer.setCustomerCode(customerCode);
			milk.setCustomer(customer);
			model.addAttribute("milk", milk);			
			
		}catch (Exception e) {
			LOG.error("Error while opening addMilkDataPage page,",e);
		}
		return "addMilkDataPage";
	}
	
	@RequestMapping(value = "/saveMilkData", method = RequestMethod.POST)
	public String saveMilk(@ModelAttribute(name="milk")Milk milk) {
		LOG.info("Entered MilkController.saveMilk method");

		try {			
			if(milk != null && milk.getCustomer() != null) {
				LOG.info("milk data is ::"+milk);				
				milkService.addCustomerMilk(milk);				
			}else {
				throw new RuntimeException("milk or customer details can not be null");
			}
			
		}catch (Exception e) {
			LOG.error("Error while calling saveMilk() method,",e);
			throw new RuntimeException(e);
		}
		return "addMilkDataPage";
	}
}
