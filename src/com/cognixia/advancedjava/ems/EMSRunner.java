
package com.cognixia.advancedjava.ems;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EMSRunner {

	public EMSRunner() {
	}
	
	public static void main(String[] args) {
		DepartmentList departmentList = new DepartmentList();
		System.out.println("Hello User, welcome to the Employee Managment System...");
		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("\nMAIN Page\n-------------------");
			System.out.println("What would you like to do");
			System.out.println("1.Access Departments");
			System.out.println("2.Access Employees");
			System.out.println("3.Save data");
			System.out.println("4.Exit program");
			
			int userChoice = scan.nextInt();
			if(userChoice == 1) {
				while(true){
					System.out.println("\nDEPARTMENTS\n------------------");
					System.out.println("1.Add a department");
					System.out.println("2.Remove a department");
					System.out.println("3.Update a department information");
					System.out.println("4.List a deparment or deparmtents");
					System.out.println("5.Return to main page");
					
					int userSecondChoice = scan.nextInt();
					if(userSecondChoice == 1) {
						scan.nextLine();
						System.out.print("Department Name: ");
						String depName = scan.nextLine();
						System.out.print("Department Budget(number only): ");
						long depBudget = scan.nextLong();
						System.out.print("Department Phone Number(number only): ");
						long depNumber = scan.nextLong();
						try {
							departmentList.addDepartment(new Department(depName, depBudget, depNumber));
						} catch (BudgetTooLargeException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		
					}
					else if(userSecondChoice == 2) {
						scan.nextLine();
						System.out.print("Department Name: ");
						String depName = scan.nextLine();
						departmentList.RemoveDepartment(depName);
					}
					else if(userSecondChoice == 3) {
						scan.nextLine();
						System.out.print("Department Name: ");
						String depName = scan.nextLine();
						departmentList.UpdateDepartmentInfo(depName);
					}
					else if(userSecondChoice == 4) {
						departmentList.ListDepartmentName();
					}
					else if(userSecondChoice == 5) {
						break;
					}
					else {
						System.out.println("Not a valid choice");
					}	
				}
			}
			else if(userChoice == 2) {
				Department department;
				scan.nextLine();
				System.out.print("Which departments employee's would you like to access: ");

				String depName = scan.nextLine();
				department = departmentList.getDepartment(depName);
				if(department == null) {
					System.out.println("This department doesnt exist");
					
				}
				else {
					while(true) {
						System.out.println("\nEMPLOYEE'S- department : "+ depName + "\n------------------");
						System.out.println("1.Add an employee");
						System.out.println("2.Remove an employee");
						System.out.println("3.Update an employee's information");
						System.out.println("4.List an employee or employee's");
						System.out.println("5.Return to main page");
	
						int userSecondChoice = scan.nextInt();
						if(userSecondChoice == 1) {
							scan.nextLine();
							
							System.out.print("Employee Name: ");
							String empName = scan.nextLine();
							System.out.print("Employee ID(number only): ");
							int empID = scan.nextInt();
							scan.nextLine();
							System.out.print("Employee's Job: ");
							String empJob = scan.nextLine();
							
							department.addEmployee(new Employee(empName, empID, empJob));
						}
						else if(userSecondChoice == 2) {
							scan.nextLine();
							System.out.print("Employee Name: ");
							String empName = scan.nextLine();
							department.RemoveEmployee(empName);
						}
						else if(userSecondChoice == 3) {
							department.UpdateEmployeeInfo();
						}
						else if(userSecondChoice == 4) {
							department.ListEmployeeName();
						}
						else if(userSecondChoice == 5) {
							break;
						}
						else {
							System.out.println("Not a valid choice");
						}
					}
				}
			}
			else if(userChoice == 3) {
				
				File file = new File("resources/EMSData.txt");
				if (!file.exists()) {
					try {
						file.createNewFile();
						System.out.println("File created");
					} catch (IOException e) {
						System.out.println("File not created");
					}
				}				
				
				try (FileWriter out = new FileWriter(file);
						BufferedWriter writer = new BufferedWriter(out);
						PrintWriter pw = new PrintWriter(writer)){
					pw.println(departmentList.toString());
					
					System.out.println("File Successfully written");
					
				} catch (IOException e) {

					System.out.println("File not written");
				}
				}
			else if(userChoice == 4) {
				System.out.println("Exiting program...");
				System.exit(0);
			}
			else {
				System.out.println(userChoice + " is not a valid choice");
			}	
		}
		
	}

}
