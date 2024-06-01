package com.banking.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.application.entities.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Integer>{

}
