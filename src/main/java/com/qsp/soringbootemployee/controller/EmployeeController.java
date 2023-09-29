package com.qsp.soringbootemployee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.soringbootemployee.dao.EmployeeDao;
import com.qsp.soringbootemployee.dto.Employee;
import com.qsp.soringbootemployee.service.EmployeeService;
import com.qsp.soringbootemployee.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/save")
	@ApiOperation(value = "Save Employee", notes= "This API is used to save the employee data in the database")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Data Saved Successfully")})
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@Valid @RequestBody Employee  employee)
	{
		return service.saveEmployee(employee);
	}
	
	@GetMapping("/find")
	@ApiOperation(value = "Find Employee", notes="This API is used to find the employee data in the database")
	@ApiResponses(value = {@ApiResponse(code = 302, message="Data Found Successfully")})
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(@RequestParam int id)
	{
		return service.findEmployee(id);   
		

	}
	
	@GetMapping("/findAll")
	@ApiOperation(value = "Find All Employee", notes="This API is used to find All the employee data in the database")
	@ApiResponses(value = {@ApiResponse(code = 302, message="Data Found Successfully")})
	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee()
	{
		return service.findAllEmployee();
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Delete Employee", notes="This API is used to delete the employee data in the database")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Data Delete Successfully")})
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@PathVariable int id)
	{
		 return service.deleteEmployee(id);
	}
	
	@PutMapping("/update")
	@ApiOperation(value = "Update Employee", notes="This API is used to Update the employee data in the database")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Data Update Successfully")})
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int id,@Valid @RequestBody Employee employee)
	{
		return service.updateEmployee(id, employee);
	}
	@PatchMapping("/updateEmail/{id}")
	@ApiOperation(value = "Update Employee", notes="This API is used to Update the Email  in the database")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Email Update Successfully ")})
	public ResponseEntity<ResponseStructure<Employee>> updateEmail(@PathVariable int id,@Valid @RequestParam String email)
	{
		return service.updateEmail(id,email);
	}
	@PatchMapping("/updatePhone/{id}")
	@ApiOperation(value = "Update Phone", notes="This API is used to Update the Phone  in the database")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Phone Update  Successfully")})
	public ResponseEntity<ResponseStructure<Employee>> updatePhone(@PathVariable int id,@Valid @RequestParam long phone)
	{
		return service.updatePhone(id,phone);
	}
	@PatchMapping("/updateSalary/{id}")
	@ApiOperation(value = "Update salary ", notes="This API is used to Update Salary  in the database")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Salary Update Successfully")})
	public ResponseEntity<ResponseStructure<Employee>> updateSalary(@PathVariable int id,@RequestParam double salary)
	{
		return service.updateSalary(id,salary);
	}
	@GetMapping("/findByEmail")
	@ApiOperation(value = "Find Employee By Email", notes="This API is used to find the employee by email  in the database")
	@ApiResponses(value = {@ApiResponse(code = 302, message="Data Found Successfully")})
	public ResponseEntity<ResponseStructure<Employee>> findByEmail(@Valid  @RequestParam String email)
	{
		return service.findByEmail(email);
	}
	
	@GetMapping("/findByPhone/{phone}")
	@ApiOperation(value = "Find Employee by phone", notes="This API is used to find the employee by phone  in the database")
	@ApiResponses(value = {@ApiResponse(code = 302, message="Data Found Successfully")})
	public ResponseEntity<ResponseStructure<Employee>> findByPhone(@Valid @PathVariable long phone)
	{
		return service.findByPhone(phone);
	}
	@GetMapping("/salaryGreaterThan/{salary}")
	@ApiOperation(value = "Find Employee with salary greater than", notes="This API is used to find the employee with salary greater than  in the database")
	@ApiResponses(value = {@ApiResponse(code = 302, message="Data Found Successfully")})
	public ResponseEntity<ResponseStructure<List<Employee>>> salaryGreaterThan(@Valid @PathVariable double salary)
	{
		return service.salaryGreaterThan(salary);
	}
	@GetMapping("/salaryLessThan/{salary}")
	@ApiOperation(value = "Find Employee with salary less than", notes="This API is used to find the employee with salary less than  in the database")
	@ApiResponses(value = {@ApiResponse(code = 302, message="Data Found Successfully")})
	public ResponseEntity<ResponseStructure<List<Employee>>> salaryLessThan(@Valid @PathVariable double salary)
	{
		return service.salaryLessThan(salary);
	}
}
