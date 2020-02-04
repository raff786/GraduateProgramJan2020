package com.mastek.training.onlineShoppingCart;

public class items {
	private String  items;
	private int numberOfItems ;
	private double unitPrice;
	
	
	
	public items(String items,int numberOfItems,double unitPrice ) {
		
		this.setItems(items);
		this.setNumberOfItems(numberOfItems);
		this.setUnitPrice(unitPrice);
		
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(int numberOfItems) {

		if (numberOfItems>0 && numberOfItems<=5) {
			this.numberOfItems = numberOfItems;
		}
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
	


	
	
	
	
	

}
