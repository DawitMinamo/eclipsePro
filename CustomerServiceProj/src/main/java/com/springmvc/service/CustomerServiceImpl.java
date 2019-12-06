package com.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.CustomerDAO;
import com.springmvc.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {

	//inject the customerDAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomersList() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {
		customerDAO.save(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		Customer theCustomer = customerDAO.getCustomerById(theId);
		return theCustomer;
	}

	@Override
	@Transactional
	public void delete(int theId) {
		// delete the customer 
		customerDAO.dleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> search(String theCustomer) {
		// get customers from dao
		List<Customer> theCustomers = customerDAO.searchCustomers(theCustomer);
		return theCustomers;
	}

}
