package com.example.Hackerearth.entities;

import org.springframework.stereotype.Component;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Component
@Table(name="credentials")
public class Credentials {
	@Id
	private String emailid;
	@Nonnull
	private String password;
	private String roles;
	@OneToOne
	private Useraccounts account;
	public Credentials() {
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
	public Useraccounts getAccount() {
		return account;
	}
	public void setAccount(Useraccounts account) {
		this.account = account;
	}
	
	
}
