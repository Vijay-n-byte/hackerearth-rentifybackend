package com.example.Hackerearth.entities;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Component
@Embeddable
public class Propertydetails {

	private int noofsqmeters;
	private int noofbredrooms;
	private int noofbathrooms;
	@Column(nullable=true)
	private String nearbylandmark1;
	@Column(nullable=true)
	private String nearbylandmark2;
	@Column(nullable=true)
	private String nearbylandmark3;
	public Propertydetails() {
		super();
	}
	public int getNoofsqmeters() {
		return noofsqmeters;
	}
	public void setNoofsqmeters(int noofsqmeters) {
		this.noofsqmeters = noofsqmeters;
	}
	public int getNoofbredrooms() {
		return noofbredrooms;
	}
	public void setNoofbredrooms(int noofbredrooms) {
		this.noofbredrooms = noofbredrooms;
	}
	public int getNoofbathrooms() {
		return noofbathrooms;
	}
	public void setNoofbathrooms(int noofbathrooms) {
		this.noofbathrooms = noofbathrooms;
	}
	public String getNearbylandmark1() {
		return nearbylandmark1;
	}
	public void setNearbylandmark1(String nearbylandmark1) {
		this.nearbylandmark1 = nearbylandmark1;
	}
	public String getNearbylandmark2() {
		return nearbylandmark2;
	}
	public void setNearbylandmark2(String nearbylandmark2) {
		this.nearbylandmark2 = nearbylandmark2;
	}
	public String getNearbylandmark3() {
		return nearbylandmark3;
	}
	public void setNearbylandmark3(String nearbylandmark3) {
		this.nearbylandmark3 = nearbylandmark3;
	}

}
