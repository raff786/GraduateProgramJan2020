package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement //declares the entity to be transformed to xml or JSON
@Entity  //declared the class as an entity which will be managed by JPA
@Table(name="JPA_Projects") //declare the table name associated with the class 
public class Project {
	int projectID;
	
	@FormParam("name")
	String name;
	@FormParam("customerName")
	String customerName;
	
	Set<Employee> projectTeams = new HashSet<>();
	
	//Provides the property in employee with @ManyTMany and @JoinTable configuration 
	@ManyToMany(mappedBy="projectsAssigned")
	@XmlTransient
	public Set<Employee> getProjectTeams() {
		return projectTeams;
	}
	public void setProjectTeams(Set<Employee> projectTeams) {
		this.projectTeams = projectTeams;
	}
	public Project() {
		
	}
	@Id //marking the property as primary key
	@Column(name="project_number")//using column to providue the default colum name
	@GeneratedValue(strategy=GenerationType.AUTO)//auto numbering configuration as per db
	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	@Column(name="project_name",length=50,nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="customer_name",length=50,nullable=false)
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + projectID;
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
		Project other = (Project) obj;
		if (projectID != other.projectID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [projectID=" + projectID + ", name=" + name + ", customerName=" + customerName + "]";
	}
	
	
	

}
