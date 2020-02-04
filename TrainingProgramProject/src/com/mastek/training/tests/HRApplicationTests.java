package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Announcement;
import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.EmailAnnouncement;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.hrapp.SMSAnnouncement;
import com.mastek.training.hrapp.SalesEmployee;
import com.mastek.training.packone.Circle;
import com.mastek.training.packone.Rectangle;
import com.mastek.training.packone.Shape;



class HRApplicationTests {
	Employee ex1;
	
	
	@BeforeEach
	public void setupEmpTestCase() {
	System.out.println("Before Test");
	//Employee.DEFAULT_ZERO;
	ex1= new Employee();
	ex1.setEmpno(1002 );
	ex1.setName("Example");
	ex1.setUnitDaySalary(300);
	ex1.setDesignation(Designations.MANAGER);
	ex1.setGrade(Grades.G8);
	
	Employee ex2 = new Employee(1122) ;
	
	Employee ex3 = new Employee(2233,"example",344,Designations.DEVELOPER,Grades.G10);
		
	ex2=null;
	ex3=null;
	
	System.gc(); //notifies the system to collect garbage
	
	//ex2.getEmpno(); this will throw a null pointer exception as its been assigned to null
	
	}
	
	@AfterEach	
	public void tearDownEmpTestCase() {
		System.out.println("After Test");
	}
	
	
	@Test
	void testCreateAndPrintExampleEmployeeObject() {
		System.out.println("Test case Create");

		System.out.println(
				"Number: "+ ex1.getEmpno()+
				"\nName: " +ex1.getName()+
				"\nDay Salary: "+ex1.getUnitDaySalary()+
				"\nDesignation: "+ex1.getDesignation()+
				"\nGrade: "+ex1.getGrade());
	}
	
	
	
	@Test
	void testCreateAndComputeSalaryEmployeeObject() {
		System.out.println("Test case Compute");
//		Employee ex1= new Employee();
//		ex1.setEmpno(1002 );
//		ex1.setName("Example");
//		ex1.setUnitDaySalary(300);
//		ex1.setDesignation(Designations.MANAGER);
//		ex1.setGrade(Grades.G8);
		
		
		try {
			assertEquals(9000.0,ex1.getNetSalary(30),"Invalid Net Salary Computation");
			assertEquals(0,ex1.getNetSalary(-30),"Invalid Net Salary Computation");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testSalesEmployeeObjectUsage() {
		SalesEmployee salesEx1= new SalesEmployee();
		
		salesEx1.setEmpno(224);
		salesEx1.setName("example");
		salesEx1.setUnitDaySalary(100);
		salesEx1.setDesignation(Designations.OFFICER);
		salesEx1.setGrade(Grades.G8);
		salesEx1.setCommission(0.8);
		salesEx1.setTarget(1000000000);
		
		try {
			assertEquals(1620,salesEx1.getNetSalary(9),"invalid salary calculated");
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	@Test
	void testObjectFeaturesOnEmployee() {
		System.out.println("<===========object feature starts here========>"); 
		System.out.println(ex1.toString()); 
		 
		System.out.println("HashCode: "+ ex1.hashCode());
		System.out.println("<===========object feature starts ends========>");
	}
		
	@Test
	void testSendAnnouncementToEmployees() { //abstract class example
		//cannot create an object of abstract class using new keyword
		//Announcement exAnnouncment = new Announcement();   
		
		Announcement exSMS= new SMSAnnouncement();
		
		exSMS.setFrom("UK-HR");
		exSMS.setForGroup("MASTEKEER_AT_GLASGOW");
		exSMS.setSubject("inclement Weather Conditions at Glasgow");
		exSMS.setContentText("All Employees are advised to opt for work from home tomorrow");
		
			
		Announcement exEmail = new EmailAnnouncement();
		exEmail.setFrom("Leadership Teams");
		exEmail.setForGroup("MASTEKEERS");
		exEmail.setSubject("QMEET Jan 2020");
		exEmail.setContentText("You are invited to attend Quarterly meet online via WEBX");
		
		if(exSMS instanceof SMSAnnouncement) {
			System.out.println("Connect to sms server");
			exSMS.sendAnnouncement(); //connect to SMS and use Send from SMSAnnouncement 
		}
		if(exEmail instanceof EmailAnnouncement) {
			System.out.println("Connect to email server");
			exEmail.sendAnnouncement(); //connect to email and use Send from emailAnnouncement
		}
		 
		
		assertTrue(exSMS instanceof SMSAnnouncement,"invalid Announcement Implementation");
		assertTrue(exEmail instanceof EmailAnnouncement,"invalid Announcement Implementation");
	}
	
	
	@Test
	void testShapeExample() { //interfaces example
		
		Rectangle rect = new Rectangle();
		rect.setLength(10);
		rect.setBreadth(20);
		
		Circle circle = new Circle();
		circle.setRadius(20);
		
		Shape shRect= rect;
		Shape shCircle= circle;
		
		System.out.println("Rectangle Area: "+shRect.getArea());
		System.out.println("Rectangle Perimeter: "+shRect.getPerimeter());
		
		System.out.println("circle Area: "+shCircle.getArea());
		System.out.println("circle Perimeter: "+shCircle.getPerimeter());
		
		assertTrue(rect instanceof Shape,"Invalid type of Shape");
		assertTrue(circle instanceof Shape,"Invalid type of Shape");
		
		
		
	}
		
		
		
		
		
		
		
		
}
