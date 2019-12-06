package com.springmvc.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// get the current session factory
		Session session = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);
		
		//execute and get all customer list
		List<Customer> customers = theQuery.getResultList();
		
		//return the list of customers
		return customers;
	}

	@Override
	public void save(Customer theCustomer) {
		
		//get current session
		Session session = sessionFactory.getCurrentSession();
		
		//seve the customer
		session.saveOrUpdate(theCustomer);
	}
	@Override
	public Customer getCustomerById(int theId) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//now retrive/read the customer using the id
		Customer theCustomer = session.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void dleteCustomer(int theId) {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//delete the customer based on id
		Query theQuery = session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String theCustomer) {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//search the customers
		Query theQuery = null;
		if(theCustomer != null && theCustomer.trim().length()>0) {
			theQuery = session.createQuery
					("from Customer where lower(firstName) like:customerName or lower(lastName)like:customerName");
			theQuery.setParameter("customerName","%"+ theCustomer.toLowerCase()+"%");
			
		}else {
			//if the name is empty --- get all customers
			theQuery = session.createQuery("from Customer", Customer.class);
		}
		  List<Customer> theCustomers = theQuery.getResultList();
		return theCustomers;
	}

}
