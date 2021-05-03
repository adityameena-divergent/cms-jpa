package com.divergentsl.cms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergentsl.cms.entity.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {


//	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "LOCAL_PERSISTENCE" );
	
	@PersistenceContext
	private EntityManager em;

	
	@Override
	public void add(Patient patient) {
		em.persist(patient);
	}


	@Override
	public Patient searchById(int patientId) {
		return em.find(Patient.class, patientId);
	}


	@Override
	public List<Patient> listAll() {
		CriteriaQuery<Patient> criteriaQuery = em.getCriteriaBuilder().createQuery(Patient.class);
		@SuppressWarnings("unused")
		Root<Patient> root = criteriaQuery.from(Patient.class);
		return em.createQuery(criteriaQuery).getResultList();
	}


	@Override
	public void delete(Patient patient) {
		em.remove(patient);
	}


	@Override
	public void update(Patient patient) {
		em.persist(patient);
	}

}
