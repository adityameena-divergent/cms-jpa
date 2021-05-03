package com.divergentsl.cms.dao;

import java.util.List;

import com.divergentsl.cms.entity.Patient;

public interface PatientDao {

	public void add(Patient patient);
	
	public Patient searchById(int patientId);
	
	public List<Patient> listAll();
	
	public void delete(Patient patient);
	
	public void update(Patient patient);
}
