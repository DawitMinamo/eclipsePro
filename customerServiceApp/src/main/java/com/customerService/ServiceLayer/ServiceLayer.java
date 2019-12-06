package com.customerService.ServiceLayer;

import java.util.List;

import com.customerService.entity.Customer;

public interface ServiceLayer {
	
	public List<Customer> getCustomers();
	public void save(Customer theCustomer);
	public Customer getCustomerById(int theId);

}
