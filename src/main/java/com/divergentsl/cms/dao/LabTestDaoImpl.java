package com.divergentsl.cms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergentsl.cms.entity.LabTest;

@Repository
public class LabTestDaoImpl implements LabTestDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(LabTest labTest) {
		em.persist(labTest);
	}

	@Override
	public LabTest searchById(int patientId) {
		return em.find(LabTest.class, patientId);
	}


	@Override
	public List<LabTest> listAll() {
		CriteriaQuery<LabTest> criteriaQuery = em.getCriteriaBuilder().createQuery(LabTest.class);
		@SuppressWarnings("unused")
		Root<LabTest> root = criteriaQuery.from(LabTest.class);
		return em.createQuery(criteriaQuery).getResultList();
	}


	@Override
	public void delete(LabTest labTest) {
		em.remove(labTest);
	}


	@Override
	public void update(LabTest labTest) {
		em.persist(labTest);
	}

	
}
