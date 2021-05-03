package com.divergentsl.cms.cms;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.entity.Doctor;
import com.divergentsl.cms.service.DoctorService;

@Component
public class CRUDDoctorMenu {

	@Autowired
	private DoctorService doctorService;

	public void doctorMenu() {
		D: while (true) {

			printDoctorOption();
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
				break D;

			default:
				System.out.println("Invalid Input!");
				break;
			}
		}
	}

	private void printDoctorOption() {
		System.out.println("\n--------------------Doctor Menu--------------------");
		System.out.println("1. Add Doctor");
		System.out.println("2. Search Doctor");
		System.out.println("3. List All Doctor");
		System.out.println("4. Delete Doctor");
		System.out.println("5. Update Doctor");
		System.out.println("6. Exit");
	}

	public void add() {
		Scanner sc = new Scanner(System.in);

		System.out.println("\n--------------------Add New Doctor--------------------");
		
		System.out.print("\nEnter Doctor Id : ");
		int doctorId = Integer.parseInt(sc.nextLine());

		System.out.print("\nEnter Doctor Name : ");
		String name = sc.nextLine();

		System.out.print("\nEnter Doctor Fee : ");
		int fee = Integer.parseInt(sc.nextLine());

		System.out.print("\nEnter Doctor Specialization : ");
		String specialization = sc.nextLine();

		System.out.print("\nEnter Doctor Username : ");
		String username = sc.nextLine();

		System.out.print("\nEnter Doctor Password : ");
		String password = sc.nextLine();

		this.doctorService.add(doctorId, name, fee, specialization, username, password);
	}
	

	public void search() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n--------------------Search Doctor--------------------");
		System.out.print("Enter Doctor Id : ");
		int doctorId = Integer.parseInt(sc.nextLine());

		Doctor doctor = this.doctorService.search(doctorId);

		if (doctor != null) {
			System.out.println("\n------------------Doctor Data------------------");
			System.out.println("\nDoctor Id : " + doctor.getId());
			System.out.println("Doctor Name : " + doctor.getName());
			System.out.println("Doctor Fee : " + doctor.getFee());
			System.out.println("Doctor Specialization : " + doctor.getSpecialization());
			System.out.println("Username : " + doctor.getUsername());
			System.out.println("Password : " + doctor.getPassword());
			System.out.println("----------------------------------------------------");
		} else {
			System.out.println("\nDoctor not found!");
		}
	}
	

	public void listAll() {

		List<Doctor> list = this.doctorService.listAll();

		if (list.size() > 0) {

			System.out.println("\n--------------------Doctor List--------------------");
			System.out.printf("%2s | %10s | %3s | %15s | %12s | %12s |\n", "Id", "Name", "Fee", "Specialization",
					"Username", "Password");
			System.out.print("----------------------------------------------------------------------");
			for (Doctor doctor : list) {
				System.out.printf("\n%2s | %10s | %3s | %15s | %12s | %12s |", doctor.getId(), doctor.getName(),
						doctor.getFee(), doctor.getSpecialization(), doctor.getUsername(), doctor.getPassword());
			}
			System.out.println("\n----------------------------------------------------------------------");

		} else {
			System.out.println("\nNo Doctor Data Found!");
		}
	}
	
	
	public void delete() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--------------------Delete Doctor--------------------");
		System.out.print("Enter Doctor Id : ");
		int doctorId = Integer.parseInt(sc.nextLine());
		if (this.doctorService.delete(doctorId)) {
			System.out.println("\nDelete Successfully...");
		} else {
			System.out.println("\nDoctor not found!");
		}
	}
	
	
	public void update() {
		System.out.println("operation not available!");
	}

}
