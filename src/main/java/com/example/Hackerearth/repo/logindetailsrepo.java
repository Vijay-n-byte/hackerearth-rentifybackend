package com.example.Hackerearth.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Hackerearth.dto.logindetailsdto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class logindetailsrepo {

	@Autowired
	private EntityManager em;
	
	public logindetailsdto getcredentialsbyusername(String username) {
		TypedQuery<logindetailsdto> n=em.createQuery("select c.emailid,c.password,c.roles from credentials c where emailid=:star", logindetailsdto.class);
		n.setParameter("star", username);
		logindetailsdto b=n.getSingleResult();
		System.out.println(b);
		return b;
	}
}
