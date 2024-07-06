package com.example.Hackerearth.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Hackerearth.dto.Logindetailsdto;

public class Logindetails implements UserDetails{

	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	

	public Logindetails(Logindetailsdto l) {
		this.username = l.getEmailid();
		this.password = l.getPassword();
		List<GrantedAuthority> j=new ArrayList<GrantedAuthority>();
		j.add(new SimpleGrantedAuthority(l.getRoles()));
		this.authorities=j;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
