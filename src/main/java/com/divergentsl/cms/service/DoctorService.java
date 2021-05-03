package com.divergentsl.cms.service;

import java.util.List;

import com.divergentsl.cms.entity.Doctor;

public interface DoctorService {

	public void add(int doctorId, String name, int fee, String specialization, String username, String password);
	
	public Doctor search(int doctorId);
	
	public List<Doctor> listAll();
	
	public boolean delete(int doctorId);
	
	public void update(Doctor doctor);
	
}
