package com.capg.jpa.p3;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.capg.jpa.p1.Account;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
		 name = "Policy_Type",
		 discriminatorType =DiscriminatorType.STRING
		)
public class Insurance implements Comparable<Insurance>,Serializable
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int insuranceId;
	private int premiumAmount;
	private String policyHolderName;
	private LocalDate policyDate;
	
	

	@ManyToOne
	@JoinColumn(name="Account_Number")
	private Account account;
	
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public Insurance(int premiumAmount, String policyHolderName, LocalDate policyDate) {
		super();
		this.premiumAmount = premiumAmount;
		this.policyHolderName = policyHolderName;
		this.policyDate = policyDate;
	}
	public int getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	public int getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(int premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public String getPolicyHolderName() {
		return policyHolderName;
	}
	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}
	public LocalDate getPolicyDate() {
		return policyDate;
	}
	public void setPolicyDate(LocalDate policyDate) {
		this.policyDate = policyDate;
	}
	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", premiumAmount=" + premiumAmount + ", policyHolderName="
				+ policyHolderName + ", policyDate=" + policyDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + insuranceId;
		result = prime * result + ((policyDate == null) ? 0 : policyDate.hashCode());
		result = prime * result + ((policyHolderName == null) ? 0 : policyHolderName.hashCode());
		result = prime * result + premiumAmount;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Insurance other = (Insurance) obj;
		if (insuranceId != other.insuranceId)
			return false;
		if (policyDate == null) {
			if (other.policyDate != null)
				return false;
		} else if (!policyDate.equals(other.policyDate))
			return false;
		if (policyHolderName == null) {
			if (other.policyHolderName != null)
				return false;
		} else if (!policyHolderName.equals(other.policyHolderName))
			return false;
		if (premiumAmount != other.premiumAmount)
			return false;
		return true;
	}
	@Override
	public int compareTo(Insurance o) {
		// TODO Auto-generated method stub
		// Not Implemented 
		
		return 0;
	}
	
	

}
