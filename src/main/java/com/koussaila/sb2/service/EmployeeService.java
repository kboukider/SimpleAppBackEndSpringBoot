package com.koussaila.sb2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koussaila.sb2.model.Employee;
import com.koussaila.sb2.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	IEmployeeRepository iEmployeerepository;
	

	@Override
	public Employee getEmployee(Long id) {
		Optional<Employee> e = iEmployeerepository.findById(id);
		if(e.isPresent()) {
			return e.get() ;
		} else {
			return null;
		}	
	}

	@Override
	public Iterable<Employee> getEmployees() {
		
		return iEmployeerepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return iEmployeerepository.save(employee);
	}

	@Override
	public void deletEmployee(Long id) {
		
		iEmployeerepository.deleteById(id);
		
	}

}
