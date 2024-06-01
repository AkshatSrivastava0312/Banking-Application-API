package com.banking.application.services;

import java.util.List;
import com.banking.application.entities.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(String customerId);
	public Customer postNewCustomer(Customer customer);
	public Customer updateCustomer(String customerId, Customer c);
	public Customer deleteCustomer(String customerId);
	public boolean isCustomer(int customerId);
	
}
