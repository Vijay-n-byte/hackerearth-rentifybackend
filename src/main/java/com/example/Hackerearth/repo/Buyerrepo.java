package com.example.Hackerearth.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Hackerearth.dto.Logindetailsdto;
import com.example.Hackerearth.entities.Credentials;
import com.example.Hackerearth.entities.Properties;
import com.example.Hackerearth.entities.Useraccounts;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
@Component
public class Buyerrepo {
	
	@Autowired
	private EntityManager em;
	
	public Long getcount() {
		Query n1=em.createQuery("select count(e) from Properties e", Properties.class);
		return  (Long) n1.getSingleResult();
    }
	
	public Long getcountarea(String area) {
		Query n1=em.createQuery("select count(e) from Properties e where e.area=:star", Properties.class);
		n1.setParameter("star", area);
		return (Long) n1.getSingleResult();
    }
	
	public Long getcountplace(String place) {
		Query n1=em.createQuery("select count(e) from Properties e where e.place=:star", Properties.class);
		n1.setParameter("star", place);
		return (Long) n1.getSingleResult();
    }

	//pagination=true,sort=none
	public List<Properties> getallproperties(int pageno,int pagesize) {
		int skip=(pageno-1)*pagesize;
		if(pageno==1) {
			skip=0;
		}
		TypedQuery<Properties> n1=em.createQuery("select e from Properties e", Properties.class);
		n1.setFirstResult(skip);
		n1.setMaxResults(pagesize);
		List<Properties> b1=n1.getResultList();
		return b1;
    }
	//pagination=true,filter=place
	public List<Properties> getallpropertiesfilterbyplace(int pageno,int pagesize,String place) {
		int skip=(pageno-1)*pagesize;
		if(pageno==1) {
			skip=0;
		}
		TypedQuery<Properties> n1=em.createQuery("select e from Properties e where e.place=:star", Properties.class);
		n1.setParameter("star",place);
		n1.setFirstResult(skip);
		n1.setMaxResults(pagesize);
		List<Properties> b1=n1.getResultList();
		return b1;
    }
	//pagination=true,filter=area
	public List<Properties> getallpropertiesfilterbyarea(int pageno,int pagesize,String area) {
		int skip=(pageno-1)*pagesize;
		if(pageno==1) {
			skip=0;
		}
		TypedQuery<Properties> n1=em.createQuery("select e from Properties e where e.area=:star", Properties.class);
		n1.setParameter("star",area);
		n1.setFirstResult(skip);
		n1.setMaxResults(pagesize);
		List<Properties> b1=n1.getResultList();
		return b1;
	}
	//pagination=true,filter=area,place
		public List<Properties> getallpropertiesfilterbyplacearea(int pageno,int pagesize,String place,String area) {
			int skip=(pageno-1)*pagesize;
			if(pageno==1) {
				skip=0;
			}
			Query n1=em.createQuery("select e from Properties e where e.place=:star and e.area=:star1")
					.setParameter("star", place).setParameter("star1", area);
			n1.setFirstResult(skip);
			n1.setMaxResults(pagesize);
			List<Properties> b1=n1.getResultList();
			return b1;
		}
}
