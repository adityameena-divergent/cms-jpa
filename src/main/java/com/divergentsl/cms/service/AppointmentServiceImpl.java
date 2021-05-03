package com.divergentsl.cms.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.cms.dao.AppointmentDao;
import com.divergentsl.cms.entity.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Transactional
	@Override
	public void makeAppointment(int appointmentId, String problem, int patientId, int doctorId) {
		
		Appointment appointment = new Appointment();
		
		appointment.setId(appointmentId);
		appointment.setProblem(problem);
		appointment.setDoctor(doctorService.search(doctorId));
		appointment.setPatient(patientService.searchById(patientId));
		
		appointmentDao.save(appointment);
	}

	@Override
	public List<Appointment> getList() {
		return appointmentDao.get();
	}

	@Override
	public List<Appointment> getAppointedPatientList(int doctorId) {
		
		return this.getList().stream().filter(pa -> {
			return pa.getDoctor().getId() == doctorId;
		}).collect(Collectors.toList());

	}

	@Override
	public List<Appointment> getPatientHistory(int patientId) {

		return this.getList().stream().filter(pa -> {
			return pa.getPatient().getId() == patientId;
		}).collect(Collectors.toList());
	}

	
	
}
