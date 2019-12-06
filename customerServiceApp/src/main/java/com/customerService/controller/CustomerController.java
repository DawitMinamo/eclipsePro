package com.customerService.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customerService.ServiceLayer.ServiceLayer;
import com.customerService.entity.Customer;



@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	private ServiceLayer serviceLayer;
	
	@GetMapping(value="/list")
	public String getCustomerForm(Model model) {
		//get customer from DAO
		List<Customer> theCustomers = serviceLayer.getCustomers();
		//add customer to the model
		model.addAttribute("customers", theCustomers);
		return "customer-list";
		
	}
	
	@GetMapping("showformforupdate")
	public String showUpdate(@RequestParam("customerId") int theId, Model model) {
		Customer theCustomer = serviceLayer.getCustomerById(theId);
		model.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	@PostMapping("saveform")
	public String save(@ModelAttribute("customer") Customer theCustomer) {
		serviceLayer.save(theCustomer);
		return "redirect:customer/list";
	}

}
