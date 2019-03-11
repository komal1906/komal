package com.capg.demo.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.capg.demo.bean.Employee;


public interface IEmployeeRepository {

	public Employee addEmployee(Employee employee);
	public Employee findEmployee(int empId);
	public  List<Employee> findEmployeeName(String empFirstName);
	public Employee updateEmployee(Employee employee);
	public List<Employee> getEmployeeList();
	public Employee deleteEmployee(int empId);
	
}
