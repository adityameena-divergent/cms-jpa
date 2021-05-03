package com.divergentsl.cms.dao;

import java.util.List;

import com.divergentsl.cms.entity.Appointment;

public interface AppointmentDao {

	public void save(Appointment appointment);
	
	public List<Appointment> get();
	
}
