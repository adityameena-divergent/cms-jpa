package com.divergentsl.cms.cms;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.entity.Drug;
import com.divergentsl.cms.service.DrugService;

@Component
public class DrugMenu {

	@Autowired
	private DrugService drugService;
	
	private static Logger logger = LoggerFactory.getLogger(DrugMenu.class);

	
	public void drugMenu() {
	
		D:
		while(true) {
			this.printDrugOption();
			
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

			case "6":
				break D;
				
			default:
				break;
			}
		}
	}
	
	private void printDrugOption() {
		System.out.println("\n--------------------Drug Menu--------------------");
		System.out.println("1. Add New Drug");
		System.out.println("2. Search Drug");
		System.out.println("3. List All Drug");
		System.out.println("4. Delete Drug");
		System.out.println("5. Update Drug");
		System.out.println("6. Exit");
	}
	
	
	public void add() {
		System.out.println("\n--------------------Add New Drug--------------------");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Drug Id : ");
		int drugId = Integer.parseInt(sc.nextLine());
		
		System.out.print("\nEnter Drug Name : ");
		String drugName = sc.nextLine();
		
		System.out.print("\nEnter Drug Description : ");
		String drugDescription = sc.nextLine();
		
		this.drugService.add(drugId, drugName, drugDescription);
	}
	
	
	public void search() {
		System.out.println("\n--------------------Search Drug--------------------");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Drug Id : ");
		int drugId = Integer.parseInt(sc.nextLine());
		
		Drug drug = this.drugService.search(drugId);
		
		if (drug != null) {
			System.out.println("\n--------------------------------------------------");
			System.out.println("Drug Id : " + drug.getId());
			System.out.println("Drug Name : " + drug.getName());
			System.out.println("Drug Description : " + drug.getDescription());
			System.out.println("--------------------------------------------------");
		} else {
			System.out.println("\nDrug not found!");
		}
	}
	
	
	public void listAll() {
		
		System.out.println("--------------------Drug List--------------------");
		
		List<Drug> list = this.drugService.listAll();
		
		if (list.size() > 0) {
			System.out.println("--------------------------------------------------------------------");
			System.out.printf("| %3s | %12s | %30s |", "Id", "Name", "Description");
			
			for(Drug drug : list) {
				System.out.printf("\n| %3d | %12s | %30s |", drug.getId(), drug.getName(), drug.getDescription());
			}
			System.out.println("\n--------------------------------------------------------------------");
		} else {
			System.out.println("Drug not found!");
		}
	}
	
	
	public void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n--------------------Delete Drug--------------------");
		System.out.print("Enter Drug Id : ");
		int drugId = Integer.parseInt(sc.nextLine());
		
		if (this.drugService.delete(drugId)) {
			System.out.println("\nDrug data deleted successfully...");
		} else {
			System.out.println("\nDrug Not Found!");
		}
		
	}
	
}