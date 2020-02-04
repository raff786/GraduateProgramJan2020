package com.mastek.training.packone;

//interface: a type which contains only method declarations and constants

//interfaces do not extend any existing type e.g. only 2 objects are made it doesn't inherit java.lang.object
//interfaces use class objects for implementing its behaviours 
//hence it is used frequently as it effectively saves additional number of objects created
public interface Shape {

	//no constructors in interfaces 
	//all variables are static and final
	double PI= Math.PI ;
	
	public double getArea();
	public double getPerimeter();
}
