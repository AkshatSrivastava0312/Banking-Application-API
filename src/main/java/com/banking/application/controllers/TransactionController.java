package com.banking.application.controllers;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.application.entities.Customer;
import com.banking.application.entities.Transaction;
import com.banking.application.helpers.CustomerIdAndBalancePair;
import com.banking.application.services.CustomerService;
import com.banking.application.services.TransactionService;



@RestController
@RequestMapping(path="/transactions")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	CustomerService customerService;

	@GetMapping(path="/checkBalance/{customerId}")
	public CustomerIdAndBalancePair getBalanceForCustomer(@PathVariable String customerId) {
		
		CustomerIdAndBalancePair result = new CustomerIdAndBalancePair();
		
		try {	
		result = transactionService.getBalanceForCustomer(Integer.parseInt(customerId));		
		}catch(Exception e) {
			e.getMessage();
		}
		
		return result;
	}
	
	@PutMapping(path="/withdraw/{customerId}/{amount}")
	public Transaction withdrawAmount(@PathVariable String customerId, @PathVariable String amount) {
		
		try {
			if(Double.parseDouble(amount) > 0) {			
			
				boolean isCustomer = customerService.isCustomer(Integer.parseInt(customerId));
				if(isCustomer) {
					Customer customer = customerService.getCustomerById(customerId);
					if(customer.getBalance() >= Double.parseDouble(amount)) {
						customer.setBalance(customer.getBalance() - Double.parseDouble(amount));
						return transactionService.withdrawAmount(Integer.parseInt(customerId),Double.parseDouble(amount));
					}else {
						throw new Exception();
					}
				}
				else {
					throw new Exception();
					}
			}else {
				throw new Exception();				
			}
		}catch(Exception e) {
			e.getMessage();
		}
		
		Transaction transaction = new Transaction();
		transaction.setReceiverId(0);
		transaction.setSenderId(0);
		transaction.setTimestamp(new Timestamp(System.currentTimeMillis()));
		transaction.setType("INVALID TRANSACTION");
		transaction.setSenderOpeningBalance(0);
		transaction.setSenderClosingBalance(0);
		transaction.setReceiverOpeningBalance(0);
		transaction.setReceiverClosingBalance(0);
		return transaction;
		
	}
	
	@PutMapping(path="/add/{customerId}/{amount}")
	public Transaction AddAmount(@PathVariable String customerId, @PathVariable String amount) {
		
		try {
			if(Double.parseDouble(amount) > 0 ) {
				boolean isCustomer = customerService.isCustomer(Integer.parseInt(customerId));
				if(isCustomer) {
					Customer customer = customerService.getCustomerById(customerId);
					double openingBalance  = customer.getBalance();
					double closingBalance = openingBalance + Double.parseDouble(amount);
					customer.setBalance(closingBalance);
					return transactionService.AddAmount(Integer.parseInt(customerId), openingBalance, closingBalance);
				}else {
					throw new Exception();
				}
				
			}else {
				throw new Exception();
			}
		}
		catch(Exception e) {
			e.getMessage();
		}		
		
		Transaction transaction = new Transaction();
		transaction.setReceiverId(0);
		transaction.setSenderId(0);
		transaction.setTimestamp(new Timestamp(System.currentTimeMillis()));
		transaction.setType("INVALID TRANSACTION");
		transaction.setSenderOpeningBalance(0);
		transaction.setSenderClosingBalance(0);
		transaction.setReceiverOpeningBalance(0);
		transaction.setReceiverClosingBalance(0);
		return transaction;
		
	}
	
	@PutMapping(path="/transfer/{senderId}/{receiverId}/{amount}")
	public Transaction SendAmount(@PathVariable String senderId, @PathVariable String receiverId, @PathVariable String amount) {
		
		try {
			if(Double.parseDouble(amount) > 0 ) {
				boolean isSender = customerService.isCustomer(Integer.parseInt(senderId));
				boolean isReceiver = customerService.isCustomer(Integer.parseInt(receiverId));
				if(isSender && isReceiver) {
					Customer sender = customerService.getCustomerById(senderId);
					if(sender.getBalance() >= Double.parseDouble(amount)) {
						Customer receiver = customerService.getCustomerById(receiverId);
						double senderOpeningBalance = sender.getBalance();
						double senderClosingBalance = senderOpeningBalance - Double.parseDouble(amount);
						sender.setBalance(senderClosingBalance);
						double receiverOpeningBalance = receiver.getBalance();
						double receiverClosingBalance = receiverOpeningBalance + Double.parseDouble(amount);
						receiver.setBalance(receiverClosingBalance);
						return transactionService.sendAmount(Integer.parseInt(senderId), Integer.parseInt(receiverId), senderOpeningBalance, senderClosingBalance, receiverOpeningBalance, receiverClosingBalance);
					}else {
						throw new Exception();
					}
				}
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			e.getMessage();
		}
		
		Transaction transaction = new Transaction();
		transaction.setReceiverId(0);
		transaction.setSenderId(0);
		transaction.setTimestamp(new Timestamp(System.currentTimeMillis()));
		transaction.setType("INVALID TRANSACTION");
		transaction.setSenderOpeningBalance(0);
		transaction.setSenderClosingBalance(0);
		transaction.setReceiverOpeningBalance(0);
		transaction.setReceiverClosingBalance(0);
		return transaction;
		
	}	

}
