package com.example.Hackerearth.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hackerearth.dto.propertiesofsellersdto;
import com.example.Hackerearth.dto.propertydto;
import com.example.Hackerearth.dto.usernamepassworddto;
import com.example.Hackerearth.entities.properties;
import com.example.Hackerearth.repo.sellersrepo;
import com.example.Hackerearth.services.sellersservice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContext;

//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins="http://ec2-54-89-222-88.compute-1.amazonaws.com:4200")
@RestController
@RequestMapping("/seller")
public class sellercontroller {
	
	@Autowired
	private sellersservice ldr;
	
	@PostMapping("/property")
	public int postproperty(@RequestBody propertydto n,HttpServletRequest request) {
		SecurityContext k=(SecurityContext) request.getAttribute("securitycontextholder");
		ldr.postproperty(n,k.getAuthentication().getName());
		return 1;
	}
	@GetMapping("/property")
	public List<propertiesofsellersdto> getallproperty(HttpServletRequest request) {
		SecurityContext k=(SecurityContext) request.getAttribute("securitycontextholder");
		return ldr.getallproperty(k.getAuthentication().getName());
	}
	@PutMapping("/property/{propertyid}")
	public int editpropertydetails(@PathVariable String propertyid,@RequestBody propertydto n) {
		ldr.updateproperty(propertyid, n);
		return 1;
	}
	@DeleteMapping("/property/{pid}")
	public int removeproperty(@PathVariable String pid) {
		ldr.deleteproperty(pid);
		return 1;
	}
}
