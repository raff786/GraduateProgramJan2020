package com.mastek.training.Vehicle;

public class VehicleCar extends Vehicle {

	private String numberPlate;
	private int numberOfDoors;
	private int numberOfSeats;
	private BootSize bootsize;
	
	
	
	
	public VehicleCar(String make, String model, Colour colour, FuelType fuelType, TranmissionType transmissionType, double price,
			Condition condition, String numberPlate, int noOfDoors, int noOfSeats, BootSize bootsize) {
		System.out.println("inside the constructor");
		this.setMake(make);
		this.setModel(model);
		this.setColour(colour);
		this.setFuelType(fuelType);
		this.setTransmissionType(transmissionType);
		this.setPrice(price);
		this.setCondition(condition);
		this.setNumberPlate(numberPlate);
		this.setNumberOfDoors(noOfDoors);
		this.setNumberOfSeats(noOfSeats);
		this.setBootsize(bootsize);
		System.out.println("the boot is " +getBootsize());
		
	}



	public String getNumberPlate() {
		return numberPlate;
	}




	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}




	public int getNumberOfDoors() {
		return numberOfDoors;
	}




	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}




	public int getNumberOfSeats() {
		return numberOfSeats;
	}




	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}




	public BootSize getBootsize() {
		return bootsize;
	}




	public void setBootsize(BootSize bootsize) {
		this.bootsize = bootsize;
	}




	
	
}
