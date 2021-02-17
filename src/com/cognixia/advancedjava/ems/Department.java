package com.cognixia.advancedjava.ems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Department {
	private String departmentName;
	private double departmentBudget;
	private long departmentPhoneNumber;
	private Set<Employee> employeeRoster;	
	
	
	public Department(String departmentName, long departmentBudget, long departmentPhoneNumber) {
		super();
		this.departmentName = departmentName;
		this.departmentBudget = departmentBudget;
		this.departmentPhoneNumber = departmentPhoneNumber;
		employeeRoster = new HashSet<Employee>();
	}

	public void UpdateEmployeeInfo() {
		if(employeeRoster.isEmpty()) {
			System.out.println("There are no employees in this department!");
		}
		else {
			Scanner scan = new Scanner(System.in);
			System.out.print("Which employee's information would you like to update?\nEmployee name: ");
			String employeeName = scan.nextLine();
			for(Employee e: employeeRoster) {
				if(e.getEmployeeName().equals(employeeName)) {
					
					System.out.println("What would you like to update about Employee: " + employeeName);
					System.out.println("1. Name\n2. ID\n3.Department Job");
					
					int userChoice = scan.nextInt();
					
					if(userChoice == 1) {
						scan.nextLine();
						System.out.print("Please enter new name for Employee: ");
						String newName =scan.nextLine();
						e.setEmployeeName(newName);
						System.out.println("You have successfuily update the employees information!");
						System.out.println(e.ListEmployee());
						
						return;
					}
					else if(userChoice == 2) {
						System.out.print("Please enter new ID for Employee: ");
						int newID = scan.nextInt();
						e.setID(newID);
						System.out.println("You have successfuily update the employees information!");
						System.out.println(e.ListEmployee());
						
						return;
					}
					else if(userChoice == 3) {
						scan.nextLine();
						System.out.print("Please enter new Job for Employee: ");
						String newJob = scan.nextLine();
						e.setDepartmentJob(newJob);
						System.out.println("You have successfuily update the employees information!");
						System.out.println(e.ListEmployee());
						
						return;
					}
					
				}
			}
			System.out.println("This employee doesn't exist");
		}
		
	}
	public void ListEmployeeName() {
		if(employeeRoster.isEmpty()) {
			System.out.println("There are no employees in this department!");
		}
		else {
			Scanner scan = new Scanner(System.in);
			System.out.println("1. Search for employee by name\n2. List all current department employees");
			int userChoice = scan.nextInt();
			if(userChoice == 1) {
				scan.nextLine();
				System.out.print("Please enter the name of the employee you'd like to search: ");
				String employeeName = scan.nextLine();
				System.out.println(employeeName);
				for(Employee e: employeeRoster) {
					if(e.getEmployeeName().equals(employeeName)) {
						System.out.println(e.ListEmployee());
						
						return;
					}
				}
				System.out.println("This employee doesn't exist");
			}
			else if(userChoice == 2){
				employeeRoster.stream().forEach(System.out::println);
			}	
		}
	}
	public void RemoveEmployee(String employeeName) {
		if(employeeRoster.isEmpty()) {
			System.out.println("There are no employees in this department!");
		}
		else {
			for(Employee e: employeeRoster) {
				if(e.getEmployeeName().equals(employeeName)) {
					System.out.println(e.getEmployeeName()+ " has been removed");
					employeeRoster.remove(e);
					return;
				}
			}
			System.out.println("This employee doesn't exist");
		}
	}
	public void addEmployee(Employee employee) {
		employeeRoster.add(employee);
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public double getDepartmentBudget() {
		return departmentBudget;
	}
	public void setDepartmentBudget(double departmentBudget) {
		this.departmentBudget = departmentBudget;
	}
	public long getDepartmentPhoneNumber() {
		return departmentPhoneNumber;
	}
	public void setDepartmentPhoneNumber(int departmentPhoneNumber) {
		this.departmentPhoneNumber = departmentPhoneNumber;
	}
	public Set<Employee> getEmployeeRoster() {
		return employeeRoster;
	}
	public String ListDepartment() {
		return "Department= " + departmentName + "\nBudget= " + departmentBudget + "\nDepartment Phone Number= " + departmentPhoneNumber+ "\nDepartment employees= " + employeeRoster;
	}
	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", departmentBudget=" + departmentBudget
				+ ", departmentPhoneNumber=" + departmentPhoneNumber + ", employeeRoster=" + employeeRoster + "]";
	}
	
}
