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
@Table(name="useraccounts")
@Component
public class Useraccounts {

	@Id
	private String accountid;
	private String firstname;
	private String lastname;
	private String phonenumber;
	@OneToMany(mappedBy="ua")
	@Column(nullable=true)
	private List<Properties> houses;
	@OneToOne(mappedBy="account")
	@JsonIgnore
	private Credentials c;
	public Useraccounts() {
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
	public List<Properties> getHouses() {
		return houses;
	}
	public void setHouses(List<Properties> houses) {
		this.houses = houses;
	}
	public Credentials getC() {
		return c;
	}
	public void setC(Credentials c) {
		this.c = c;
	}
	
	
}
