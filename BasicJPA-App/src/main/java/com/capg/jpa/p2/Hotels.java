package com.capg.jpa.p2;

import java.util.ArrayList;
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
@Table(name="Hotels")
public class Hotels {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String hotelName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="TouristApp_Hotels",
			joinColumns=@JoinColumn(name="Hotel_ID"),
			inverseJoinColumns=@JoinColumn(name="TouristApp"))
	private List<TouristApp> listedApps;

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public List<TouristApp> getListedApps() {
		return listedApps;
	}

	public void setListedApps(List<TouristApp> listedApps) {
		this.listedApps = listedApps;
	}
	
	
	
}
