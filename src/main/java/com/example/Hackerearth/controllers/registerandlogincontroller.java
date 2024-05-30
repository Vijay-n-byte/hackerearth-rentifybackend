package com.example.Hackerearth.controllers;

import java.util.Arrays;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hackerearth.dto.newusersdto;
import com.example.Hackerearth.dto.tokendto;
import com.example.Hackerearth.dto.usernamepassworddto;
import com.example.Hackerearth.enums.roles;
import com.example.Hackerearth.repo.logindetailsrepo;
import com.example.Hackerearth.services.jwtservice;
import com.example.Hackerearth.services.useraccountservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins="http://ec2-54-89-222-88.compute-1.amazonaws.com:4200")
@RestController
@RequestMapping("/rentify")
public class registerandlogincontroller {

	@Autowired
	private useraccountservice us;
	@Autowired
	private logindetailsrepo ldr;
	@Autowired
	private AuthenticationManager am;
	@Autowired
	private jwtservice js;
	@PostMapping("/users")  //0->username exists already .1->new user.registration successful.
	public int addnewusers(@RequestBody newusersdto n) {
		return us.addnewusersservicemethod(n);
	}		
	@PostMapping("/login")
	public tokendto loginusers(@RequestBody usernamepassworddto n,HttpServletResponse response) throws AuthenticationException{
	//	System.out.println("before");
		tokendto t=new tokendto();
		Authentication j=new UsernamePasswordAuthenticationToken(n.getEmailid(),n.getPassword());
		try {
			Authentication b=am.authenticate(j);
			if(b.isAuthenticated()) {
				t.setToken(js.generateToken(n.getEmailid()));
				int r=1;
				if(b.getAuthorities().toString().equals("[ROLE_SELLER]")) {
					r=0;
				}
				t.setRole(r);
				t.setError(0);
			}
		}
		catch(InternalAuthenticationServiceException e) {
			t.setError(1);
		}
		catch(BadCredentialsException e) {
			t.setError(2);
		}
		return t;
	}	
}
