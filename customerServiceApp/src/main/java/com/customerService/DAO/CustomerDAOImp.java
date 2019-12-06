package com.customerService.DAO;






import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customerService.entity.Customer;


@Repository
public class CustomerDAOImp implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	public List<Customer> getCustomers() {
		// get current hibernate session factory
		Session session = sessionFactory.getCurrentSession();

		//create a query
		Query<Customer> qry = session.createQuery("from Customer", Customer.class);
		
		//get query and set result set
		List<Customer> customers = qry.getResultList();
		//return the result
		return customers;
	}


	public void saveCustomer(Customer theCustomer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(theCustomer);
		
	}


	
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Customer theCustomer = session.get(Customer.class, theId);
		return theCustomer;
	}

}
