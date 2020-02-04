package com.mastek.training.myshop;

public class Item implements Comparable<Item> // it provides the default sorting for treeSet
{
	

	private int itemID;
	private String itemName;
	private int itemQuantity;
	private double unitPrice;
	
	
	public Item() {
		
	}
	
	
	public Item(int itemId) {
		setItemID(itemId);
	}
	
	public Item(int itemId, String itemName, double unitPrice, int itemQuantity) {
		
		setItemID(itemId);
		setItemName(itemName);
		setUnitPrice(unitPrice);
		setItemQuantity(itemQuantity);
		
		// TODO Auto-generated constructor stub
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity + ", unitPrice="
				+ unitPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemID;
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
		Item other = (Item) obj;
		if (itemID != other.itemID)
			return false;
		return true;
	}


	//treeSet uses compareto for default order
	@Override
	public int compareTo(Item anotherItem) {
		//return a number 
		//if it is positive then it means the current object is greater than another item
		//if its 0 then it means the current object is equal to another item
		//if its negative it means the current object is less than another item
		//System.out.println("Comparing Items : ");
		return this.getItemID()-anotherItem.getItemID();
		//we all need to compare unique/key values for managing order
	}
	
	

	
	
	
	
}
