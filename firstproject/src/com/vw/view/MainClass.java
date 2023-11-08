package com.vw.view;

import java.util.Scanner;
import java.util.function.Supplier;

import com.vw.controller.EmployeeController;
import com.vw.controller.EmployeeInterface;


//View -- Enduser

public class MainClass {

	public static void main(String[] args) {

		System.out.println("Welcome to EMS");

		Supplier<EmployeeController> ecSupplier = EmployeeController::new;

		EmployeeInterface ec = ecSupplier.get();
		Scanner scn = new Scanner(System.in);
		String choice = null;
		do {
			System.out.println("Enter your choice");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Sort Employee");
			System.out.println("4. Serialize Employee");
			System.out.println("5. DeSerialize Employee");
			System.out.println("6. Update Employee");
			System.out.println("7. Delete Employee");
			System.out.println("8. Insert Employee using Procedure");
			System.out.println("9. Get Employee table metadata");
			
			int ch = scn.nextInt();

			switch (ch) {
			case 1: {
				ec.addEmployee();
				break;
			}
			case 2: {
				ec.viewEmployee();
				break;
			}
			
			case 3: {
				ec.sortEmpByName();
				break;
			}
			case 4: {
				ec.serializeEmp();
				break;
			}
			case 5: {
				ec.deserializeEmp();
				break;
			}
			
			case 6: {
				ec.updateEmployee();
				break;
			}
			case 7: {
				ec.deleteEmployee();
				break;
			}

			case 8: {
				ec.insertEmployeeUsingProcedure();
				break;
			}
			
			case 9: {
				ec.getEmpMetaData();
				break;
			}
			case 10: {
				ec.readDbUsingMutliThreads();
				break;
			}

			default: {
				System.out.println("Enter a proper case");
				break;
				
			}
			}

			System.out.println("Do you want to continue y | n");
			choice = scn.next();
		} while (choice.equals("y") | choice.equals("Y"));
		System.out.println("Thanks for ur presence");
		System.exit(0);
		
	}

}
