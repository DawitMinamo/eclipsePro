package com.springmvc.dao;

import java.util.List;

import com.springmvc.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void save(Customer theCustomer);

	public Customer getCustomerById(int theId);

	public void dleteCustomer(int theId);

	public List<Customer> searchCustomers(String theCustomer);
}
