package com.mastek.hrapp.entities;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity  //declared the class as an entity which will be managed by JPA
@Table(name="JPA_Departments") //declare the table name associated with the class 
public class Department {
	int deptno;
	String name;
	String location;
	
	
	Set<Employee> team = new HashSet<>();
	//specify in mappedBy
	//this associates the many entity using collection with cascade enabled 
	@OneToMany(mappedBy="currentDepartment",cascade=CascadeType.ALL)
	public Set<Employee> getTeam() {
		return team;
	}

	public void setTeam(Set<Employee> team) {
		this.team = team;
	}

	public Department() {
		
	}

	@Id //marking the property as primary key
	@Column(name="department_number")//using column to providue the default colum name
	@GeneratedValue(strategy=GenerationType.AUTO)//auto numbering configuration as per db
	public int getDeptno() {
		return deptno;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Column(name="department_name",length=50,nullable=false)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptno;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (deptno != other.deptno)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", name=" + name + ", location=" + location + "]";
	}
	
	
	
	
	
	
	

}
