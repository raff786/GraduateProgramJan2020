package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;


@Entity  //declared the class as an entity which will be managed by JPA
@Table(name="JPA_Employees") //declare the table name associated with the class 
@EntityListeners({EmployeeListener.class})//calls the appropriate listener event method on lifecycle event
@NamedQueries({
	@NamedQuery(name="Employee.findBySalary", //declare the query name as the method in DAO
			query="select e from Employee e where e.salary between :minSalary and :maxSalary")
			//identify the query to fetch Employee objects with properties and parameters
			//all the params are to be declared using @Param("<name>") in the DAO interface
			//: means its a parameter 
	,
	@NamedQuery(name="Employee.findByDesignation",
				query="select e from Employee e where e.designation=:designation")
				//identify the query method n the DAO and pass necessary params
})
public class Employee {
	
	int empno;
	String name;
	double salary;
	Designation designation;
	
	Department currentDepartment;
	
	
	@ManyToOne //one employee is associated wih one of the many departments 
	@JoinColumn(name="fk_department_number") //the foreign key column to store the associate deptno
	@Transient   //ignore this property when storing employee data in mongo db
	public Department getCurrentDepartment() {
		return currentDepartment;
	}



	public void setCurrentDepartment(Department currentDepartment) {
		this.currentDepartment = currentDepartment;
	}
	
	Set<Project> projectsAssigned = new HashSet<>();


	@ManyToMany(cascade= CascadeType.ALL) //configure many to many association for entities, only needs to be on one
	@JoinTable(name="JPA_PROJECTS_ASSIGNMENTS", //provide the join table name
				joinColumns={@JoinColumn(name="fk_empno")}, //Foreign key column for current class
				inverseJoinColumns= {@JoinColumn(name="fk_projectId")}
	)	//Foreign key column for collection
	@Transient 
	public Set<Project> getProjectsAssigned() {
		return projectsAssigned;
	}



	public void setProjectsAssigned(Set<Project> projectsAssigned) {
		this.projectsAssigned = projectsAssigned;
	}



	public Employee() {
		
	}
	
	
	
	@Id //marking the property as primary key
	@Column(name="employee_number")//using column to providue the default colum name
	@GeneratedValue(strategy=GenerationType.AUTO)//auto numbering configuration as per db
	public int getEmpno() {
		return empno;
	}






	public void setEmpno(int empno) {
		this.empno = empno;
	}





	@Column(name="employee_name",length=50,nullable=false)
	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}






	public double getSalary() {
		return salary;
	}






	public void setSalary(double salary) {
		this.salary = salary;
	}





	@Enumerated(EnumType.STRING)
	public Designation getDesignation() {
		return designation;
	}






	public void setDesignation(Designation designation) {
		this.designation = designation;
	}
	



	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + ", designation=" + designation
				+ "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empno;
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
		Employee other = (Employee) obj;
		if (empno != other.empno)
			return false;
		return true;
	}

	
	//@Transient: to mark 
	
}
