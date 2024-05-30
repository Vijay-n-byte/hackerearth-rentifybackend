package com.example.Hackerearth.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Hackerearth.dto.newusersdto;
import com.example.Hackerearth.enums.roles;
import com.example.Hackerearth.repo.usersrepo;
import com.example.Hackerearth.entities.credentials;
import com.example.Hackerearth.entities.useraccounts;
@Service
public class useraccountservice {
	
	@Autowired
	private usersrepo ur;
	@Autowired
	private PasswordEncoder pe;
	public int addnewusersservicemethod(newusersdto n) {
		if(ur.getsingleuser(n.getEmailid())!=null) {
			return 0;
		}
		else {
			useraccounts u=new useraccounts();
			u.setFirstname(n.getFirstname());
			u.setLastname(n.getLastname());
			u.setPhonenumber(n.getPhonenumber());
			UUID u1=UUID.randomUUID();
			u.setAccountid(u1.toString());
			credentials c=new credentials();
			c.setEmailid(n.getEmailid());
			c.setPassword(pe.encode(n.getPassword()));
			roles f;
			if(n.getRoles()==0) {
				f=roles.ROLE_SELLER;
			}
			else {
				f=roles.ROLE_BUYER;
			}
			c.setRoles(f.toString());
			c.setAccount(u);
			return ur.addnewusersrepomethod(u,c);
		}
		
	}
}
