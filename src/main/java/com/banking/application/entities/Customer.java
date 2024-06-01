package com.banking.application.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private int customerId;
	private String name;
	private double balance;
	
	public Customer() {
		super();		
	}

	public Customer(int customerId, String name, double balance) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.balance = balance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", balance=" + balance + "]";
	}	
	
}
