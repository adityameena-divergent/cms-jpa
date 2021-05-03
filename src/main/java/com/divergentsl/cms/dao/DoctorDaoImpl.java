package com.divergentsl.cms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergentsl.cms.entity.Doctor;
import com.divergentsl.cms.entity.Patient;

@Repository
public class DoctorDaoImpl implements DoctorDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(Doctor doctor) {
		em.persist(doctor);
	}

	@Override
	public Doctor searchById(int doctorId) {
		return em.find(Doctor.class, doctorId);
	}


	@Override
	public List<Doctor> listAll() {
		CriteriaQuery<Doctor> criteriaQuery = em.getCriteriaBuilder().createQuery(Doctor.class);
		@SuppressWarnings("unused")
		Root<Doctor> root = criteriaQuery.from(Doctor.class);
		return em.createQuery(criteriaQuery).getResultList();
	}


	@Override
	public void delete(Doctor doctor) {
		em.remove(doctor);
	}


	@Override
	public void update(Doctor doctor) {
		em.persist(doctor);
	}

	
}
