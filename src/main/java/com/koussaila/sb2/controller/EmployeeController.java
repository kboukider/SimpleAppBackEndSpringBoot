package com.koussaila.sb2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koussaila.sb2.model.Employee;
import com.koussaila.sb2.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService iEmployeeService;
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) {
	
		return iEmployeeService.getEmployee(id);
	}
	
	@GetMapping("/employees")
	public Iterable<Employee> getEmployees() {
		return iEmployeeService.getEmployees();
		
	}
	
	  @PostMapping("/employee") 
	  public Employee saveEmployee (@RequestBody Employee employee) { 
		  
		  return iEmployeeService.saveEmployee(employee);
	  
	  }
	  
	  @DeleteMapping("/employee/{id}") 
	  public void deletEmployee(@PathVariable("id") Long id) {
		  
		  iEmployeeService.deletEmployee(id); 
	  
	  }
	  
	  
	  @PutMapping("/employee/{id}")
	  public Employee updateEmployee (@PathVariable("id") Long id,@RequestBody Employee employee) {
		  
		  Employee updatedEmployee = iEmployeeService.getEmployee(id);
		
		  String firstName = employee.getFirstName();
		  if(firstName != null) {
			  updatedEmployee.setFirstName(firstName);
		  }		 
		  String lastName = employee.getLastName();
		  if(lastName !=null) {
			updatedEmployee.setLastName(lastName);  
		  }
		  String password = employee.getPassword();
		  if(password != null) {
			  updatedEmployee.setPassword(password);
		  }
		  String mail = employee.getMail();
		  if (mail != null) {
			  updatedEmployee.setMail(mail);
		  }
		  
		 Employee udatedEmployeeSuccess = iEmployeeService.saveEmployee(updatedEmployee);
		  return udatedEmployeeSuccess;
	  }
	 
	  
	
}
