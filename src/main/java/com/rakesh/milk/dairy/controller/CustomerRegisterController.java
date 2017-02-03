package com.rakesh.milk.dairy.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rakesh.milk.dairy.message.Customer;
import com.rakesh.milk.dairy.service.CustomerService;

@Controller
public class CustomerRegisterController {

	private static Log LOG = LogFactory.getLog(CustomerRegisterController.class);
	@Autowired
	private CustomerService customerService;

	// @RequestMapping("/greeting")
	// public String greeting(@RequestParam(value="name", required=false,
	// defaultValue="World") String name, Model model) {
	// model.addAttribute("name", name);
	// return "greeting";
	// }

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView registerCustomerPage() {
		LOG.info("opening signup.html page");
		ModelAndView modelAndView = null;
		try {
			Customer customer = customerService.getLastRecord();
			if(customer == null) {
				modelAndView = new ModelAndView("signup", "customer", new Customer("P1"));
			}else {
				modelAndView = new ModelAndView("signup", "customer", new Customer("P1"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}

		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute(value = "customer") Customer customer) {
		LOG.info("registering customer ::" + customer);
		if (customer != null) {
			customer.setCustomerCode("CUS01");
			customer.setActive(true);
			customerService.registerCustomer(customer);
		}else {
			throw new RuntimeException("Customer data can not be null");
		}
		return "redirect:/showAll";
	}

	@RequestMapping(value = "/showAll", method = RequestMethod.GET)
	public ModelAndView showAllCustomer() {
		LOG.info("Showing all customers");
		List<Customer> customers = null;
		ModelAndView modelAndView = null;
		try {
			customers = customerService.showAllCustomer();
			modelAndView = new ModelAndView("listCustomers", "customers", customers);
			LOG.info("customers size ::"+customers.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;

	}
}
