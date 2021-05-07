package com.capg.jpa.p1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MainClass {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();

		System.out.println("1");

		Session session = factory.openSession();// jdbc -> coonection object
		Transaction t = session.beginTransaction();

		// ---- write code for data base operation ----

		Account a = new Account();

		a.setAccId(107);
		a.setAccountHolderName("Ramesh");
		a.setBalance(2000);
		a.setOpenningDate(LocalDate.now());

		Address address = new Address(123, "New Delhi", "Delhi");
		a.setAddress(address);

		Address officeaddress = new Address(4848, "New Delhi", "Delhi");
		a.setOffice_address(officeaddress);

		// ---------- Embedded Collection Insertion

		Policy p1 = new Policy("Policy-A", 100, 2000);
		Policy p2 = new Policy("Policy-B", 200, 3000);
		Policy p3 = new Policy("Policy-C", 300, 4000);

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
		
		
		

		////////////////////////////////////////////////////////////////////////
		// Insertion

		session.save(a); // insert into Account .....

		System.out.println("  -->> Data Saved ..");



		t.commit();

		session.close();
		System.out.println("All Done");

	}
}
