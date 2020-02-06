package com.mastek.hrapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

@Component//so this class is initialized by Spring application context
public class EmployeeListener {
	
	//syntax is..
	//@<lifecycle-event>
	//public void <method-name>(Entity e)
	
	@PrePersist //call this method before inserting each emp object in employee table
	public void beforeEmpInsert(Employee e) {
		System.out.println("before Employee insert");
		System.out.println("Raise Email request for "+e.getEmpno());
		
	}
	@PostPersist// call this method after inserting each emp object in the employee table
	public void afterEmpInsert(Employee e) {
		System.out.println("After Employee Insert");
		System.out.println("Screen name Generated: "+e.getName()+e.getEmpno());
	}
	
	@PreUpdate // call this method before updating each emp object in the employee table
	public void beforeUpdate(Employee e) {
		System.out.println("Before update: "+e);
	}

	@PostUpdate // call this method after updating each emp object in the employee table
	public void afterUpdate(Employee e) {
		System.out.println("After update: " + e);
	}
	
	@PostLoad // call this method after loading each emp object in the employee table
	public void afterLoading(Employee e) {
		System.out.println("Employee Fteched: "+e);
	}
	
	@PreRemove // call this method before removing each emp object in the employee table
	public void beforeDelete(Employee e) {
		System.out.println("Before removing: "+e);
		System.out.println("disabled profile for "+e.getEmpno());
	}
	
	
	
}
