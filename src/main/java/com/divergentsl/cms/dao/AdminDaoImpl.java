package com.divergentsl.cms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.divergentsl.cms.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Admin find(String username) {
		return em.find(Admin.class, username);
	}

}
