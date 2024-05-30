package com.example.Hackerearth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.Hackerearth.dto.logindetailsdto;
import com.example.Hackerearth.entities.logindetails;
import com.example.Hackerearth.repo.logindetailsrepo;
@Service
public class logindetailsservice implements UserDetailsService {

	@Autowired
	private logindetailsrepo ldr;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("fetching userdetails from database");
		Optional<logindetailsdto> j=Optional.ofNullable(ldr.getcredentialsbyusername(username));
		return j.map(logindetails::new).orElseThrow(()->new UsernameNotFoundException("not found"));
	}
}
