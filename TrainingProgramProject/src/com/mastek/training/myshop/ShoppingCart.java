package com.mastek.training.myshop;

//using generic type interface
//Type <I>: the I would be defined at usage time with type of class
public interface ShoppingCart<I> {

	public int addItem(I i);
	public int removeItem(I i);
	public void printItemList();
	public double getTotalPrice(double taxPercentage, double discountPercentage);
	
	
}
