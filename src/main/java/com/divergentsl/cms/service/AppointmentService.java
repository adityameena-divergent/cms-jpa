package com.divergentsl.cms.service;

import java.util.List;

import com.divergentsl.cms.entity.Appointment;

public interface AppointmentService {

	public void makeAppointment(int appointmentId, String problem, int patientId, int doctorId);
	
	public List<Appointment> getList();
	
	public List<Appointment> getAppointedPatientList(int doctorId); 
	
	public List<Appointment> getPatientHistory(int patientId); 
	
}
