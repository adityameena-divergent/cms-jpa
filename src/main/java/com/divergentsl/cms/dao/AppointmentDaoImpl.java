package com.divergentsl.cms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergentsl.cms.entity.Appointment;
import com.divergentsl.cms.entity.Drug;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Appointment appointment) {
		em.persist(appointment);
	}

	@Override
	public List<Appointment> get() {
		CriteriaQuery<Appointment> criteriaQuery = em.getCriteriaBuilder().createQuery(Appointment.class);
		@SuppressWarnings("unused")
		Root<Appointment> root = criteriaQuery.from(Appointment.class);
		return em.createQuery(criteriaQuery).getResultList();
	}
	
}
