package com.capg.jpa.p2;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TouristApp")
public class TouristApp {
	
	@Id
	private String appName;
	private int activeUserCount;
		
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="TouristApp_Hotels",
			joinColumns=@JoinColumn(name="TouristApp"),
			inverseJoinColumns=@JoinColumn(name="Hotel_ID"))
	private List<Hotels> hotelList;

	
	
	public TouristApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public int getActiveUserCount() {
		return activeUserCount;
	}

	public void setActiveUserCount(int activeUserCount) {
		this.activeUserCount = activeUserCount;
	}

	public List<Hotels> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<Hotels> hotelList) {
		this.hotelList = hotelList;
	}

		

}
