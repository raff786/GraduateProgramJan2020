package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;

@Repository //declare the DAO layer as repository
public interface EmployeeJPADAO extends CrudRepository<Employee, Integer> {
		//defines the method for each named query in the entity
	Iterable<Employee> findBySalary(
			@Param("minSalary") double minSalary, 	//map each parameer with @Params(<name>)
			@Param("maxSalary") double maxSalary); 
	
	
	Iterable<Employee> findByDesignation(@Param("designation") Designation designation);
	
	
	
	

}
