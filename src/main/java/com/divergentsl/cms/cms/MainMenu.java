package com.divergentsl.cms.cms;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class MainMenu {

	
	public void mainMenu() {
		
		while(true) {
			
			System.out.println("1. Admin Login");
			System.out.println("2. Doctor Login");
			System.out.println("3. Exit");
			
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			switch (input) {
			case "1":
				break;

				
			default:
				break;
			}
		}
	}
	
}
