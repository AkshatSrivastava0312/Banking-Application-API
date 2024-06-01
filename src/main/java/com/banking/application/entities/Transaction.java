package com.banking.application.entities;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int senderId;
	private int receiverId;
	private String type;
	private double senderOpeningBalance;
	private double senderClosingBalance;
	private double receiverOpeningBalance;
	private double receiverClosingBalance;
	@CreationTimestamp
	private Timestamp timestamp;	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int id, int senderId, int receiverId, String type, double senderOpeningBalance,
			double senderClosingBalance, double receiverOpeningBalance, double receiverClosingBalance,
			Timestamp timestamp) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.type = type;
		this.senderOpeningBalance = senderOpeningBalance;
		this.senderClosingBalance = senderClosingBalance;
		this.receiverOpeningBalance = receiverOpeningBalance;
		this.receiverClosingBalance = receiverClosingBalance;
		this.timestamp = timestamp;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}
	

	public double getSenderOpeningBalance() {
		return senderOpeningBalance;
	}

	public void setSenderOpeningBalance(double senderOpeningBalance) {
		this.senderOpeningBalance = senderOpeningBalance;
	}

	public double getSenderClosingBalance() {
		return senderClosingBalance;
	}

	public void setSenderClosingBalance(double senderClosingBalance) {
		this.senderClosingBalance = senderClosingBalance;
	}

	public double getReceiverOpeningBalance() {
		return receiverOpeningBalance;
	}

	public void setReceiverOpeningBalance(double receiverOpeningBalance) {
		this.receiverOpeningBalance = receiverOpeningBalance;
	}

	public double getReceiverClosingBalance() {
		return receiverClosingBalance;
	}

	public void setReceiverClosingBalance(double receiverClosingBalance) {
		this.receiverClosingBalance = receiverClosingBalance;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", senderId=" + senderId + ", receiverId=" + receiverId + ", type=" + type
				+ ", senderOpeningBalance=" + senderOpeningBalance + ", senderClosingBalance=" + senderClosingBalance
				+ ", receiverOpeningBalance=" + receiverOpeningBalance + ", receiverClosingBalance="
				+ receiverClosingBalance + ", timestamp=" + timestamp + "]";
	}
	
}
