package com.banking.application.helpers;

public class CustomerIdAndBalancePair {
	
	private int customerId;
	private Double balance;
	
	public CustomerIdAndBalancePair() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerIdAndBalancePair(int customerId, Double balance) {
		super();
		this.customerId = customerId;
		this.balance = balance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "CustomerIdAndBalancePair [customerId=" + customerId + ", balance=" + balance + "]";
	}

}
