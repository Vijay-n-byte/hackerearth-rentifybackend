package com.example.Hackerearth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hackerearth.dto.Propertiesofsellersdto;
import com.example.Hackerearth.dto.Propertiesofsellersdtowithsellerinfo;
import com.example.Hackerearth.services.Buyservices;
import com.example.Hackerearth.services.Sellersservice;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins="http://192.168.43.122:4200")
//@CrossOrigin(origins="http://ec2-54-89-222-88.compute-1.amazonaws.com:4200")
@RestController
@RequestMapping("/buyer")
public class Buyercontroller {

	@Autowired
	private Buyservices ldr;
	
	//dummy means none. //filterby->place .//filtervalue-->area
	@GetMapping("/property/{filterby}/{filtervalue}/{pageno}/{noofelements}")
	public List<Propertiesofsellersdtowithsellerinfo> getallpropertiesfilterbyplace(@PathVariable String filterby,@PathVariable String filtervalue,@PathVariable int pageno,@PathVariable int noofelements) {
		List<Propertiesofsellersdtowithsellerinfo> km = null;
		if(filterby.equals("dummy")) {
			if(filtervalue.equals("dummy")) {
				//returns without filter
				km= ldr.getallproperty(pageno,noofelements);
			}
			else {
				//returns filter on area
				km= ldr.getallpropertyfilterbyarea(pageno,noofelements,filtervalue);
			}
		}
		else {
            if(filtervalue.equals("dummy")) {
				//returns filter on place
            	km= ldr.getallpropertyfilterbyplace(pageno,noofelements,filterby);
            	
			}
			else {
				//returns filter on place area
				km=ldr.getallpropertyfilterbyplacearea(pageno,noofelements , filterby, filtervalue);
			}
		}
		return km;
	}
}
