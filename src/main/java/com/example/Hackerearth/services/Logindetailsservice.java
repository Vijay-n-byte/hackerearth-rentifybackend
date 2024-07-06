package com.example.Hackerearth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.Hackerearth.dto.Logindetailsdto;
import com.example.Hackerearth.entities.Logindetails;
import com.example.Hackerearth.repo.Logindetailsrepo;
@Service
@EnableCaching
public class Logindetailsservice implements UserDetailsService {

	@Autowired
	private Logindetailsrepo ldr;

	@Override
	@Cacheable(value="logins1",key="#username")
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("fetching userdetails from database");
		Optional<Logindetailsdto> j=Optional.ofNullable(ldr.getcredentialsbyusername(username));
		return j.map(Logindetails::new).orElseThrow(()->new UsernameNotFoundException("not found"));
	}
}
