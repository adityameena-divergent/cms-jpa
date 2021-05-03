package com.divergentsl.cms.cms;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminMenu {
	
	@Autowired
	private PatientMenu patientMenu;// = new PatientMenu();
	
	@Autowired
	private DoctorMenu doctorMenu;
	
	@Autowired
	private DrugMenu drugMenu;
	
	@Autowired
	private LabTestMenu labTestMenu;
	
	@Autowired
	private CreateAppointment createAppointment;
	
	public void adminMenu() {
		P:
		while(true) {
			printAdminOption();
			
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			switch (input) {
			case "1":
				patientMenu.patientMenu();
				break;
			
			case "2":
				doctorMenu.doctorMenu();
				break;
				
			case "3":
				drugMenu.drugMenu();
				break;
				
			case "4":
				labTestMenu.labTestMenu();
				break;
				
			case "5":
				createAppointment.createAppointment();
				break;
				
			case "6":
				break P;

			default:
				System.out.println("Invalid Input!");
				break;
			}
		}
	}
	
	private void printAdminOption() {
		System.out.println("\n1. Patient");
		System.out.println("2. Doctor");
		System.out.println("3. Drug");
		System.out.println("4. Lab Test");
		System.out.println("5. Make Appointment");
		System.out.println("6. Exit");
	}
	
}
