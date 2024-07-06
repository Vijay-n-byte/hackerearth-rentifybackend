package com.example.Hackerearth.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Hackerearth.dto.Logindetailsdto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class Logindetailsrepo {

	@Autowired
	private EntityManager em;
	
	public Logindetailsdto getcredentialsbyusername(String username) {
		TypedQuery<Logindetailsdto> n=em.createQuery("select c.emailid,c.password,c.roles from Credentials c where emailid=:star", Logindetailsdto.class);
		n.setParameter("star", username);
		Logindetailsdto b=n.getSingleResult();
		System.out.println(b);
		return b;
	}
}
