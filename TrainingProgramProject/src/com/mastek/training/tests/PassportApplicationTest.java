package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Employee;
import com.mastek.training.passport.DataAccessObject;
import com.mastek.training.passport.PassportApplication;
import com.mastek.training.passport.PassportDAO;
import com.mastek.training.passport.Sex;

class PassportApplicationTest {
	DataAccessObject<PassportApplication> passDAO;
	
	@BeforeEach
	void setUp() throws Exception {
		//passDAO = new PassportApplicationDAO();
		passDAO= new PassportDAO();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testaddDisplayPassportDetails() {
		
		
		PassportApplication newpass= new PassportApplication();
		
		newpass.setPassportID(1);
		newpass.setFirstName("Atiq");
		newpass.setSurName("Rafiq");
		newpass.setDateOfBirth("19/12/1995");
		newpass.setNationality("British");
		newpass.setPlacOfBirth("Sheffield");
		newpass.setSex(Sex.Male);
		
		
		newpass= passDAO.add(newpass);  //returns the object if saved successfully 
		assertNotNull(newpass,"passport added ");
		
		PassportApplication fetchEmp= passDAO.find(1);
		assertNotNull(fetchEmp,"passport not found ");
		
		
	}
	
	@Test
	void testListAllEmployees() {
		Collection<PassportApplication> pass = passDAO.listAll();
		for(PassportApplication passport:pass) {
			System.out.println(passport);
		}
	}

}
