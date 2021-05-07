package com.capg.jpa.p1;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tid;
	private int transactionAmount;
	private LocalDateTime transactionTime;
	
	
	@ManyToOne
	@JoinColumn(name="Account_Number")
	private Account account;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int transactionAmount, LocalDateTime transactionTime) {
		super();
		this.transactionAmount = transactionAmount;
		this.transactionTime = transactionTime;
	}
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}
	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", transactionAmount=" + transactionAmount + ", transactionTime="
				+ transactionTime + "]";
	}
	
	
	
	
}//end class
