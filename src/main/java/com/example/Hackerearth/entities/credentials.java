package com.example.Hackerearth.entities;

import org.springframework.stereotype.Component;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
@Component
public class credentials {
	@Id
	private String emailid;
	@Nonnull
	private String password;
	private String roles;
	@OneToOne
	private useraccounts account;
	public credentials() {
		super();
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public useraccounts getAccount() {
		return account;
	}
	public void setAccount(useraccounts account) {
		this.account = account;
	}
	
	
}
