package com.example.Hackerearth.dto;

public class usernamepassworddto {

	private String emailid;
	private String password;
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
	public usernamepassworddto() {
		super();
	}
	@Override
	public String toString() {
		return "usernamepassworddto [emailid=" + emailid + ", password=" + password + "]";
	}
}
