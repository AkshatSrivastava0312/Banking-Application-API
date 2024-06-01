package com.banking.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.banking.application.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	@Query(value="SELECT * FROM customer c WHERE c.customer_id = :customerId", nativeQuery=true)
	public Customer getCustomerById(int customerId);
	
	@Query(value="SELECT COUNT(*) FROM customer c WHERE c.customer_id = :customerId", nativeQuery=true)
	public int getCustomer(int customerId);

}
