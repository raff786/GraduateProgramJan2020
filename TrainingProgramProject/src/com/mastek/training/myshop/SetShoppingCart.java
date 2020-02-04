package com.mastek.training.myshop;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetShoppingCart implements ShoppingCart<Item> {
	
	
	Set<Item>items;
	
	public SetShoppingCart() {
		//items= new HashSet<>(); //using hash set to manage unique items in random order
		items= new TreeSet<>(); //using tree set to store items in a sorted order
	}
	
	

	@Override
	public int addItem(Item i) {
		items.add(i);
		return items.size();
				
	}

	@Override
	public int removeItem(Item i) {
		items.remove(i);
		return items.size();
	}

	@Override
	public void printItemList() {
		System.out.println("Items in the cart: ");
		for (Item item : items) {
			System.out.println(item);
		}

	}

	@Override
	public double getTotalPrice(double taxPercentage, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
