package com.koussaila.sb2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.koussaila.sb2.model.Employee;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

}
