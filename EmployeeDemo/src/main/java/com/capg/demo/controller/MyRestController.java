package com.capg.demo.controller;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.demo.bean.Employee;
import com.capg.demo.exception.EmptyEmployeeList;
import com.capg.demo.exception.InvalidEmployeeId;
import com.capg.demo.exception.InvalidMobileException;
import com.capg.demo.service.IEmployeeService;


@RestController
public class MyRestController {
	
	@Autowired
	IEmployeeService service;
	
	public IEmployeeService getService() {
		return service;
	}

	public void setService(IEmployeeService service) {
		this.service = service;
	}
	@RequestMapping(value="/addEmployee",consumes="application/json",
			produces="application/json",method=RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee )
	{
		employee=service.addEmployee(employee);
		return employee;

	}
	
	@RequestMapping(value="/updateEmployee",consumes="application/json",
			produces="application/json",method=RequestMethod.POST)
	public Employee updateEmployee(@RequestBody Employee employee )
	{
		employee=service.updateEmployee(employee);
		return employee;

	}
	
	@RequestMapping(value="/deleteEmployee/{empId}",
			produces="application/json",method=RequestMethod.POST)
	public Employee deleteEmployee(@PathVariable int empId )
	{
		Employee customer=service.deleteEmployee(empId);
		return customer;

	}
	
	@RequestMapping(value="/getEmployeeList",
			produces="application/json")
	public List<Employee> getEmployeeList() 
	{
		List<Employee> list=service.getEmployeeList();
		return list;

	}
	@RequestMapping(value="/getEmployee/{empId}",produces="application/json")
	public Employee findEmployee(@PathVariable int empId)
	{
		Employee employee=service.findEmployee(empId);
		return employee;
	}
	@RequestMapping(value="/getEmployeeName/{empFirstName}",produces="application/json",method=RequestMethod.GET)
	public  List<Employee> findEmployeeName(@PathVariable String empFirstName)
	{
		List<Employee> list=service.findEmployeeName(empFirstName);
		return list;
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Employee Id not present")
	@ExceptionHandler({InvalidEmployeeId.class})
	public void handleIdException()
	{
		
	}
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Deleted Employee Id not present")
	@ExceptionHandler({InvalidMobileException.class})
	public void handleMobileException()
	{
		
	}
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Employee List is empty")
	@ExceptionHandler({EmptyEmployeeList.class})
	public void handleEmptyException()
	{
		
	}
}


