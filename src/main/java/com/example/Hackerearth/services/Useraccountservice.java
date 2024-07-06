package com.example.Hackerearth.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Hackerearth.dto.Newusersdto;
import com.example.Hackerearth.enums.Roles;
import com.example.Hackerearth.repo.Usersrepo;
import com.example.Hackerearth.entities.Credentials;
import com.example.Hackerearth.entities.Useraccounts;
@Service
public class Useraccountservice {
	
	@Autowired
	private Usersrepo ur;
	@Autowired
	private PasswordEncoder pe;
	public int addnewusersservicemethod(Newusersdto n) {
		if(ur.getsingleuser(n.getEmailid())!=null) {
			return 0;
		}
		else {
			Useraccounts u=new Useraccounts();
			u.setFirstname(n.getFirstname());
			u.setLastname(n.getLastname());
			u.setPhonenumber(n.getPhonenumber());
			UUID u1=UUID.randomUUID();
			u.setAccountid(u1.toString());
			Credentials c=new Credentials();
			c.setEmailid(n.getEmailid());
			c.setPassword(pe.encode(n.getPassword()));
			Roles f;
			if(n.getRoles()==0) {
				f=Roles.ROLE_SELLER;
			}
			else {
				f=Roles.ROLE_BUYER;
			}
			c.setRoles(f.toString());
			c.setAccount(u);
			return ur.addnewusersrepomethod(u,c);
		}
		
	}
}
