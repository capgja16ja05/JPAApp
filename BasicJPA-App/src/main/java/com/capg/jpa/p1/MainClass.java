package com.capg.jpa.p1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.capg.jpa.p3.Insurance;
import com.capg.jpa.p3.LifeInsurance;
import com.capg.jpa.p3.MedicalInsurance;


public class MainClass {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();

		System.out.println("1");

		Session session = factory.openSession();// jdbc -> coonection object
		Transaction t = session.beginTransaction();

		// ---- write code for data base operation ----

		Account a = new Account();

	
		a.setAccountHolderName("Mike");
		a.setBalance(2000);
		a.setOpenningDate(LocalDate.now());

		Address address = new Address(123, "Banglore", "Banglore");
		a.setAddress(address);

		Address officeaddress = new Address(5848, "New Delhi", "Delhi");
		a.setOffice_address(officeaddress);

		// ---------- Embedded Collection Insertion

		Policy p1 = new Policy("Policy-X", 1000, 2000);
		Policy p2 = new Policy("Policy-Y", 2000, 3000);
		Policy p3 = new Policy("Policy-Z", 3000, 14000);

		List<Policy> policyList = Arrays.asList(p1, p2, p3);
		a.setPolicies(policyList);

		// ------------ One To One

		TaxationFile file = new TaxationFile("abc123", 2000, LocalDate.now());
		a.setTaxFile(file);
		
		
		// ----------  One to Many Entry -----------
		
		com.capg.jpa.p1.Transaction t1 = new com.capg.jpa.p1.Transaction(2000,LocalDateTime.now());
		com.capg.jpa.p1.Transaction t2 = new com.capg.jpa.p1.Transaction(5000,LocalDateTime.now());
		com.capg.jpa.p1.Transaction t3 = new com.capg.jpa.p1.Transaction(7000,LocalDateTime.now());
		
		List<com.capg.jpa.p1.Transaction> transactionList = Arrays.asList(t1,t2,t3);  // stream session
		
		a.setTransactions(transactionList);
		
		 // ---------- Adding Insurance Inheritance Mapping ----------
		
		Insurance i1 = new LifeInsurance(16000, a.getAccountHolderName(), LocalDate.now(), 7400000, 35);
		Insurance i2 = new MedicalInsurance(7800, a.getAccountHolderName(), LocalDate.now(), 600000, 180000);
		
		
		List<Insurance> insuranceList = Arrays.asList(i1,i2);
		a.setInsuranceList(insuranceList);

		////////////////////////////////////////////////////////////////////////
		// Insertion

		session.save(a); // insert into Account .....

		System.out.println("  -->> Data Saved ..");



		t.commit();

		session.close();
		System.out.println("All Done");

	}
}
