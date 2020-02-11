package com.mastek.hrapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionsDAO;
import com.mastek.hrapp.dao.PaymentJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.CardPayment;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPositions;
import com.mastek.hrapp.entities.Payment;
import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.entities.chequePayment;
import com.mastek.hrapp.services.DepartmentsService;
import com.mastek.hrapp.services.EmployeeService;
import com.mastek.hrapp.services.ProjectServices;

@SpringBootTest
class HrappApplicationTests {
	
	@Autowired //Spring will provide the object using IOC, dependency injection technique 
	EmployeeService empSvc;
	
	@Autowired
	DepartmentsService depSvc;
	
	@Autowired
	ProjectServices projSvc;
	
	
	
	
	@Autowired
	EmployeeService empSvc1;
	
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmentJPADAO depDAO;
	
	@Autowired
	ProjectJPADAO projectDAO;
	
	@Autowired
	PaymentJPADAO paymentDAO;
	
	@Autowired
	JobPositionsDAO jobDAO;
	
	//@Test
	void testAddJobPositionDocument() {
		
		JobPositions jp = new JobPositions() ;
		jp.setJobId(125);
		jp.setLocation("READING");
		jp.setClientName("HomeOffice");
		jp.setSkillsRequired("Java");
		jp.setNumberOfPositions(5);
		
		jp= jobDAO.save(jp);
		
		assertNotNull(jp,"Job Position not Saved");
	}
	
	@Test
	void testListAllJobPositions() {
		System.out.println("Print all job positions");
		for(JobPositions jp : jobDAO.findAll()) {
			System.out.println(jp);
		}
	}
	
	
	
	
	@Test
	void testCashPaymentAdd() {
		Payment cashP= new Payment();
		cashP.setAmount(100);
		
		cashP= paymentDAO.save(cashP);
		
		System.out.println(cashP);
		assertNotNull(cashP,"cash payment not saved");
	}
	
	@Test
	void testCardPaymentAdd() {
		
		CardPayment cardP= new CardPayment();
		cardP.setAmount(2300);
		cardP.setCardNumber(122321423543534543l);
		cardP.setCardService("VISA");
		
		cardP= paymentDAO.save(cardP);
		
		System.out.println(cardP);
		assertNotNull(cardP,"cash payment not saved");
	}
	
	@Test
	void testChequePaymentAdd() {
		
		chequePayment cheqP= new chequePayment();
		cheqP.setAmount(444);
		cheqP.setBankName("RBS");
		cheqP.setCheckNumber(222323);
		
		
		cheqP= paymentDAO.save(cheqP);
		
		System.out.println(cheqP);
		assertNotNull(cheqP,"Cheque payment not saved");
	}

	
	
	

	@Test
	void testEmployeeServiceExampleMethod() {
		empSvc.exampleMethod();
		
	}
	
	
	@Test
	void testEmployeeDAOAdd() {
		
		Employee emp = new Employee();
		emp.setName("new emp");
		emp.setSalary(10000);
		emp.setDesignation(Designation.MANAGER);
		
		//emp= empDAO.save(emp);
		
		System.out.println(emp);
		assertNotNull(emp,"Employee not added");
		
	}
	
	@Test
	void testFindEmployeeBySalary() {
		double minSalary= 100.0;
		double maxSalary=5000.0;
				
		 Iterable<Employee> emp = empDAO.findBySalary(minSalary,maxSalary);
		 System.out.println("All employees hving salary between min: "+minSalary+" and max: "+ maxSalary);
		 for (Employee employee : emp) {
			System.out.println(employee);
		}
		
	}
	
	@Test
	void testFindEmployeeByDesignations() {
		
		Iterable<Employee> emps = empDAO.findByDesignation(Designation.TESTER);
		
		System.out.println("All Employees wih Designation as "+ Designation.TESTER);
		
		for(Employee employee:emps) {
			System.out.println(employee);
		}
		
	}
	
	
	@Test
	void testListEmployee() {
		Iterable<Employee> emps= empDAO.findAll();
		assertNotNull(emps,"Employees not found");
		for(Employee employee: emps) {
			System.out.println(employee);
		}
	}
	
	@Test
	void testUpdateEmloyee() {
		Employee emp= empDAO.findById(1).get();
		System.out.println("employee fetched:" +emp);
		
		emp.setSalary(emp.getSalary()+1001);
		emp.setDesignation(Designation.TESTER);
		
		
		//emp= empDAO.save(emp);
		
		System.out.println("Updated employee" + emp);
				
	}
	
//	@Test
//	void testDeleteEmployee(){
//		empDAO.deleteById(10);
//	}
	

	
	@Test
	void testDepartmentServiceExampleMethod() {
		depSvc.exampleMethod();
		
	}
	
	@Test
	void testDepartmentDAOAdd() {
		
		Department dep = new Department();
		dep.setName("admin");
		dep.setLocation("Reading");
		
		
		//dep= depDAO.save(dep);
		
		System.out.println(dep);
		assertNotNull(dep,"department not added");
		
	}
	
	@Test
	void testListDepartment() {
		Iterable<Department> dep= depDAO.findAll();
		assertNotNull(dep,"department not found");
		for(Department department: dep) {
			System.out.println(department);
		}
	}
	
	@Test
	void testProjectServiceExampleMethod() {
		projSvc.exampleMethod();
		
	}
	
	@Test
	void testProjectDAOAdd() {
		
		Project proj = new Project();
		proj.setCustomerName("NHS");
		proj.setName("System 1");
		
		//proj= projectDAO.save(proj);
		
		System.out.println(proj);
		assertNotNull(proj,"Project not added");
		
	}
	
	@Test
	void testListProject() {
		Iterable<Project> proj= projectDAO.findAll();
		assertNotNull(proj,"department not found");
		for(Project project: proj) {
			System.out.println(project);
		}
	}
	
	
	
	@Test
	public void testAssignEmployeeToDepartment() {
		Employee emp= empSvc.assignEmployeeToDepartment(13,14);
		assertNotNull(emp.getCurrentDepartment(),"Department no assigned");
	}
	
	@Test 
	void testAssignEmployeeToProject() {
		Employee emp= empSvc.assignEmployeeToProject(7,21);
		assertNotNull(emp.getProjectsAssigned().size()>0,"project assigned");
	}
	
	@Test
	void testApplyForJobPosition() {
		int jobId=123;
		int empno=7;
		
		JobPositions jp = empSvc.applyForJobPosition(jobId, empno);
		
		assertNotNull(jp,"Job not Applied");
		System.out.println("Applications for JOB_ID: "+jobId);
		
		for (Employee applicant : jp.getApplicants()) {
			System.out.println(applicant);
			
		}
	}
	
	

}
