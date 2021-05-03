package com.divergentsl.cms.cms;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.entity.LabTest;
import com.divergentsl.cms.service.LabTestService;

@Component
public class LabTestMenu {

	@Autowired
	private LabTestService labTestService;
	
	
	public void labTestMenu() {
		
		A:
		while(true) {
			
			this.printLabTestOption();
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			switch (input) {
			case "1":
				break;
				
			case "6":
				break A;

			default:
				break;
			}
			
			
		}
		
	}
	
	private void printLabTestOption() {
		System.out.println("\n--------------------LabTest Menu--------------------");
		System.out.println("1. Add New Test");
		System.out.println("2. Search Test Data");
		System.out.println("3. List All Test");
		System.out.println("4. Delete Test Data");
		System.out.println("5. Update Test Data");
		System.out.println("6. Exit");
	}
	
	
	public void add() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n--------------------Add Test--------------------");
		
		System.out.print("Enter Test Id : ");
		int labTestId = Integer.parseInt(sc.nextLine());
		
		System.out.print("\nEnter Test Name : ");
		String testName = sc.nextLine();
		
		System.out.print("\nEnter Test Fee : ");
		int testFee = Integer.parseInt(sc.nextLine());
		
		this.labTestService.add(labTestId, testName, testFee);
	}
	
	
	public void search() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n--------------------Search Test Data--------------------");
		System.out.print("Enter Test Id : ");
		int testId = Integer.parseInt(sc.nextLine());
		
		LabTest test = this.labTestService.search(testId);
		
		if (test != null) {
			System.out.println("\n----------------------------------------");
			System.out.println("Test Id : " + test.getTestId());
			System.out.println("Test Name : " + test.getTestName());
			System.out.println("Test Fee : " + test.getTestFee());
			System.out.println("----------------------------------------");
		} else {
			System.out.println("Test Data Not Found!");
		}
	}
	
	
	public void listAll() {
		
		List<LabTest> list = this.labTestService.listAll();
		
		System.out.println("\n--------------------Test List--------------------");
		if (list.size() > 0) {
			System.out.println("------------------------------");
			System.out.printf("| %3s | %12s | %8s |\n", "Id", "Test Name", "Test Fee");
			System.out.print("------------------------------");
			
			for(LabTest test : list) {
				System.out.printf("\n| %3d | %12s | %8d |", test.getTestId(), test.getTestName(), test.getTestFee());
			}
			System.out.println("\n------------------------------");
		} else {
			System.out.println("Test not found!");
		}
	}
	
	
	public void delete() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n--------------------Delete Test--------------------");
		System.out.print("Enter Test Id : ");
		int testId = Integer.parseInt(sc.nextLine());
		
		if (this.labTestService.delete(testId)) {
			System.out.println("Data Deleted Successfully...");
		} else {
			System.out.println("Data not found!");
		}
	}
	
	public void update() {
		
	}
	
	
}
