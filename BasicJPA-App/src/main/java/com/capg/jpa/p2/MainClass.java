package com.capg.jpa.p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {
	
	public static void main(String[] args) {
		
		MainClass obj = new MainClass();
		
		Configuration cfg = new Configuration();
		SessionFactory fac = cfg.configure().buildSessionFactory();
		Session session = fac.openSession();
		
		TouristApp app1 = obj.getTouristApp();  // like MakeMyTrip
		TouristApp app2 = obj.getTouristApp();  // Trivago
		TouristApp app3 = obj.getTouristApp();  // yatra.com
		
		Hotels hotel1 = obj.getHotel(); // the Taj
		Hotels hotel2 = obj.getHotel();  // De Vivendi
		Hotels hotel3 = obj.getHotel();  // Park regis
		Hotels hotel4 = obj.getHotel(); // Holiday Inn
		Hotels hotel5 = obj.getHotel(); // xyz
		
		
		///----- Creating collections for  Hotels to App1 ----
		
		List<Hotels> hotelListfor_App1 = new ArrayList<Hotels>();
		hotelListfor_App1.add(hotel1);
		hotelListfor_App1.add(hotel2);
		hotelListfor_App1.add(hotel3);
		hotelListfor_App1.add(hotel4);
		hotelListfor_App1.add(hotel5);
		
		List<Hotels> hotelListfor_App2 = new ArrayList<Hotels>();
		hotelListfor_App2.add(hotel1);
		hotelListfor_App2.add(hotel2);
		hotelListfor_App2.add(hotel4);
		
		List<Hotels> hotelListfor_App3 = new ArrayList<Hotels>();
		hotelListfor_App3.add(hotel2);
		hotelListfor_App3.add(hotel4);
		
		
		
		// -------- Creating collections for  Apps to Hotel ---------
		
		List<TouristApp> appListFor_hotel1 = new ArrayList<TouristApp>();
		appListFor_hotel1.add(app1);
		appListFor_hotel1.add(app2);
		
		List<TouristApp> appListFor_hotel2 = new ArrayList<TouristApp>();
		appListFor_hotel2.add(app1);
		appListFor_hotel2.add(app2);
		appListFor_hotel2.add(app3);
		
		List<TouristApp> appListFor_hotel3 = new ArrayList<TouristApp>();
		appListFor_hotel3.add(app1);
		
		List<TouristApp> appListFor_hotel4 = new ArrayList<TouristApp>();
		appListFor_hotel4.add(app1);
		appListFor_hotel4.add(app2);
		appListFor_hotel4.add(app3);
		
		List<TouristApp> appListFor_hotel5 = new ArrayList<TouristApp>();
		appListFor_hotel5.add(app1);
		
		
		// ------------ Adding Collection of Hotel to App ----- 
		
		app1.setHotelList(hotelListfor_App1);
		app2.setHotelList(hotelListfor_App2);
		app3.setHotelList(hotelListfor_App3);
				
		// ------------ Adding Collection of App to Hotel ----- 
				
		hotel1.setListedApps(appListFor_hotel1);
		hotel2.setListedApps(appListFor_hotel2);
		hotel3.setListedApps(appListFor_hotel3);
		hotel4.setListedApps(appListFor_hotel4);
		hotel5.setListedApps(appListFor_hotel5);
				
				
		Transaction t = session.beginTransaction();
		
		
		session.save(app1);
		session.save(app2);
		session.save(app3);
		
		session.save(hotel1);
		session.save(hotel2);
		session.save(hotel3);
		session.save(hotel4);
		session.save(hotel5);
		
		
		t.commit();
		
		System.out.println(" Data Saved");
		
		
		
		
		
		
		
		
	}
	
	public TouristApp getTouristApp()
	{
		TouristApp app = new TouristApp();
		System.out.println("Enter Tourist App Name ");
		app.setAppName(new Scanner(System.in).nextLine());
		
		System.out.println("Enter Tourist App Active User Count ");
		app.setActiveUserCount(new Scanner(System.in).nextInt());
		
		return app;
	}
	
	public Hotels getHotel()
	{
		Hotels hotel = new Hotels();
		System.out.println("Enter Hotel Name ");
		hotel.setHotelName(new Scanner(System.in).nextLine());
	
		return hotel;
	}

}
