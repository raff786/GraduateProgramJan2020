package com.mastek.hrapp.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mastek.hrapp.entities.Project;

@Path("/hrapp/")
public interface ProjectAPI {
	
	//http://localost:<portnumber>/hrapp/employees/list
	@GET  //we do support the HTTP method:GET
	@Path("/project/list")   //URL path to access this method
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //formats which the method supports
	public Iterable<Project> listAllProjects();
	
	
	
	@GET
	@Path("/project/find/{projectID}")
	@Produces({MediaType.APPLICATION_JSON})
	public Project findByprojectID(@PathParam("projectID")int projectID);
	
	
	@POST //http method post used to send data in requests
	@Path("/project/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Project registerNewproject(@BeanParam Project newproject);

}

