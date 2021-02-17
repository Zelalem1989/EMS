package com.cognixia.advancedjava.ems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DepartmentList {
	private Set<Department> listOfDepartments;
	private Scanner scan;
	public DepartmentList() {
		listOfDepartments = new HashSet<Department>();
		scan = new Scanner(System.in);
	}
	
	public void UpdateDepartmentInfo(String departmentName) {
		if(listOfDepartments.isEmpty()) {
			System.out.println("There are no departments in this busness!");
		}
		else {
			for(Department d: listOfDepartments) {
				if(d.getDepartmentName().equals(departmentName)) {
					
					System.out.println("What would you like to update department: " + departmentName);
					System.out.println("1. Name\n2. Budget size\n3.Department Phone Number");
					
					int userChoice = scan.nextInt();
					
					if(userChoice == 1) {
						scan.nextLine();
						System.out.print("Please enter new name for the department: ");
						String newName = scan.nextLine();
						d.setDepartmentName(newName);
						System.out.println("You have successfuily update the departments information!");
						System.out.println(d.ListDepartment());
						return;
					}
					else if(userChoice == 2) {
						scan.nextLine();
						System.out.print("Please allocate a new budget for this department: ");
						int newBudget = scan.nextInt();
						d.setDepartmentBudget(newBudget);
						System.out.println("You have successfuily update this departments information!");
						System.out.println(d.ListDepartment());
						return;
					}
					else if(userChoice == 3) {
						scan.nextLine();
						System.out.print("Please enter new phone number for this department: ");
						int newPhoneNum= scan.nextInt();
						d.setDepartmentPhoneNumber(newPhoneNum);
						System.out.println("You have successfuily update the departments information!");
						System.out.println(d.ListDepartment());
						return;
					}
					
				}
			}
			System.out.println("This depaartment doesn't exist");
		}
		
	}
	public void ListDepartmentName() {
		if(listOfDepartments.isEmpty()) {
			System.out.println("There are no departments in this business!");
		}
		else {
			System.out.println("1. Search for department by name\n2. List all current departments");
			int userChoice = scan.nextInt();
			if(userChoice == 1) {
				scan.nextLine();
				System.out.print("Please enter the name of the deparmtnet you'd like to search: ");
				String departmentName = scan.nextLine();
				for(Department d: listOfDepartments) {
					if(d.getDepartmentName().equals(departmentName)) {
						System.out.println(d.ListDepartment());
						return;
					}
				}
				System.out.println("This department doesn't exist");
			}
			else if(userChoice == 2){
				listOfDepartments.stream().forEach(System.out::println);
			}	
		}
	}
	public void RemoveDepartment(String departmentName) {
		if(listOfDepartments.isEmpty()) {
			System.out.println("There are no departments in this busness!");
		}
		else {
			for(Department d: listOfDepartments) {
				if(d.getDepartmentName().equals(departmentName)) {
					System.out.println(d.getDepartmentName() + " has been removed");
					listOfDepartments.remove(d);
					return;
				}
			}
			System.out.println("This department doesn't exist");
		}
	}
	public void addDepartment (Department department) throws BudgetTooLargeException{
		double budget = department.getDepartmentBudget();
		if(budget > 750000)
		{
			throw new BudgetTooLargeException("The budget of " + budget + " will need to be approved by the CFO\n"
					+ "\nThe max 'unapproved' budget per deparmtent allowed is $750,000\n"
					+ "\nYou are " + (budget - 750000.0) + " over the limit");
		}
		else {
			listOfDepartments.add(department);
		}
		
	}
	public Department getDepartment(String departmentName) {
		if(listOfDepartments.isEmpty()) {
			System.out.println("There are no departments in this business!");
		}
		else {
				for(Department d: listOfDepartments) {
					if(d.getDepartmentName().equals(departmentName)) {
						return d;
					}
				}
			}
		
		return null;
	}

	@Override
	public String toString() {
		return "DeparmentList [listOfDepartments=" + listOfDepartments + "]";
	}
	
	
}
