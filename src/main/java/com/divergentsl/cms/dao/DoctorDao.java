package com.divergentsl.cms.dao;

import java.util.List;

import com.divergentsl.cms.entity.Doctor;

public interface DoctorDao {

	public void add(Doctor doctor);
	
	public Doctor searchById(int doctorId);
	
	public List<Doctor> listAll();
	
	public void delete(Doctor doctor);
	
	public void update(Doctor doctor);
	
}
