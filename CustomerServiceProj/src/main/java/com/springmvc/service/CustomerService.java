package com.springmvc.service;

import java.util.List;

import com.springmvc.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomersList();

	public void save(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void delete(int theId);

	public List<Customer> search(String theCustomer);
}
