package com.mastek.hrapp.services;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.apis.EmployeeAPI;
import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionsDAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPositions;
import com.mastek.hrapp.entities.Project;


@Component   //marking the class as a bean to be created 
@Scope("singleton") //if singleton then one object is used across test cases, if its prototype then one object per request so it creates multiple objects for multiple data
public class EmployeeService implements EmployeeAPI {	

	String exampleProperty;
	
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmentJPADAO deptDAO;
	
	@Autowired
	ProjectJPADAO projectDAO;
	
	@Autowired
	JobPositionsDAO jobsDAO;
	
	
	
	
	public EmployeeService() {
		System.out.println("Employee Service Created");
	}
	
	@PostConstruct  //initialization method of the class 
	public void initalizeService() {
		System.out.println("Employee Service Initialized");
		
	}
	
	@PreDestroy //calls before the shutting down of the application 
	public void terminateService() {
		System.out.println("Employee service Terminated");
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
	@Transactional //this will keep the session open until the method returns a value
	public Employee assignEmployeeToDepartment(int empno, int deptno) {
		Employee emp = empDAO.findById(empno).get(); //fetch the employee if exists
		Department dept = deptDAO.findById(deptno).get(); //fetch the department if exists
		
		//assign the association between employee and department
		emp.setCurrentDepartment(dept); //assign the department to employee
		dept.getTeam().add(emp); //add the employee in the department team
		
		//saves the changes in database
		empDAO.save(emp);
		deptDAO.save(dept);
		
		
		return emp; //return the result
	}
	
	@Transactional
	public Employee assignEmployeeToProject(int empno, int projectId) {
		Employee emp = empDAO.findById(empno).get(); //get employee object
		Project newProject = projectDAO.findById(projectId).get(); //get the project object
		
		emp.getProjectsAssigned().add(newProject); //assign employee to project
		empDAO.save(emp); //save employee object
		
		return emp;//return the employee object
	}
	
	@Transactional
	public JobPositions applyForJobPosition(int jobId,int empno) {
		
		JobPositions job= jobsDAO.findById(jobId).get();
		Employee emp = empDAO.findById(empno).get();
		
		//adding employee object in applicants collection
		job.getApplicants().add(emp);
		
		job= jobsDAO.save(job);
		
		return job;
	}

	@Override
	public Iterable<Employee> listAllEmployees() {
		System.out.println("Listing all employees");
		return empDAO.findAll();
	}

	@Override
	public Employee findByEmpno(int empno) {
		// TODO Auto-generated method stub
		return empDAO.findById(empno).get();
	}

	@Override
	public Employee registerNewEmployee(Employee newEmployee) {
		newEmployee = empDAO.save(newEmployee);
		return newEmployee;
	}

	@Override
	@Transactional
	public Set<Project> getEmployeeProjects(int empno) {
		Employee currentEmp= empDAO.findById(empno).get();
		
		//get the dependencies populated within the method transaction
		int count = currentEmp.getProjectsAssigned().size();
		System.out.println(count+" project found");
		
		Set<Project> projects = currentEmp.getProjectsAssigned();
		return projects;
	}

	@Override
	@Transactional
	public Project registerProjectForEmployee(int empno, Project newProject) {
		newProject= projectDAO.save(newProject);
		assignEmployeeToProject(empno, newProject.getProjectID());
		return newProject;
	}
	
	
	
	
	
	
}
