package com.banking.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.application.entities.Customer;
import com.banking.application.services.CustomerService;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path="/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping(path="/{customerId}")
	public Customer getCustomer(@PathVariable String customerId) {
		return customerService.getCustomerById(customerId);
	}
	
	@PostMapping
	public Customer postNewCustomer(@RequestBody Customer customer) {
		return customerService.postNewCustomer(customer);
	}
	
	@PutMapping(path="/{customerId}")
	public Customer updateCustomer(@PathVariable String customerId, @RequestBody Customer customerDetails) {	
		return customerService.updateCustomer(customerId,customerDetails);
	}
	
	@DeleteMapping(path="/{customerId}")
	public Customer deleteCustomer(@PathVariable String customerId) {
		return customerService.deleteCustomer(customerId);
	}

}
