package com.mastek.training.onlineShoppingCart;

public class shoppingCart {
	//private String item[];
	private items item [];
	private int tax;
	private String giftCard;
	
	
	public items[] getItem() {
		return item;
	}
	public void setItem(items[] item) {
		this.item = item;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public String getGiftCard() {
		return giftCard;
	}
	public void setGiftCard(String giftCard) {
		this.giftCard = giftCard;
	}
	
	


	
	
	
	
	

	
	
	
	
//	public double getGrandPriceWithTax() {
//		double taxOnItems= ((pricePerItem*noOfItems)/100)*tax;
//		return (pricePerItem*noOfItems)+taxOnItems;
//	}
	
//public double getGrandPrice() {
//		
//		return (pricePerItem*noOfItems);
//	}

}
