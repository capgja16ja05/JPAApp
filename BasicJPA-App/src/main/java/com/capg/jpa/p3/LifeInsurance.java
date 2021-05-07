package com.capg.jpa.p3;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class LifeInsurance extends Insurance {
	
	private int sumAssured;
	private int policyTenure;
	
	public LifeInsurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LifeInsurance(int premiumAmount, String policyHolderName, LocalDate policyDate
			,int sumAssured, int policyTenure) {
		
		super(premiumAmount, policyHolderName, policyDate);
		this.sumAssured = sumAssured;
		this.policyTenure = policyTenure;
	}
	
	public int getSumAssured() {
		return sumAssured;
	}
	public void setSumAssured(int sumAssured) {
		this.sumAssured = sumAssured;
	}
	public int getPolicyTenure() {
		return policyTenure;
	}
	public void setPolicyTenure(int policyTenure) {
		this.policyTenure = policyTenure;
	}
	@Override
	public String toString() {
		return "LifeInsurance [sumAssured=" + sumAssured + ", policyTenure=" + policyTenure + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + policyTenure;
		result = prime * result + sumAssured;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LifeInsurance other = (LifeInsurance) obj;
		if (policyTenure != other.policyTenure)
			return false;
		if (sumAssured != other.sumAssured)
			return false;
		return true;
	}
	
	

}
