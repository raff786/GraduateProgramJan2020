package com.mastek.training.packone;

//a class can inherit from interfaces using implements keyword
//one class can implement more than one interfaces
public class Rectangle implements Shape {

	private int length;
	private int breadth;
	
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	@Override
	public double getArea() {
	
		return getLength()*getBreadth();
			}
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*(getLength()+getBreadth());
	}
	
}
