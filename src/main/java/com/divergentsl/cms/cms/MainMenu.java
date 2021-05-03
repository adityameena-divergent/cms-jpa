package com.divergentsl.cms.cms;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static Logger logger = LoggerFactory.getLogger(MainMenu.class);

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
				logger.info("Invalid Input!");
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
			logger.info("Incorrect Username & Password!");
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
			logger.info("Incorrect Username & Password");
		}
		
	}
	
}
