package com.mastek.training.hrapp;

import java.io.Serializable;
import java.io.StringReader;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

import org.bson.Document;
import org.glassfish.json.JsonParserImpl;
//if the class is declared as final is stops inheritance. e.g. public class Employee
public  class Employee implements Serializable{
					// we are using Serializable as marker interface to manage Serializable using 
					//ObjectOutput/InputStream classes 
	private int empno;
	private String name;
	private double unitDaySalary;
	private Designations designation;
	private transient Grades grade;  //transient keyword will denote the serializer to skip this field while storing using binary files
	
	public static final int MAX_PAID_DAYS=90;
	public static final int MIN_DAY_RATE=10;
	public static final int MAX_DAY_RATE=999999;
	public static final int DEFAULT_ZERO=0;
	public static final int MAX_EMPNO=999999;
	
	
	//blocks
	//static Block: executed at class loading time for each class
	
	static {// we use static block to initialise all the static members of the class 
		System.out.println("Employee Static Block Called ");
	}
	
	//instance block: executed before the constructor is called for any object of the class
	
	{
		setEmpno(999);
		setName("example");
		setUnitDaySalary(MIN_DAY_RATE);
		setDesignation(designation.OTHER);
		setGrade(Grades.G12);
		System.out.println("Employee instance Block called");
	}
	
	
	
	
	//default constructor, this doesn't need to have any arguments 
	
	public Employee() {
		System.out.println("Employee default constructor called");
		System.out.println("eno: "+ getEmpno()+", name: "+getName()+", unit salary: "
						+getUnitDaySalary()+", designation: "+getDesignation()+ ", grade: "+ getGrade());
	}
	
	
	public Employee(int empno) { //method/construtor Overloading. this is when you define same method/constructor with different number/types as parameters
		this.setEmpno(empno);
		System.out.println("Employee constructor called with empno: "+ empno);
		System.out.println("eno: "+ getEmpno()+", name: "+getName()+", unit salary: "
				+getUnitDaySalary()+", designation: "+getDesignation()+ ", grade: "+ getGrade());
	}
	public Employee(int empno,String name,double unitDaySalary,Designations designations,Grades grade) {
		this.setEmpno(empno);
		this.setName(name);
		this.setUnitDaySalary(unitDaySalary);
		this.setDesignation(designations);
		this.setGrade(grade);
		System.out.println("master constructor called");
		System.out.println("eno: "+ getEmpno()+", name: "+getName()+", unit salary: "
				+getUnitDaySalary()+", designation: "+getDesignation()+ ", grade: "+ getGrade());
		
		
	}
	
	
	public void finalize() { //this internal method is called by garbage collector before deleting the object
		//you can notify to collect the garbage using System.gc();
		setEmpno(0);
		setName(null);
		setUnitDaySalary(0);
		setDesignation(null);
		setGrade(null);
		System.out.println("Employee object finalized");
	}
	
	
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		if (empno>DEFAULT_ZERO &&empno< MAX_EMPNO) {
			
		this.empno = empno;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitDaySalary() {
		
		return unitDaySalary;
	}
	public void setUnitDaySalary(double unitDaySalary) {
		if (unitDaySalary>DEFAULT_ZERO&&unitDaySalary<MAX_DAY_RATE) {
		this.unitDaySalary = unitDaySalary;
		}
	}
	public Designations getDesignation() {
		return designation;
	}
	public void setDesignation(Designations designation) {
		this.designation = designation;
	}
	public Grades getGrade() {
		return grade;
	}
	public void setGrade(Grades grade) {
		this.grade = grade;
	}
	
	//final can be used on methods, final stops overriden in the child class e.g. public final double getNetSalary
	public double getNetSalary(int noOfDays) throws Exception {
		if(noOfDays<DEFAULT_ZERO) {
			//raises an exception on the condition
			throw new Exception("Invalid Input for Days "+ noOfDays);
			//throw new RuntimeException("Invalid Input for Days "+ noOfDays);
			//the runtimeexception raises an unchecked excetion 
		}
		if (noOfDays<DEFAULT_ZERO || noOfDays>MAX_PAID_DAYS) {
			noOfDays=DEFAULT_ZERO;
		}
		return getUnitDaySalary()*noOfDays;
	}


	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", unitDaySalary=" + unitDaySalary + ", designation="
				+ designation + ", grade=" + grade + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empno;
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
		Employee other = (Employee) obj;
		if (empno != other.empno)
			return false;
		return true;
	}
	
	//get json 
public static String getJSONString(Employee emp) {
	JsonObjectBuilder jsonBuilder = new JsonObjectBuilder();
	jsonBuilder.add("empno", emp.getEmpno());
	jsonBuilder.add("name", emp.getName());
	jsonBuilder.add("day-salary", emp.getUnitDaySalary());
	jsonBuilder.add("designation", emp.getDesignation().toString());
	jsonBuilder.add("grade", emp.getGrade().toString());
	
	String jsonEmp= jsonBuilder.build().toString();
	System.out.println(jsonEmp);
	return jsonEmp;
	
}
	
public static Employee parseJSONString (String empJSON) {
	JsonReader reader = new JsonReader(new StringReader(empJSON));
	JsonObject empJSONObject= reader.readObject();
	
	Employee emp = new Employee();
	emp.setEmpno(empJSONObject.getIntValue("empno"));
	emp.setName(empJSONObject.getStringValue("name"));
	emp.setUnitDaySalary(empJSONObject.getIntValue("day-salary"));
	emp.setGrade(Grades.valueOf(empJSONObject.getStringValue("grade")));
	emp.setDesignation(Designations.valueOf(empJSONObject.getStringValue("designation")));
	
	System.out.println("From JSON "+ empJSON);
	System.out.println("To Emp:  "+ emp);
	
	reader.close();
	return emp;
}


public static Document getEmployeeMonogoDocument(Employee emp) {
	Document docEmp = new Document();
	docEmp.put("empno", emp.getEmpno());
	docEmp.put("name", emp.getName());
	docEmp.put("unit_salary", emp.getUnitDaySalary());
	docEmp.put("grade", emp.getGrade().toString());
	docEmp.put("designation", emp.getDesignation().toString());
	
	return docEmp;
			
}

public static Employee getEmployeeFromMongoDocument(Document empDoc) {
	Employee emp = new Employee();
	try {
	
	emp.setEmpno(empDoc.getInteger("empno"));
	emp.setName(empDoc.getString("name"));
	emp.setUnitDaySalary(empDoc.getDouble("unit_salary"));
	emp.setGrade(Grades.valueOf(empDoc.getString("grade")));
	emp.setDesignation(Designations.valueOf(empDoc.getString("designation")));
	}
	catch(Exception ex) {
		emp=null;
	}
	return emp;
	
}





	

}
