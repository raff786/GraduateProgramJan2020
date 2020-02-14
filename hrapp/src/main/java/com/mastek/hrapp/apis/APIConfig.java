package com.mastek.hrapp.apis;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.services.DepartmentsService;
import com.mastek.hrapp.services.EmployeeService;
import com.mastek.hrapp.services.ProjectServices;

@Component //declare it as spring component 
public class APIConfig extends ResourceConfig{  //configure the service class using ResourceConfig
	
	public APIConfig() {
		//register each service class to enable services as API
		register(EmployeeService.class);
		register(DepartmentsService.class);
		register(ProjectServices.class);
		
	}

}
