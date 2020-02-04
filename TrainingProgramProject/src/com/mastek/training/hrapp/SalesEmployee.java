package com.mastek.training.hrapp;

public class SalesEmployee extends Employee {//each class specifies their base/parent class by using extends keyword
	
	private long target;
	private double commission ;
	
	
	public SalesEmployee() {  //use super keywordto call the base class constructor from the child/derived class
		super(7777,"salesExample",99,Designations.OFFICER,Grades.G4);
		System.out.println("Sales Employee Created");
	}
	
	
	//method overriding is when you write the same method from baseclass in the child class with different logic or prosessing
	@Override
	public double getNetSalary(int noOfDays)throws Exception {
		
		return (super.getNetSalary(noOfDays)+(super.getNetSalary(noOfDays)*getCommission()));
	}

	public long getTarget() {
		return target;
	}
	public void setTarget(long target) {
		this.target = target;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	
	
	

}
