package com.example.Hackerearth.dto;

public class Logindetailsdto {

	private String emailid;
	private String password;
	private String roles;
	public Logindetailsdto() {
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
	public Logindetailsdto(String emailid, String password, String roles) {
		super();
		this.emailid = emailid;
		this.password = password;
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "logindetails [emailid=" + emailid + ", password=" + password + ", roles=" + roles + "]";
	}
	

}
