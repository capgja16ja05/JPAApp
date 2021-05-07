package com.capg.jpa.p3;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Mediclaim")
public class MedicalInsurance extends Insurance {
	
	private int medicalCoverage;
	private int pharmaCoverage;
	
	public MedicalInsurance() {
		
	}
	
	public MedicalInsurance(int premiumAmount, String policyHolderName, LocalDate policyDate,int medicalCoverage, int pharmaCoverage) {
		super(premiumAmount, policyHolderName, policyDate);
			this.medicalCoverage = medicalCoverage;
		this.pharmaCoverage = pharmaCoverage;
	}

	public int getMedicalCoverage() {
		return medicalCoverage;
	}

	public void setMedicalCoverage(int medicalCoverage) {
		this.medicalCoverage = medicalCoverage;
	}

	public int getPharmaCoverage() {
		return pharmaCoverage;
	}

	public void setPharmaCoverage(int pharmaCoverage) {
		this.pharmaCoverage = pharmaCoverage;
	}

	@Override
	public String toString() {
		return "MedicalInsurance [medicalCoverage=" + medicalCoverage + ", pharmaCoverage=" + pharmaCoverage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + medicalCoverage;
		result = prime * result + pharmaCoverage;
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
		MedicalInsurance other = (MedicalInsurance) obj;
		if (medicalCoverage != other.medicalCoverage)
			return false;
		if (pharmaCoverage != other.pharmaCoverage)
			return false;
		return true;
	}


}
