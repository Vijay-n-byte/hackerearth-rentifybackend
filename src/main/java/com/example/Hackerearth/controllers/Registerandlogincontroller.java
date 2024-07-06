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

import com.example.Hackerearth.dto.Newusersdto;
import com.example.Hackerearth.dto.Tokendto;
import com.example.Hackerearth.dto.Usernamepassworddto;
import com.example.Hackerearth.enums.Roles;
import com.example.Hackerearth.repo.Logindetailsrepo;
import com.example.Hackerearth.services.Jwtservice;
import com.example.Hackerearth.services.Useraccountservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@CrossOrigin(origins="http://192.168.43.122:4200")
//@CrossOrigin(origins="http://ec2-54-89-222-88.compute-1.amazonaws.com:4200")
@RestController
@RequestMapping("/rentify")
public class Registerandlogincontroller {

	@Autowired
	private Useraccountservice us;
	@Autowired
	private Logindetailsrepo ldr;
	@Autowired
	private AuthenticationManager am;
	@Autowired
	private Jwtservice js;
	
	@GetMapping("/welcome")  //0->username exists already .1->new user.registration successful.
	public String welcome() {
		return "hello";
	}	
	
	@PostMapping("/users")  //0->username exists already .1->new user.registration successful.
	public int addnewusers(@RequestBody Newusersdto n) {
		return us.addnewusersservicemethod(n);
	}		
	@PostMapping("/login")
	public Tokendto loginusers(@RequestBody Usernamepassworddto n,HttpServletResponse response) throws AuthenticationException{
		System.out.println("before");
		Tokendto t=new Tokendto();
		Authentication j=new UsernamePasswordAuthenticationToken(n.getEmailid(),n.getPassword());
		System.out.println(j);
		try {
			Authentication b=am.authenticate(j);
			if(b.isAuthenticated()) {
				System.out.println("eeeee");
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
