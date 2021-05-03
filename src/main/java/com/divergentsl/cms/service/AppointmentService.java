package com.divergentsl.cms.service;

public interface AppointmentService {

	public void makeAppointment(int appointmentId, String problem, int patientId, int doctorId);
	
}
