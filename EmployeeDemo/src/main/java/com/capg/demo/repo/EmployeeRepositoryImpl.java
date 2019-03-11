package com.capg.demo.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.demo.bean.Employee;
import com.capg.demo.exception.EmptyEmployeeList;
import com.capg.demo.exception.InvalidEmployeeId;
import com.capg.demo.exception.InvalidMobileException;



@Transactional
@Repository("repo")
public class EmployeeRepositoryImpl implements IEmployeeRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public Employee addEmployee(Employee employee) {
		
		entityManager.persist(employee);
		return employee;
	}
	@Override
	public Employee findEmployee(int empId) {
		Employee employee= entityManager.find(Employee.class, empId);
		if(employee==null)
		{
			throw new InvalidEmployeeId();
		}
		employee.setEmpId(empId);
		return employee;
	}
	@Override
	public Employee updateEmployee(Employee employee) {
		entityManager.merge(employee);
		return employee;
	}
	@Override
	public List<Employee> getEmployeeList() {
		TypedQuery<Employee> query=entityManager.createQuery
				("select emp from Employee emp ", Employee.class);
		List<Employee> list= query.getResultList();
		if(list==null)
		{
			throw new EmptyEmployeeList();
		}
		
		return list;
	}
	@Override
	public Employee deleteEmployee(int empId) {
		Employee employee= entityManager.find(Employee.class, empId);
		if(employee==null)
		{
			throw new InvalidMobileException();
		}
		entityManager.remove(employee);
		return employee;
	}
	public  List<Employee> findEmployeeName(String empFirstName)
	{
		System.out.println(empFirstName);
		List<Employee> emp=entityManager.createQuery("select emp from Employee emp where emp.empFirstName = : name",Employee.class).setParameter("name", empFirstName).getResultList();	
		return emp;
	}
	
	

}
