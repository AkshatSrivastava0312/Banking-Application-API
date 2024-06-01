package com.banking.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.application.dao.CustomerDao;
import com.banking.application.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> getAllCustomers() {		
		return customerDao.findAll();
	}

	@Override
	public Customer getCustomerById(String customerId) {		
		return customerDao.getCustomerById(Integer.parseInt(customerId));	
	}

	@Override
	public Customer postNewCustomer(Customer customer) {
		customerDao.save(customer);	
		return customer;
	}

	@Override
	public Customer updateCustomer(String customerId, Customer c) {
				
		List<Customer> customerList = this.getAllCustomers();
		
		for(Customer cust: customerList) {
			if(cust.getCustomerId() == Integer.parseInt(customerId))
					customerDao.save(c);
					return c;
		}
		
		return null;
		
	}

	@Override
	public Customer deleteCustomer(String customerId) {
		
		Customer c = this.getCustomerById(customerId);
		customerDao.delete(c);
		return c;		
	}

	@Override
	public boolean isCustomer(int customerId) {
		int count = customerDao.getCustomer(customerId);
		if(count > 0)
			return true;
		return false;
	}	
	
}
