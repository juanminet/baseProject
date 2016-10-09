package com.base.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.base.project.model.Base;

@Repository("baseDao")
public class BaseDaoImpl implements IBaseDao {
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
 	protected EntityManager em;

	public void setBase(Base base) {
		if (base.getId() == null){
			em.persist(base);
		}else{
			em.merge(base);
		}
	}

	public Base getBaseById(Long id) {
		return em.find(Base.class, id);
	}

	public void deleteBase(Base base) {
		em.remove(base);
	}

	public void deleteBase(Long id) {
		em.remove(getBaseById(id));
	}

	public List<Base> getAllBases() {
		Query query = em.createNamedQuery("findAllBases");
		
		List<Base> resListBase = query.getResultList();
		
		return resListBase;
	}

}
