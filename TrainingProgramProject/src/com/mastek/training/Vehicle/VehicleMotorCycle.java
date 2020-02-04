package com.mastek.training.Vehicle;

public class VehicleMotorCycle extends Vehicle {
	
	private String nitro;
	private Skills skill;
	
	public static double AROUNDTHEWORLDPRICE= 2;
	
	public VehicleMotorCycle(String make, String model, Colour colour, FuelType fuelType, TranmissionType transmissionType, double price,
			Condition condition, String nitro,Skills skill) {
		this.setMake(make);
		this.setModel(model);
		this.setColour(colour);
		this.setFuelType(fuelType);
		this.setTransmissionType(transmissionType);
		this.setPrice(price);
		this.setCondition(condition);
		this.setnitro(nitro);
		this.setSkill(skill);
		
		
	}

	
	public String getnitro() {
		return nitro;
	}




	public void setnitro(String nitro) {
		this.nitro = nitro;
	}
	
	
	public Skills getSkill() {
		
		return skill;
	}


	public void setSkill(Skills skill) {
		this.skill = skill;
	}


	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		if(Skills.aroundTheWorld==getSkill()) {
			return super.getPrice()*AROUNDTHEWORLDPRICE;
		} 
		else {                           //cannot check if skill will be somethingelse
			return super.getPrice();
		}
	}


	
	
	
		
	
}
