package com.example.Hackerearth.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Hackerearth.dto.logindetailsdto;
import com.example.Hackerearth.dto.propertiesofsellersdto;
import com.example.Hackerearth.dto.propertydto;
import com.example.Hackerearth.entities.logindetails;
import com.example.Hackerearth.entities.properties;
import com.example.Hackerearth.entities.propertydetails;
import com.example.Hackerearth.entities.useraccounts;
import com.example.Hackerearth.repo.sellersrepo;
import com.example.Hackerearth.repo.usersrepo;
import java.util.ArrayList;

@Service
public class sellersservice {

	@Autowired
	private sellersrepo ldr;
	@Autowired
	private usersrepo ur;
	
	public void postproperty(propertydto p,String username){
		properties k=new properties();
		k.setArea(p.getArea());
		k.setPlace(p.getPlace());
		UUID u1=UUID.randomUUID();
		k.setPropertyid(u1.toString());
		propertydetails pd=new propertydetails();
		pd.setNoofsqmeters(p.getNoofsqmeters());
		pd.setNoofbredrooms(p.getNoofbredrooms());
		pd.setNoofbathrooms(p.getNoofbathrooms());
		pd.setNearbylandmark1(p.getNearbylandmark1());
		pd.setNearbylandmark2(p.getNearbylandmark2());
		pd.setNearbylandmark3(p.getNearbylandmark3());
		k.setPd(pd);
		useraccounts ac=ur.getuseraccountbyemailid(username);
		k.setUa(ac);
		ldr.addproperty(k);
	}
	
	public void deleteproperty(String propertyid){
		ldr.deletepropertybypropertyid(propertyid);
	}
	
	public void updateproperty(String propertyid,propertydto p){
		properties k=ldr.getsingleproperty(propertyid);
		k.setArea(p.getArea());
		k.setPlace(p.getPlace());
		propertydetails pd=new propertydetails();
		pd.setNoofsqmeters(p.getNoofsqmeters());
		pd.setNoofbredrooms(p.getNoofbredrooms());
		pd.setNoofbathrooms(p.getNoofbathrooms());
		pd.setNearbylandmark1(p.getNearbylandmark1());
		pd.setNearbylandmark2(p.getNearbylandmark2());
		pd.setNearbylandmark3(p.getNearbylandmark3());
		k.setPd(pd);
		ldr.updateproperty(k);
	}
	
	public List<propertiesofsellersdto> getallproperty(String emailid){
		List<properties> ua=ldr.getallproperties(emailid);
		List<propertiesofsellersdto> pdf=new ArrayList<propertiesofsellersdto>();
    	for(properties p:ua) {
    		propertiesofsellersdto o=new propertiesofsellersdto(p);
    		pdf.add(o);
    	}
		return pdf;
	}
	
}
