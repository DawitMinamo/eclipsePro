package com.customerService.ServiceLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customerService.DAO.CustomerDAO;
import com.customerService.entity.Customer;

@Service
@Transactional
public class ServiceLayerImpl implements ServiceLayer {

	@Autowired
	private CustomerDAO customerDAO;

	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomerById(int theId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(theId);
	}

}
