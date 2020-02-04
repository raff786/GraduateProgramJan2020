package com.mastek.training.Vehicle;

public class Vehicle {

	private String make;
	private String model;
	private Colour colour;
	private FuelType fuelType;
	private TranmissionType transmissionType;
	private double price;
	private Condition condition;
	
	
	
	public static double DAMAGEDDISCOUNT=0.6;
	public static double USEDDISCOUNT=0.5;
	
	
	public Vehicle() {
		System.out.println("inside the default constructor");
	}
	public Vehicle(String make,String model,Colour colour,FuelType fuelType,TranmissionType transmissionType,double price,Condition condition) {
		System.out.println("inside the constructor");
		this.setMake(make);
		this.setModel(model);
		this.setColour(colour);
		this.setFuelType(fuelType);
		this.setTransmissionType(transmissionType);
		this.setPrice(price);
		this.setCondition(condition);
		System.out.println("the make is " +getMake());
	}
	
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Colour getColour() {
		return colour;
	}
	public void setColour(Colour colour) {
		this.colour = colour;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	public TranmissionType getTransmissionType() {
		return transmissionType;
	}
	public void setTransmissionType(TranmissionType transmissionType) {
		this.transmissionType = transmissionType;
	}
	public double getPrice() {   
		if(Condition.used== getCondition()) {
			double conditionPrice = price *USEDDISCOUNT;
			return conditionPrice;
		}else if(Condition.damaged==getCondition()) {
			double conditionPrice= price* DAMAGEDDISCOUNT ;
			return conditionPrice;
		}else 
		
		return price;
	}
	public void setPrice(double price) {
		this.price=price;
		
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	

}
