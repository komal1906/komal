package com.capg.demo.service;

import java.util.List;

import com.capg.demo.bean.Employee;


public interface IEmployeeService {

	public Employee addEmployee(Employee employee);
	public Employee findEmployee(int empId);
	public  List<Employee> findEmployeeName(String empFirstName);
	public Employee updateEmployee(Employee employee);
	public List<Employee> getEmployeeList();
	public Employee deleteEmployee(int empId);
}
