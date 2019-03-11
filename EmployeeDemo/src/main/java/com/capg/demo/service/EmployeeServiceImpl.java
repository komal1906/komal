package com.capg.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.demo.bean.Employee;
import com.capg.demo.exception.InvalidMobileException;
import com.capg.demo.repo.IEmployeeRepository;


@Transactional
@Service("service")
public class EmployeeServiceImpl implements IEmployeeService{
	@Autowired
	IEmployeeRepository repo;	
	public IEmployeeRepository getRepo() {
		return repo;
	}
	public void setRepo(IEmployeeRepository repo) {
		this.repo = repo;
	}
	@Override
	public Employee addEmployee(Employee employee) 
	{
		String empMobileNo=employee.getEmpMobileNo();
		String mobpattern="^[0-9] {10}$";
		boolean mob=mobpattern.matches(empMobileNo);
		if(mob==false)
			throw new InvalidMobileException();
		
		return repo.addEmployee(employee);
				
		
	}
	@Override
	public Employee findEmployee(int empId) {
		return repo.findEmployee(empId);
				
	}
	@Override
	public Employee updateEmployee(Employee employee) {
		return repo.updateEmployee(employee);
		
	}
	@Override
	public List<Employee> getEmployeeList() {
		return repo.getEmployeeList();
	}
	@Override
	public Employee deleteEmployee(int empId) {
		return repo.deleteEmployee(empId);
	}
	public List<Employee> findEmployeeName(String empFirstName)
	{
		return repo.findEmployeeName(empFirstName);
	}
	
}
