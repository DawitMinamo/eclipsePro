package com.springmvc.controller;


import java.util.List;

import javax.jws.WebParam.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.entity.Customer;
import com.springmvc.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject the customer service
	@Autowired
	private CustomerService customerService;
			
	@GetMapping("/list")
	public String customerList(Model model) {

		//get the customer list fro the dao
		List<Customer> theCustomers = customerService.getCustomersList();
		
		//add the customer list to the model
		model.addAttribute("customers", theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		//add the mode to bind with customer
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save customer using our service
		customerService.save(theCustomer);
		return "redirect:/customer/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model model) {
		//get the customer from db
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set the customer to model tp pre-poplate the form
	    model.addAttribute("customer", theCustomer);
		//send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId, Model model) {
		//delete the customer
		customerService.delete(theId);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("searchCustomer") String theCustomer, Model model){
		//get customers on database
		List<Customer> theCustomers = customerService.search(theCustomer);
		
		//add the customers on the model
		model.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	

}
