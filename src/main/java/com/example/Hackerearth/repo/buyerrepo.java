package com.example.Hackerearth.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Hackerearth.dto.logindetailsdto;
import com.example.Hackerearth.entities.credentials;
import com.example.Hackerearth.entities.properties;
import com.example.Hackerearth.entities.useraccounts;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
@Component
public class buyerrepo {
	
	@Autowired
	private EntityManager em;
	
	public Long getcount() {
		Query n1=em.createQuery("select count(e) from properties e", properties.class);
		return  (Long) n1.getSingleResult();
    }
	
	public Long getcountarea(String area) {
		Query n1=em.createQuery("select count(e) from properties e where e.area=:star", properties.class);
		n1.setParameter("star", area);
		return (Long) n1.getSingleResult();
    }
	
	public Long getcountplace(String place) {
		Query n1=em.createQuery("select count(e) from properties e where e.place=:star", properties.class);
		n1.setParameter("star", place);
		return (Long) n1.getSingleResult();
    }

	//pagination=true,sort=none
	public List<properties> getallproperties(int pageno,int pagesize) {
		int skip=(pageno-1)*pagesize;
		if(pageno==1) {
			skip=0;
		}
		TypedQuery<properties> n1=em.createQuery("select e from properties e", properties.class);
		n1.setFirstResult(skip);
		n1.setMaxResults(pagesize);
		List<properties> b1=n1.getResultList();
		return b1;
    }
	//pagination=true,filter=place
	public List<properties> getallpropertiesfilterbyplace(int pageno,int pagesize,String place) {
		int skip=(pageno-1)*pagesize;
		if(pageno==1) {
			skip=0;
		}
		TypedQuery<properties> n1=em.createQuery("select e from properties e where e.place=:star", properties.class);
		n1.setParameter("star",place);
		n1.setFirstResult(skip);
		n1.setMaxResults(pagesize);
		List<properties> b1=n1.getResultList();
		return b1;
    }
	//pagination=true,filter=area
	public List<properties> getallpropertiesfilterbyarea(int pageno,int pagesize,String area) {
		int skip=(pageno-1)*pagesize;
		if(pageno==1) {
			skip=0;
		}
		TypedQuery<properties> n1=em.createQuery("select e from properties e where e.area=:star", properties.class);
		n1.setParameter("star",area);
		n1.setFirstResult(skip);
		n1.setMaxResults(pagesize);
		List<properties> b1=n1.getResultList();
		return b1;
	}
	//pagination=true,filter=area,place
		public List<properties> getallpropertiesfilterbyplacearea(int pageno,int pagesize,String place,String area) {
			int skip=(pageno-1)*pagesize;
			if(pageno==1) {
				skip=0;
			}
			Query n1=em.createQuery("select e from properties e where e.place=:star and e.area=:star1")
					.setParameter("star", place).setParameter("star1", area);
			n1.setFirstResult(skip);
			n1.setMaxResults(pagesize);
			List<properties> b1=n1.getResultList();
			return b1;
		}
}
