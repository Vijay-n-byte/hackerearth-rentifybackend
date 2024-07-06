package com.example.Hackerearth.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hackerearth.dto.Propertiesofsellersdto;
import com.example.Hackerearth.dto.Propertiesofsellersdtowithsellerinfo;
import com.example.Hackerearth.entities.Properties;
import com.example.Hackerearth.repo.Buyerrepo;
import com.example.Hackerearth.repo.Sellersrepo;

@Service
public class Buyservices {
	
	@Autowired
	private Buyerrepo ldr;
	
	public List<Propertiesofsellersdtowithsellerinfo> getallproperty(int pageno,int pagesize){
		List<Properties> ua=ldr.getallproperties(pageno,pagesize);
	    Long count=ldr.getcount();
		List<Propertiesofsellersdtowithsellerinfo> pdf=new ArrayList<Propertiesofsellersdtowithsellerinfo>();
    	for(Properties p:ua) {
    		Propertiesofsellersdtowithsellerinfo o=new Propertiesofsellersdtowithsellerinfo(p,count.intValue());
    		pdf.add(o);
    	}
		return pdf;
	}
	
	public List<Propertiesofsellersdtowithsellerinfo> getallpropertyfilterbyplace(int pageno,int pagesize,String place){
		List<Properties> ua=ldr.getallpropertiesfilterbyplace(pageno,pagesize,place);
		Long count=ldr.getcountplace(place);
		List<Propertiesofsellersdtowithsellerinfo> pdf=new ArrayList<Propertiesofsellersdtowithsellerinfo>();
    	for(Properties p:ua) {
    		Propertiesofsellersdtowithsellerinfo o=new Propertiesofsellersdtowithsellerinfo(p,count.intValue());
    		pdf.add(o);
    	}
		return pdf;
	}
	
	public List<Propertiesofsellersdtowithsellerinfo> getallpropertyfilterbyarea(int pageno,int pagesize,String area){
		List<Properties> ua=ldr.getallpropertiesfilterbyarea(pageno,pagesize,area);
		Long count=ldr.getcountarea(area);
		List<Propertiesofsellersdtowithsellerinfo> pdf=new ArrayList<Propertiesofsellersdtowithsellerinfo>();
    	for(Properties p:ua) {
    		Propertiesofsellersdtowithsellerinfo o=new Propertiesofsellersdtowithsellerinfo(p,count.intValue());
    		pdf.add(o);
    	}
		return pdf;
	}

	public List<Propertiesofsellersdtowithsellerinfo> getallpropertyfilterbyplacearea(int pageno,int pagesize,String place,String area){
		List<Properties> ua=ldr.getallpropertiesfilterbyplacearea(pageno,pagesize,place,area);
		Long count=ldr.getcountarea(area);
		List<Propertiesofsellersdtowithsellerinfo> pdf=new ArrayList<Propertiesofsellersdtowithsellerinfo>();
    	for(Properties p:ua) {
    		Propertiesofsellersdtowithsellerinfo o=new Propertiesofsellersdtowithsellerinfo(p,count.intValue());
    		pdf.add(o);
    	}
		return pdf;
	}
}
