	package com.qsp.soringbootemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.soringbootemployee.dao.EmployeeDao;
import com.qsp.soringbootemployee.dto.Employee;
import com.qsp.soringbootemployee.exception.EmailNotPresent;
import com.qsp.soringbootemployee.exception.IdNotFound;
import com.qsp.soringbootemployee.exception.NoData;
import com.qsp.soringbootemployee.exception.NotPresentInGivenRange;
import com.qsp.soringbootemployee.exception.PhoneNotPresent;
import com.qsp.soringbootemployee.util.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee)
	{
		double salary=employee.getSalary();
		
		if (salary <10000) {
			employee.setGrade('A');
		}
		else if(salary >=1000 && salary<20000) {
			employee.setGrade('B');
		}
		else if(salary >=20000 && salary<40000)
		{
			employee.setGrade('C');
		}
		else
		{
			employee.setGrade('D');
		}
		
		ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		structure.setMessage("Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveEmployee(employee));
		return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(int id)
	{
		Employee employee =dao.findEmployee(id);
		
		ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		if(employee!=null)
		{
		structure.setMessage("Found Successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(employee);
		return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.FOUND);
		}
		else
		{
			throw new IdNotFound("Id Not Found");
		}
		
		
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee()
	{
		List<Employee> list=dao.findAllEmployee();
		ResponseStructure<List<Employee>> structure=new ResponseStructure<List<Employee>>();
		if(list.isEmpty())
		{
			throw new NoData("No Data Present in Table");
		}
		else
		{
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new  ResponseEntity<ResponseStructure<List<Employee>>>(structure,HttpStatus.FOUND);
		}
 		
	}
	
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int id)
	{
		Employee employee=dao.findEmployee(id);
		ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		
		if (employee!=null) {
			
			structure.setMessage("Data deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteEmployee(id));
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}
		else
		{
			structure.setMessage("Id Not Present");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(dao.deleteEmployee(id));
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.NOT_FOUND);
		}
		
	}
	public  ResponseEntity<ResponseStructure<Employee>> updateEmployee(int id,Employee employee)
	{
		
		
		Employee employee1=dao.findEmployee(id);
		ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		if (employee1!=null) {
			double salary=employee.getSalary();
			
			if (salary <10000) {
				employee.setGrade('A');
			}
			else if(salary >=1000 && salary<20000) {
				employee.setGrade('B');
			}
			else if(salary >=20000 && salary<40000)
			{
				employee.setGrade('C');
			}
			else
			{
				employee.setGrade('D');
			}
			structure.setMessage("Data Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateEmployee(id, employee));
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFound("Id Not Found");
		}
		
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmail(int id, String email) {
		
		Employee employee=dao.findEmployee(id);
		
		
		ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		if(employee!= null)
		{
			employee.setEmail(email);
			structure.setMessage("Email Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateEmployee(id, employee));
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFound("Id Not Found");
		}
		
	}

	public ResponseEntity<ResponseStructure<Employee>> updatePhone(int id, long phone) {
		Employee employee=dao.findEmployee(id);
		
		ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		if(employee!= null)
		{
			employee.setPhone(phone);
			structure.setMessage("phone Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateEmployee(id, employee));
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFound("Id Not Found");
		}
		
	}

	public ResponseEntity<ResponseStructure<Employee>> updateSalary(int id, double salary) {
		Employee employee=dao.findEmployee(id);
		
		ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		if(employee!= null)
		{
			employee.setSalary(salary);
	        
			
			if (salary <10000) {
				employee.setGrade('A');
			}
			else if(salary >=1000 && salary<20000) {
				employee.setGrade('B');
			}
			else if(salary >=20000 && salary<40000)
			{
				employee.setGrade('C');
			}
			else
			{
				employee.setGrade('D');
			}
			structure.setMessage("Salary Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateEmployee(id, employee));
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFound("Id Not Found");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findByEmail(String eamil)
	{
		Employee employee= dao.findByEmail(eamil);
		ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		if(employee!=null)
		{
		structure.setMessage("Found Successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(employee);
		return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.FOUND);
		}
		else
		{
			throw new EmailNotPresent("email not present");

		}
		
	}
	public ResponseEntity<ResponseStructure<Employee>> findByPhone(long phone)
	{
		Employee employee=dao.findByPhone(phone);
		ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		if(employee!=null)
		{
		structure.setMessage("Found Successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(employee);
		return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.FOUND);
		}
		else
		{
			throw new PhoneNotPresent("Phone not Present");

		}
		

	}
	public ResponseEntity<ResponseStructure<List<Employee>>> salaryGreaterThan(double salary)
	{
		
		List<Employee> list=dao.salaryGreaterThan(salary);
		ResponseStructure<List<Employee>> structure=new ResponseStructure<List<Employee>>();
		if(list.isEmpty())
		{
			throw new NotPresentInGivenRange("No Data In Given Range");
		}
		else
		{
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure,HttpStatus.FOUND);
		}
 		

	
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> salaryLessThan(double salary)
	{
		
		List<Employee> list=dao.salaryLessThan(salary);
		ResponseStructure<List<Employee>> structure=new ResponseStructure<List<Employee>>();
		if(list.isEmpty())
		{
			throw new NotPresentInGivenRange("No Data In Given Range");
		}
		else
		{
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure,HttpStatus.FOUND);
		}
 		
	}
	
}
