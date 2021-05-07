package com.capg.jpa.p1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainForGet {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();

		System.out.println("1");

		Session session = factory.openSession();// jdbc -> coonection object
		Transaction t = session.beginTransaction();
		
		Account a = (Account) session.get(Account.class, 1);
		//
		System.out.println("\n Accounts Info :- "+a);
		System.out.println("\n Tax File Information :- "+a.getTaxFile());
		System.out.println("\n Tax Submitted  :- "+a.getTaxFile().getTaxSubmitted());
		
		
		TaxationFile file = session.get(TaxationFile.class, a.getTaxFile().getPanNumber());
		
		System.out.println("\n Tax Info :- "+file);
		System.out.println("\n Account Info  :- "+file.getAccount());
		System.out.println("\n Account Holder Name   :- "+file.getAccount().getAccountHolderName());
		
				
				
		t.commit();
		
	}

}
