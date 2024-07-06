package com.example.Hackerearth.dto;

public class Tokendto {
	private String token;
	private int error;  //0->no error 1->username error 2->password error
	private int role;
	public Tokendto() {
		super();
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	

}
