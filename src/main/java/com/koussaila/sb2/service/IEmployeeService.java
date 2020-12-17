package com.koussaila.sb2.service;

import com.koussaila.sb2.model.Employee;

public interface IEmployeeService {
	
	public Employee getEmployee(Long id);
	
	public Iterable<Employee> getEmployees();
	
	public Employee saveEmployee (Employee employee);
	
	public void deletEmployee(Long id);

}
