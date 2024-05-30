package com.example.Hackerearth.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Hackerearth.entities.credentials;
import com.example.Hackerearth.entities.properties;
import com.example.Hackerearth.entities.useraccounts;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
@Component
public class usersrepo {

	@Autowired
	private EntityManager em;
	
	public credentials getsingleuser(String username) {
		return em.find(credentials.class, username);
    }
	
    public int addnewusersrepomethod(useraccounts ud,credentials c) {
    	em.persist(ud);
    	em.persist(c);
    	return 1;
    }
    
    public useraccounts getuseraccountbyemailid(String emailid) {
    	credentials v=em.find(credentials.class, emailid);
    	return v.getAccount();
    }
}
