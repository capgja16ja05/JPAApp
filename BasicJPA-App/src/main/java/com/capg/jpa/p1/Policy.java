package com.capg.jpa.p1;

import javax.persistence.Embeddable;

@Embeddable
public class Policy {

	
	private String policyName;
	private int premiumAmount;
	private int sumAssured;
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Policy(String policyName, int premiumAmount, int sumAssured) {
		super();
		this.policyName = policyName;
		this.premiumAmount = premiumAmount;
		this.sumAssured = sumAssured;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public int getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(int premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public int getSumAssured() {
		return sumAssured;
	}
	public void setSumAssured(int sumAssured) {
		this.sumAssured = sumAssured;
	}
	@Override
	public String toString() {
		return "Policy [policyName=" + policyName + ", premiumAmount=" + premiumAmount + ", sumAssured=" + sumAssured
				+ "]";
	}
	
	
	
}
