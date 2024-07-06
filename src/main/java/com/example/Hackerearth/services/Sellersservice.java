package com.example.Hackerearth.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Hackerearth.dto.Logindetailsdto;
import com.example.Hackerearth.dto.Propertiesofsellersdto;
import com.example.Hackerearth.dto.Propertydto;
import com.example.Hackerearth.entities.Logindetails;
import com.example.Hackerearth.entities.Properties;
import com.example.Hackerearth.entities.Propertydetails;
import com.example.Hackerearth.entities.Useraccounts;
import com.example.Hackerearth.repo.Sellersrepo;
import com.example.Hackerearth.repo.Usersrepo;
import java.util.ArrayList;

@Service
public class Sellersservice {

	@Autowired
	private Sellersrepo ldr;
	@Autowired
	private Usersrepo ur;
	
	public void postproperty(Propertydto p,String username){
		Properties k=new Properties();
		k.setArea(p.getArea());
		k.setPlace(p.getPlace());
		UUID u1=UUID.randomUUID();
		k.setPropertyid(u1.toString());
		Propertydetails pd=new Propertydetails();
		pd.setNoofsqmeters(p.getNoofsqmeters());
		pd.setNoofbredrooms(p.getNoofbredrooms());
		pd.setNoofbathrooms(p.getNoofbathrooms());
		pd.setNearbylandmark1(p.getNearbylandmark1());
		pd.setNearbylandmark2(p.getNearbylandmark2());
		pd.setNearbylandmark3(p.getNearbylandmark3());
		k.setPd(pd);
		Useraccounts ac=ur.getuseraccountbyemailid(username);
		k.setUa(ac);
		ldr.addproperty(k);
	}
	
	public void deleteproperty(String propertyid){
		ldr.deletepropertybypropertyid(propertyid);
	}
	
	public void updateproperty(String propertyid,Propertydto p){
		Properties k=ldr.getsingleproperty(propertyid);
		k.setArea(p.getArea());
		k.setPlace(p.getPlace());
		Propertydetails pd=new Propertydetails();
		pd.setNoofsqmeters(p.getNoofsqmeters());
		pd.setNoofbredrooms(p.getNoofbredrooms());
		pd.setNoofbathrooms(p.getNoofbathrooms());
		pd.setNearbylandmark1(p.getNearbylandmark1());
		pd.setNearbylandmark2(p.getNearbylandmark2());
		pd.setNearbylandmark3(p.getNearbylandmark3());
		k.setPd(pd);
		ldr.updateproperty(k);
	}
	
	public List<Propertiesofsellersdto> getallproperty(String emailid){
		List<Properties> ua=ldr.getallproperties(emailid);
		List<Propertiesofsellersdto> pdf=new ArrayList<Propertiesofsellersdto>();
    	for(Properties p:ua) {
    		Propertiesofsellersdto o=new Propertiesofsellersdto(p);
    		pdf.add(o);
    	}
		return pdf;
	}
	
}
