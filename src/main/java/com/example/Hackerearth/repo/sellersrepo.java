package com.example.Hackerearth.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Hackerearth.entities.credentials;
import com.example.Hackerearth.entities.properties;
import com.example.Hackerearth.dto.propertiesofsellersdto;
import jakarta.persistence.EntityManager;

@Repository
@Transactional
@Component
public class sellersrepo {

	@Autowired
	private EntityManager em;
	
    public void addproperty(properties ud) {
    	em.persist(ud);
    }
    
    public properties getsingleproperty(String propertyid) {
    	return em.find(properties.class, propertyid);
    }
    
    public void deletepropertybypropertyid(String propertyid) {
    	properties p=em.find(properties.class, propertyid);
    	em.remove(p);
    }
    
    public void updateproperty(properties propertyid) {
    	em.merge(propertyid);
    }
    
    public List<properties> getallproperties(String emailid) {
    	credentials c=em.find(credentials.class, emailid);
    	List<properties> ua=c.getAccount().getHouses();
    	return ua;
    }
}
