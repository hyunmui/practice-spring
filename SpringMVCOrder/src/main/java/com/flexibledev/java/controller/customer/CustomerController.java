package com.flexibledev.java.controller.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.flexibledev.java.domain.Customer;
import com.flexibledev.java.model.CustomerModel;
import com.flexibledev.java.service.CustomerService;

@Controller
@RequestMapping(value = "/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public void list(Model model) {
		List<Customer> customers = customerService.getCustomers();
		List<CustomerModel> customerModels = convert(customers);
		model.addAttribute("customers", customerModels);
	}

	private List<CustomerModel> convert(List<Customer> customers) {
		List<CustomerModel> customerModels = new ArrayList<CustomerModel>();
		customers.stream().forEach((customer) -> {
			CustomerModel customerModel = new CustomerModel();
			customerModel.buildModel(customer);
			customerModels.add(customerModel);
		});
		return customerModels;
	}

	@RequestMapping(value = "edit.do", method = RequestMethod.GET)
	public String edit(Model model) {
		CustomerModel customer = new CustomerModel();
		model.addAttribute("customer", customer);
		return "edit";
	}

	@RequestMapping(value = "/edit.do", method = RequestMethod.POST)
	public String add(@ModelAttribute CustomerModel customer) {
		try {
			customerService.saveCustomer(customer.buildDomain());
		} catch (Exception e) {
			return "forward:/error.do";
		}
		return "result";
	}

//	@RequestMapping("/details/{name}")
//	public String viewDetails(@PathVariable("name") String name) {
//		// TODO: No implementation
//		return null;
//	}

	@RequestMapping(value = "/details.do", method = RequestMethod.GET)
	public String viewDetails(@RequestParam("name") String name) {
		// TODO: No implementation
		return "viewDetails";
	}

//	@RequestMapping(value = "/details.do", method = RequestMethod.GET)
//	public String save(String name) {
//		// TODO: No implementation
//		return "save";
//	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String update(@RequestParam Map<String, String> params) {
		// TODO: No implementation
		return "update";
	}

	@RequestMapping(value = "/message.do", method = RequestMethod.POST)
	public String message(@RequestBody String body) {
		// TODO: No implementation
		return "message";
	}

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String header(@RequestHeader("Host") String host) {
//		// TODO: No implementation
//		return "header";
//	}
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String login(@CookieValue("user") String user) {
//		// TODO: No implementation
//		return "login";
//	}

	@RequestMapping(value = "/error.do", method = RequestMethod.GET)
	public String error(Model model) {
		return "error";
	}
}
