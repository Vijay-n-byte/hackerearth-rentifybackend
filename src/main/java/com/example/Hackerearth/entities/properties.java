package com.example.Hackerearth.entities;

import org.springframework.stereotype.Component;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Component
public class properties {
	
	@Id
	private String propertyid;
	private String place;
	private String area;
	@Embedded
	private propertydetails pd;
	@ManyToOne
	@JoinColumn(name="owner")
	private useraccounts ua;
	public properties() {
		super();
	}
	public String getPropertyid() {
		return propertyid;
	}
	public void setPropertyid(String propertyid) {
		this.propertyid = propertyid;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public propertydetails getPd() {
		return pd;
	}
	public void setPd(propertydetails pd) {
		this.pd = pd;
	}
	public useraccounts getUa() {
		return ua;
	}
	public void setUa(useraccounts ua) {
		this.ua = ua;
	}
	
	

}
