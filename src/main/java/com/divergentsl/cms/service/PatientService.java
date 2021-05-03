package com.divergentsl.cms.service;

import java.util.List;

import com.divergentsl.cms.entity.Patient;

public interface PatientService {

	public void add(int patientId, String name, int age, int weight, String gender, int contactNumber, String address);
	
	public Patient searchById(int patientId);
	
	public List<Patient> listAll();
	
	public boolean delete(int patientId);
	
	public void update(Patient patient);
	
}
