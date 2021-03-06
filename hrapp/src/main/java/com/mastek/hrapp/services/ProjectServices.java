package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.apis.ProjectAPI;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Project;


@Component   //marking the class as a bean to be created 
@Scope("singleton") //if singleton then one object is used across test cases, if its prototype then one object per request so it creates multiple objects for multiple data
public class ProjectServices implements ProjectAPI{	

	String exampleProperty;
	int i;
	
	@Autowired
	ProjectJPADAO projDAO;
	
	public ProjectServices() {
		System.out.println("project Service Created");
	}
	
	@PostConstruct  //initialization method of the class 
	public void initalizeService() {
		System.out.println("project Service Initialized");
		
	}
	
	@PreDestroy //calls before the shutting down of the application 
	public void terminateService() {
		System.out.println("project service Terminated");
	}
	
	public void exampleMethod() {
		System.out.println("connect to " +getExampleProperty()+ " for business data");
	}


	public String getExampleProperty() {
		return exampleProperty;
	}

	@Value("Spring Example Data Source") //initialize the property with the simple value 
	public void setExampleProperty(String exampleProperty) {
		System.out.println("exampe property set:"+ exampleProperty);
		this.exampleProperty = exampleProperty;
	}
	
	@Override
	public Iterable<Project> listAllProjects() {
		System.out.println("Listing all projects");
		return projDAO.findAll();
	}

	@Override
	public Project findByprojectID(int projectID) {
		// TODO Auto-generated method stub
		return projDAO.findById(projectID).get();
	}

	@Override
	public Project registerNewproject(Project newproject) {
		newproject = projDAO.save(newproject);
		return newproject;
	}



}
	
