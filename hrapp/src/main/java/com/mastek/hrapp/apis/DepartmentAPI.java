package com.mastek.hrapp.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Employee;

@Path("/hrapp/")
public interface DepartmentAPI {
	
	//http://localost:<portnumber>/hrapp/employees/list
	@GET  //we do support the HTTP method:GET
	@Path("/department/list")   //URL path to access this method
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //formats which the method supports
	public Iterable<Department> listAllDepartment();
	
	
	
	@GET
	@Path("/department/find/{deptno}")
	@Produces({MediaType.APPLICATION_JSON})
	public Department findBydeptno(@PathParam("deptno")int deptno);
	
	
	@POST //http method post used to send data in requests
	@Path("/department/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Department registerNewdeparment(@BeanParam Department newDepartment);

}

