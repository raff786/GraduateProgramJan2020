package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.linkedIn.Profile;

class LinkedInTest {

	@Test
	void testCreateProfileAndView() {
		
		Profile li1= new Profile();
		li1.setEmail("Test@mastek.com");
		li1.setProfileName("Test");
		li1.setQualifications("Example");
		li1.setSkills("java");
		li1.setCertifications("GDPR");
		li1.setJobDetails("Mastek");
		
		System.out.println(
				"Name: " +li1.getProfileName()+
				"\nQualifications: "+li1.getQualifications()+
				"\nSkills: "+li1.getSkills()+
				"\nCertification: "+li1.getCertifications()+
				"\nJobDetails: "+li1.getJobDetails());
	}

}

//qualification, skills, certifications and Job details to show experiences
