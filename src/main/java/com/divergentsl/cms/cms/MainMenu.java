package com.divergentsl.cms.cms;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.service.AdminService;
import com.divergentsl.cms.service.DoctorService;

@Component
public class MainMenu {

	@Autowired
	private AdminMenu adminMenu;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DoctorMenu doctorMenu;
	

	public void mainMenu() {
		
		M:
		while(true) {
			System.out.println("--------------------Main Menu--------------------\n");
			System.out.println("1. Admin Login");
			System.out.println("2. Doctor Login");
			System.out.println("3. Exit");
			
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			switch (input) {
			case "1":
				this.adminLogin();
				break;

			case "2":
				this.doctorLogin();
				break;
				
			case "3":
				break M;
				
			default:
				System.out.println("\nInvalid Input!");
				break;
			}
		}
	}
	
	
	public void adminLogin() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n--------------------Admin Login--------------------");
		
		System.out.print("Enter Username : ");
		String username = sc.nextLine();
		
		System.out.print("\nEnter Password : ");
		String password = sc.nextLine();
		
		if (this.adminService.login(username, password)) {
			this.adminMenu.adminMenu();
		} else {
			System.out.println("Incorrect Username & Password!");
		}
	}
	
	
	public void doctorLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n--------------------Doctor Login--------------------");
		
		System.out.print("Enter Username : ");
		String username = sc.nextLine();
		
		System.out.print("\nEnter Password : ");
		String password = sc.nextLine();
		
		int doctorId = this.doctorService.doctorLogin(username, password);
		
		if(doctorId != 0) {
			this.doctorMenu.doctorMenu(doctorId);
		} else {
			System.out.println("\nInvalid Username & Password!");
		}
		
	}
	
}
