package com.banking.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.application.dao.CustomerDao;
import com.banking.application.dao.TransactionDao;
import com.banking.application.entities.Customer;
import com.banking.application.entities.Transaction;
import com.banking.application.helpers.CustomerIdAndBalancePair;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public CustomerIdAndBalancePair getBalanceForCustomer(int customerId) {
		Customer customer = customerDao.getCustomerById(customerId);
		double balance = customer.getBalance();
		
		CustomerIdAndBalancePair pair = new CustomerIdAndBalancePair(customerId, balance);
		
		Transaction transaction = new Transaction();
		transaction.setReceiverId(customerId);
		transaction.setSenderId(customerId);
		transaction.setType("BALANCE ENQUIRY");
		transaction.setSenderOpeningBalance(balance);
		transaction.setSenderClosingBalance(balance);
		transaction.setReceiverOpeningBalance(balance);
		transaction.setReceiverClosingBalance(balance);
	
		transactionDao.save(transaction);
		
		return pair;
		
	}

	@Override
	public Transaction withdrawAmount(int customerId, double amount) {
		
		Transaction transaction = new Transaction();
		transaction.setReceiverId(customerId);
		transaction.setSenderId(customerId);
		transaction.setType("WITHDRAW");
		transaction.setSenderOpeningBalance(amount);
		transaction.setSenderClosingBalance(amount);
		transaction.setReceiverOpeningBalance(amount);
		transaction.setReceiverClosingBalance(amount);
	
		transactionDao.save(transaction);
		
		return transaction;
	}

	@Override
	public Transaction AddAmount(int customerId, double openingBalance, double closingBalance) {
		
		Transaction transaction = new Transaction();
		transaction.setReceiverId(customerId);
		transaction.setSenderId(customerId);
		transaction.setType("ADD MONEY");
		transaction.setSenderOpeningBalance(openingBalance);
		transaction.setSenderClosingBalance(closingBalance);
		transaction.setReceiverOpeningBalance(openingBalance);
		transaction.setReceiverClosingBalance(closingBalance);
	
		transactionDao.save(transaction);
		
		return transaction;
		
	}

	@Override
	public Transaction sendAmount(int senderId, int receiverId, double senderOpeningBalance, double senderClosingBalance, double receiverOpeningBalance, double receiverClosingBalance) {
		
		Transaction transaction = new Transaction();
		transaction.setReceiverId(receiverId);
		transaction.setSenderId(senderId);
		transaction.setType("BALANCE TRANSFER");
		transaction.setSenderOpeningBalance(senderOpeningBalance);
		transaction.setSenderClosingBalance(senderClosingBalance);
		transaction.setReceiverOpeningBalance(receiverOpeningBalance);
		transaction.setReceiverClosingBalance(receiverClosingBalance);
	
		transactionDao.save(transaction);
		
		return transaction;
		
	}

}
