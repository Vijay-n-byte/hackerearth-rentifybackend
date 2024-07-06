package com.example.Hackerearth.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Hackerearth.entities.Credentials;
import com.example.Hackerearth.entities.Properties;
import com.example.Hackerearth.dto.Propertiesofsellersdto;
import jakarta.persistence.EntityManager;

@Repository
@Transactional
@Component
public class Sellersrepo {

	@Autowired
	private EntityManager em;
	
    public void addproperty(Properties ud) {
    	em.persist(ud);
    }
    
    public Properties getsingleproperty(String propertyid) {
    	return em.find(Properties.class, propertyid);
    }
    
    public void deletepropertybypropertyid(String propertyid) {
    	Properties p=em.find(Properties.class, propertyid);
    	em.remove(p);
    }
    
    public void updateproperty(Properties propertyid) {
    	em.merge(propertyid);
    }
    
    public List<Properties> getallproperties(String emailid) {
    	Credentials c=em.find(Credentials.class, emailid);
    	List<Properties> ua=c.getAccount().getHouses();
    	return ua;
    }
}
