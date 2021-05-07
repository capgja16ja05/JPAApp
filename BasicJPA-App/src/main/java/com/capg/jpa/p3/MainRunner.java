package com.capg.jpa.p3;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainRunner {

	public static void main(String[] args) {

		// Super-class
		Insurance insurance = new Insurance(5000, "Ramesh", LocalDate.now());

		// child-class
		LifeInsurance li1 = new LifeInsurance(5000, "Mahesh", LocalDate.now(), 800000, 10);

		// child-class
		MedicalInsurance mi = new MedicalInsurance(4800, "Rakesh", LocalDate.now(), 10000, 2000);

		Configuration cfg = new Configuration();
		SessionFactory fac = cfg.configure().buildSessionFactory();
		Session session = fac.openSession();

		Transaction t = session.beginTransaction();
		
		// EntityManager em; 
		session.save(insurance);
		session.save(li1);
		session.save(mi);
		
		mi.setMedicalCoverage(55555);
		t.commit();

		System.out.println(" Data Saved");
		
		
	}
}
