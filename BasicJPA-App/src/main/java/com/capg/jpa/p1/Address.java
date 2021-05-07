package com.capg.jpa.p1;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "buildingAddress")
	private int houseNumber;
	private String cityName;
	private String state;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int houseNumber, String cityName, String state) {
		super();
		this.houseNumber = houseNumber;
		this.cityName = cityName;
		this.state = state;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", cityName=" + cityName + ", state=" + state + "]";
	}
	
	
}
