package com.divergentsl.cms.cms;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.entity.Appointment;
import com.divergentsl.cms.service.AppointmentService;

import lombok.Getter;
import lombok.Setter;

@Component
public class DoctorMenu {
	
	@Autowired
	private AppointmentService appointmentService;
	
	private int loggedDoctorId;
	
	public void doctorMenu(int loggedDoctorId) {
		this.loggedDoctorId = loggedDoctorId;
		D:
		while(true) {
			
			printDoctorOption();
			Scanner sc = new Scanner(System.in);
			
			String input = sc.nextLine();
			
			switch (input) {
			case "1":
				this.allPatientList();
				break;
				
			case "3":
				this.patientAppointToYou();
				break;
				
			case "4":
				this.checkPatientHistory();
				break;
				
			case "6":
				break D;

			default:
				break;
			}
		}
	}
	
	
	private void printDoctorOption() {
		System.out.println("\n--------------------Doctor Menu--------------------");
		System.out.println("1. List of patients appointment");
		System.out.println("2. Add prescription and notes for a patient");
		System.out.println("3. See booked appointments for him");
		System.out.println("4. Check patient history and his prescription");
		System.out.println("5. Create Invoice of patient");
		System.out.println("6. Logout");
	}
	
	
	
	public void allPatientList() {
		
		List<Appointment> list = appointmentService.getList();
		System.out.println("\n--------------------List of all Patient--------------------");
		
		if(list.size() > 0) {
			System.out.println("\n--------------------------------------------------");
			System.out.printf("| %2s | %12s | %9s | %10s |", "Id", "Problem", "Doctor Id", "Patient Id");
			System.out.print("\n--------------------------------------------------");
			for(Appointment appointment : list) {
				System.out.printf("\n| %2d | %12s | %9d | %10d |", appointment.getId(), appointment.getProblem(), appointment.getDoctor().getId(), appointment.getPatient().getId());
			}
			System.out.println("\n--------------------------------------------------");
		} else {
			System.out.println("Patient apointment not found!");
		}
	}
	
	
	public void patientAppointToYou() {
		
		List<Appointment> list = appointmentService.getAppointedPatientList(this.loggedDoctorId);
		System.out.println("\n--------------------List of all Patient Appoint To You--------------------");
		
		if(list.size() > 0) {
			System.out.println("\n----------------------------------------");
			System.out.printf("| %2s | %12s | %9s | %10s |", "Id", "Problem", "Doctor Id", "Patient Id");
			System.out.print("\n----------------------------------------");
			for(Appointment appointment : list) {
				System.out.printf("\n| %2d | %12s | %9d | %10d |", appointment.getId(), appointment.getProblem(), appointment.getDoctor().getId(), appointment.getPatient().getId());
			}
			System.out.println("\n----------------------------------------");
		} else {
			System.out.println("Patient apointment not found!");
		}
	}
	
	
	public void checkPatientHistory() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Patient Id : ");
		int patientId = Integer.parseInt(sc.nextLine());
		
		List<Appointment> list = appointmentService.getPatientHistory(patientId);
		System.out.println("\n--------------------Patient History--------------------");
		
		if(list.size() > 0) {
			System.out.println("\n--------------------------------------------------");
			System.out.printf("| %2s | %12s | %9s | %10s |", "Id", "Problem", "Doctor Id", "Patient Id");
			System.out.print("\n--------------------------------------------------");
			for(Appointment appointment : list) {
				System.out.printf("\n| %2d | %12s | %9d | %10d |", appointment.getId(), appointment.getProblem(), appointment.getDoctor().getId(), appointment.getPatient().getId());
			}
			System.out.println("\n--------------------------------------------------");
		} else {
			System.out.println("Patient not found!");
		}
	}
	
	
}
