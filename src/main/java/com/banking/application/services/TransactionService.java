package com.banking.application.services;

import com.banking.application.entities.Transaction;
import com.banking.application.helpers.CustomerIdAndBalancePair;

public interface TransactionService {

	CustomerIdAndBalancePair getBalanceForCustomer(int customerId);

	Transaction withdrawAmount(int customerId, double amount);

	Transaction AddAmount(int customerId, double openingBalance, double closingBalance);

	Transaction sendAmount(int senderId, int receiverId, double senderOpeningBalance, double senderClosingBalance, double receiverOpeningBalance, double receiverClosingBalance);

}
