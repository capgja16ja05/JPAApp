package com.capg.jpa.p1;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TaxationFile {

	@Id
	private String panNumber;
	private int taxSubmitted;
	private LocalDate submittedDate;
	
	@OneToOne(mappedBy = "taxFile")
	private Account account;
	
	public TaxationFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaxationFile(String panNumber, int taxSubmitted, LocalDate submittedDate) {
		super();
		this.panNumber = panNumber;
		this.taxSubmitted = taxSubmitted;
		this.submittedDate = submittedDate;
	}
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public int getTaxSubmitted() {
		return taxSubmitted;
	}
	public void setTaxSubmitted(int taxSubmitted) {
		this.taxSubmitted = taxSubmitted;
	}
	public LocalDate getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(LocalDate submittedDate) {
		this.submittedDate = submittedDate;
	}
	@Override
	public String toString() {
		return "TaxationFile [panNumber=" + panNumber + ", taxSubmitted=" + taxSubmitted + ", submittedDate="
				+ submittedDate + "]";
	}
	
	
	
}
