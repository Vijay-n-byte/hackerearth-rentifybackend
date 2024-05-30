package com.example.Hackerearth.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hackerearth.dto.propertiesofsellersdto;
import com.example.Hackerearth.dto.propertiesofsellersdtowithsellerinfo;
import com.example.Hackerearth.entities.properties;
import com.example.Hackerearth.repo.buyerrepo;
import com.example.Hackerearth.repo.sellersrepo;

@Service
public class buyservices {
	
	@Autowired
	private buyerrepo ldr;
	
	public List<propertiesofsellersdtowithsellerinfo> getallproperty(int pageno,int pagesize){
		List<properties> ua=ldr.getallproperties(pageno,pagesize);
	    Long count=ldr.getcount();
		List<propertiesofsellersdtowithsellerinfo> pdf=new ArrayList<propertiesofsellersdtowithsellerinfo>();
    	for(properties p:ua) {
    		propertiesofsellersdtowithsellerinfo o=new propertiesofsellersdtowithsellerinfo(p,count.intValue());
    		pdf.add(o);
    	}
		return pdf;
	}
	
	public List<propertiesofsellersdtowithsellerinfo> getallpropertyfilterbyplace(int pageno,int pagesize,String place){
		List<properties> ua=ldr.getallpropertiesfilterbyplace(pageno,pagesize,place);
		Long count=ldr.getcountplace(place);
		List<propertiesofsellersdtowithsellerinfo> pdf=new ArrayList<propertiesofsellersdtowithsellerinfo>();
    	for(properties p:ua) {
    		propertiesofsellersdtowithsellerinfo o=new propertiesofsellersdtowithsellerinfo(p,count.intValue());
    		pdf.add(o);
    	}
		return pdf;
	}
	
	public List<propertiesofsellersdtowithsellerinfo> getallpropertyfilterbyarea(int pageno,int pagesize,String area){
		List<properties> ua=ldr.getallpropertiesfilterbyarea(pageno,pagesize,area);
		Long count=ldr.getcountarea(area);
		List<propertiesofsellersdtowithsellerinfo> pdf=new ArrayList<propertiesofsellersdtowithsellerinfo>();
    	for(properties p:ua) {
    		propertiesofsellersdtowithsellerinfo o=new propertiesofsellersdtowithsellerinfo(p,count.intValue());
    		pdf.add(o);
    	}
		return pdf;
	}

	public List<propertiesofsellersdtowithsellerinfo> getallpropertyfilterbyplacearea(int pageno,int pagesize,String place,String area){
		List<properties> ua=ldr.getallpropertiesfilterbyplacearea(pageno,pagesize,place,area);
		Long count=ldr.getcountarea(area);
		List<propertiesofsellersdtowithsellerinfo> pdf=new ArrayList<propertiesofsellersdtowithsellerinfo>();
    	for(properties p:ua) {
    		propertiesofsellersdtowithsellerinfo o=new propertiesofsellersdtowithsellerinfo(p,count.intValue());
    		pdf.add(o);
    	}
		return pdf;
	}
}
