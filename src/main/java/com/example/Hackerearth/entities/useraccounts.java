package com.example.Hackerearth.entities;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
@Component
public class useraccounts {

	@Id
	private String accountid;
	private String firstname;
	private String lastname;
	private String phonenumber;
	@OneToMany(mappedBy="ua")
	@Column(nullable=true)
	private List<properties> houses;
	@OneToOne(mappedBy="account")
	@JsonIgnore
	private credentials c;
	public useraccounts() {
		super();
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public List<properties> getHouses() {
		return houses;
	}
	public void setHouses(List<properties> houses) {
		this.houses = houses;
	}
	public credentials getC() {
		return c;
	}
	public void setC(credentials c) {
		this.c = c;
	}
	
	
}
