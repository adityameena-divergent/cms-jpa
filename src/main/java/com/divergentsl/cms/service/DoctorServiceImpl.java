package com.divergentsl.cms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.cms.dao.DoctorDao;
import com.divergentsl.cms.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	
	@Transactional
	@Override
	public void add(int doctorId, String name, int fee, String specialization, String username, String password) {

		Doctor doctor = new Doctor();
		
		doctor.setId(doctorId);
		doctor.setName(name);
		doctor.setFee(fee);
		doctor.setSpecialization(specialization);
		doctor.setUsername(username);
		doctor.setPassword(password);
		this.doctorDao.add(doctor);
	}

	@Transactional
	@Override
	public Doctor search(int doctorId) {
		return this.doctorDao.searchById(doctorId);
	}

	@Transactional
	@Override
	public List<Doctor> listAll() {		
		return this.doctorDao.listAll();
	}

	@Transactional
	@Override
	public boolean delete(int doctorId) {
		Doctor doctor = this.search(doctorId);
		if(doctor != null) {
			this.doctorDao.delete(doctor);
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public void update(Doctor doctor) {
		this.doctorDao.update(doctor);
	}
	
	@Transactional
	@Override
	public int doctorLogin(String username, String password) {
		
		List<Doctor> list = this.listAll();
		for(Doctor doctor : list) {
			if (doctor.getUsername().equals(username) && doctor.getPassword().equals(password))
				return doctor.getId();
		}
		return 0;
	}

}
