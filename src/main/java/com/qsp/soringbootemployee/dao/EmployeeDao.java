package com.qsp.soringbootemployee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.soringbootemployee.dto.Employee;
import com.qsp.soringbootemployee.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepo repo;
	
	public Employee saveEmployee(Employee employee)
	{
		return repo.save(employee);
	}
	
	
	public Employee findEmployee(int id)
	{
		//return repo.findById(id).get();     //to avoid noSuchElementException
		
		Optional<Employee> optional=repo.findById(id);
		
		if (optional.isPresent()) {
			return optional.get();
		}
		else
		{
			return null;
		}
		
		//OR
//		if(optional.isEmpty())
//		{
//			return null;
//		}
//		else
//		{
//			return optional.get();
//		}
	}
	
	public List<Employee> findAllEmployee()
	{
		return repo.findAll();
	}
	
	public Employee deleteEmployee(int id)
	{
		Optional<Employee> optional=repo.findById(id);
		
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		else
		{
			return null;
		}
	
		
		// OR
		
//		if(optional.isPresent())
//		{
//			Employee  employee=optional.get();
//			repo.delete(employee);
//			return employee;
//		}
//		else
//		{
//			return null;
//		}
	}
	
	public Employee updateEmployee(int id, Employee employee)
	{
		Optional<Employee> optional=repo.findById(id);
		
		if (optional.isPresent()) {
			employee.setId(id);
			
			return repo.save(employee);
		}
		return null;
	}
	public Employee findByEmail(String email)
	{
		return repo.findEmployeeByEmail(email);
	}
	
	public Employee findByPhone(long phone)
	{
		return repo.empByPhone(phone);
	}
	
	public List<Employee> salaryGreaterThan(double salary)
	{
		return repo.findEmployeeBySalaryGreaterThan(salary);
	}
	
	public List<Employee> salaryLessThan(double salary)
	{
		return repo.findEmployeeBySalaryLessThan(salary);
	}
	
}
