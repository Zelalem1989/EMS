package com.cognixia.advancedjava.ems;

public class Employee {
	private String employeeName;
	private  int ID;
	private String departmentJob;
	
	
	public Employee(String employeeName, int iD, String departmentJob) {
		super();
		this.employeeName = employeeName;
		ID = iD;
		this.departmentJob = departmentJob;
	}
	
	
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDepartmentJob() {
		return departmentJob;
	}
	public void setDepartmentJob(String departmentJob) {
		this.departmentJob = departmentJob;
	}
	public String ListEmployee() {
		return "Employee= " + employeeName + "\nID= " + ID + "\nDepartment Job= " + departmentJob;
	}
	@Override
	public String toString() {
		return "Employee= " + employeeName + " ID= " + ID + " Department Job= " + departmentJob;
	}
}
