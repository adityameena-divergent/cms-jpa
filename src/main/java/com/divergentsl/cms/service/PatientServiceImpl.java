package com.divergentsl.cms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.cms.dao.PatientDao;
import com.divergentsl.cms.dao.PatientDaoImpl;
import com.divergentsl.cms.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao; // = new PatientDaoImpl();
	
	@Transactional
	@Override
	public void add(int patientId, String name, int age, int weight, String gender, int contactNumber, String address) {	
		
		Patient patient = new Patient();
		
		patient.setId(patientId);
		patient.setName(name);
		patient.setAge(age);
		patient.setWeight(weight);
		patient.setGender(gender);
		patient.setContactNumber(contactNumber);
		patient.setAddress(address);
		
		patientDao.add(patient);
		
	}

	@Transactional
	@Override
	public Patient searchById(int patientId) {
		return patientDao.searchById(patientId);
	}

	@Transactional
	@Override
	public List<Patient> listAll() {
		return this.patientDao.listAll();
	}

	@Transactional
	@Override
	public boolean delete(int patientId) {
		Patient patient = this.searchById(patientId);
		if (patient != null) {
			this.patientDao.delete(patient);
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public void update(Patient patient) {
		this.patientDao.update(patient);
	}

}
