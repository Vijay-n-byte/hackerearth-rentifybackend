package com.example.Hackerearth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hackerearth.dto.propertiesofsellersdto;
import com.example.Hackerearth.dto.propertiesofsellersdtowithsellerinfo;
import com.example.Hackerearth.services.buyservices;
import com.example.Hackerearth.services.sellersservice;

import jakarta.servlet.http.HttpServletRequest;

//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins="http://ec2-54-89-222-88.compute-1.amazonaws.com:4200")
@RestController
@RequestMapping("/buyer")
public class buyercontroller {

	@Autowired
	private buyservices ldr;
	
	//dummy means none. //filterby->place .//filtervalue-->area
	@GetMapping("/property/{filterby}/{filtervalue}/{pageno}/{noofelements}")
	public List<propertiesofsellersdtowithsellerinfo> getallpropertiesfilterbyplace(@PathVariable String filterby,@PathVariable String filtervalue,@PathVariable int pageno,@PathVariable int noofelements) {
	//	System.out.println("fil");
	//	System.out.println(filterby+" "+filtervalue);
		List<propertiesofsellersdtowithsellerinfo> km = null;
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
	//	System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
	//	System.out.print(km.get(0).getTotaldatas());
		return km;
	}
}
