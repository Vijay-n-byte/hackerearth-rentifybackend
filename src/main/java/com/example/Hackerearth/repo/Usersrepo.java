package com.example.Hackerearth.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Hackerearth.entities.Credentials;
import com.example.Hackerearth.entities.Properties;
import com.example.Hackerearth.entities.Useraccounts;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
@Component
public class Usersrepo {

	@Autowired
	private EntityManager em;
	
	public Credentials getsingleuser(String username) {
		return em.find(Credentials.class, username);
    }
	
    public int addnewusersrepomethod(Useraccounts ud,Credentials c) {
    	em.persist(ud);
    	em.persist(c);
    	return 1;
    }
    
    public Useraccounts getuseraccountbyemailid(String emailid) {
    	Credentials v=em.find(Credentials.class, emailid);
    	return v.getAccount();
    }
}
