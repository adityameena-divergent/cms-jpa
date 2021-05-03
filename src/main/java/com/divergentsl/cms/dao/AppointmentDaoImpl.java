package com.divergentsl.cms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.divergentsl.cms.entity.Appointment;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Appointment appointment) {
		em.persist(appointment);
	}
	
}
