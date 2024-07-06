package com.example.Hackerearth.entities;

import org.springframework.stereotype.Component;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name="properties")
public class Properties {
	
	@Id
	private String propertyid;
	private String place;
	private String area;
	@Embedded
	private Propertydetails pd;
	@ManyToOne
	@JoinColumn(name="owner")
	private Useraccounts ua;
	public Properties() {
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
	public Propertydetails getPd() {
		return pd;
	}
	public void setPd(Propertydetails pd) {
		this.pd = pd;
	}
	public Useraccounts getUa() {
		return ua;
	}
	public void setUa(Useraccounts ua) {
		this.ua = ua;
	}
	
	

}
