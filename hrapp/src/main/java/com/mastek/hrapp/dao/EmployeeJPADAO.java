package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Employee;

@Repository //declare the DAO layer as repository
public interface EmployeeJPADAO extends CrudRepository<Employee, Integer> {  //crud repository <class,primarykeytype>
	
	

}
