package com.divergentsl.cms.service;

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

	
	
}
