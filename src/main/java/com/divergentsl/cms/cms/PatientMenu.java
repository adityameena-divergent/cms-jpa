package com.divergentsl.cms.cms;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.entity.Patient;
import com.divergentsl.cms.service.PatientService;
import com.divergentsl.cms.service.PatientServiceImpl;

@Component
public class PatientMenu {
	
	private static Logger logger = LoggerFactory.getLogger(PatientMenu.class);
	
	@Autowired
	private PatientService patientService;
	
	public void patientMenu() {
		A:
		while(true) {
			printPatientOption();
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			switch (input) {
			case "1":
				this.add();
				break;
				
			case "2":
				this.search();
				break;

			case "3":
				this.listAll();
				break;
				
			case "4":
				this.delete();
				break;
				
			case "5":
				this.update();
				break;
				
			case "6":
				break A;
				
			default:
				logger.info("Invalid Input!");
				break;
			}
		}
		
	}
	
	
	public void add() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEnter Patient Id : ");
		int patientId = Integer.parseInt(sc.nextLine());
		
		System.out.print("\nEnter Patient Name : ");
		String name = sc.nextLine();
		
		System.out.print("\nEnter Patient Age : ");
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.print("\nEnter Patient Weight : ");
		int weight = Integer.parseInt(sc.nextLine());
		
		System.out.print("\nEnter Patient Gender : ");
		String gender = sc.nextLine();
		
		System.out.print("\nEnter Patient Contact Number : ");
		int contactNumber = Integer.parseInt(sc.nextLine());
		
		System.out.print("\nEnter Patient Addrress : ");
		String address = sc.nextLine();
		
		patientService.add(patientId, name, age, weight, gender, contactNumber, address);
	}
	
	
	public void search() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Patient Id : ");
		int patientId = Integer.parseInt(sc.nextLine());
		
		Patient patient = patientService.searchById(patientId);
		
		if(patient != null) {
			System.out.println("\n--------------------Patient Data--------------------");
			System.out.println("Patient Id : " + patient.getId());
			System.out.println("Name : " + patient.getName());
			System.out.println("Gender : " + patient.getGender());
			System.out.println("Age : " + patient.getAge());
			System.out.println("Weight : " + patient.getWeight());
			System.out.println("Contact Number : " + patient.getContactNumber());
			System.out.println("Address : " + patient.getAddress());
			System.out.println("----------------------------------------------------");
		} else {
			logger.info("Patient Data Not Found!");
		}	
	}
	
	
	public void listAll() {
		
		List<Patient> list = this.patientService.listAll();
		
		System.out.println("\n--------------------Patient List-----------------------------------");
		System.out.printf("%2s | %12s | %6s | %3s | %6s | %14s | %10s |\n", "Id", "Patient Name", "Gender", "Age", "Weight", "Contact Number", "Address");
		System.out.println("\n-------------------------------------------------------------------------");
		for(Patient patient: list) {	
			System.out.printf("%2d | %12s | %6s | %3d | %6d | %14d | %10s |\n",patient.getId(), patient.getName(), patient.getGender(), patient.getAge(), patient.getWeight(), patient.getContactNumber(), patient.getAddress());
		}
		System.out.println("-------------------------------------------------------------------------");
	}
	
	public void delete() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Patient Id : ");
		int patientId = Integer.parseInt(sc.nextLine());
		
		if(this.patientService.delete(patientId)) {
			logger.info("Patient Deleted Successfully...");
		} else {
			logger.info("Patient Not Found!");
		}
	}
	
	
	public void update() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n---------------Update Patient Data---------------");
		System.out.print("\nEnter Patient Id : ");
		int patientId = Integer.parseInt(sc.nextLine());
		Patient patient = this.patientService.searchById(patientId);
		
		if (patient != null) {
			
			System.out.println("\n---------------Previous Patient Data---------------");
			System.out.println("Patient Id : " + patient.getId());
			System.out.println("Name : " + patient.getName());
			System.out.println("Gender : " + patient.getGender());
			System.out.println("Age : " + patient.getAge());
			System.out.println("Weight : " + patient.getWeight());
			System.out.println("Contact Number : " + patient.getContactNumber());
			
			System.out.print("\nEnter New Name : ");
			patient.setName(sc.nextLine());
			System.out.print("\nEnter New Gender : ");
			patient.setGender(sc.nextLine());
			System.out.print("\nEnter New Age : ");
			patient.setAge(Integer.parseInt(sc.nextLine()));
			System.out.print("\nEnter New Weight : ");
			patient.setWeight(Integer.parseInt(sc.nextLine()));
			System.out.print("\nEnter New Contact Number : ");
			patient.setContactNumber(Integer.parseInt(sc.nextLine()));
			System.out.print("\nEnter New Address : ");
			patient.setAddress(sc.nextLine());
			
			this.patientService.update(patient);
			
		}
		
	}
	
	
	private void printPatientOption() {
		System.out.println("\n--------------------Patient Menu--------------------");
		System.out.println("1. Add Patient");
		System.out.println("2. Search Patient");
		System.out.println("3. List All Patient");
		System.out.println("4. Delete Patient");
		System.out.println("5. Update Patient");
		System.out.println("6. Exit");
	}
	
}
