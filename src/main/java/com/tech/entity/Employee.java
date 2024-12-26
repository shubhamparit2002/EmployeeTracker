package com.tech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	private String empDepartment;
	private String shiftLogin;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDepartment() {
		return empDepartment;
	}
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	public String getShiftLogin() {
		return shiftLogin;
	}
	public void setShiftLogin(String shiftLogin) {
		this.shiftLogin = shiftLogin;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDepartment=" + empDepartment
				+ ", shiftLogin=" + shiftLogin + "]";
	}
	public Employee(int empId, String empName, String empDepartment, String shiftLogin) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDepartment = empDepartment;
		this.shiftLogin = shiftLogin;
	}
	public Employee() {
		
		// TODO Auto-generated constructor stub
	}
	
	
}
