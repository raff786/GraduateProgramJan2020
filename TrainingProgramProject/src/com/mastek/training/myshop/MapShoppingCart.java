package com.mastek.training.myshop;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapShoppingCart implements ShoppingCart<Item> {

	Map<Integer, Item> items;
	
	public MapShoppingCart() {
		//items= new HashMap<>(); maintain random entries for the collection
		
		items = new TreeMap<>();//treeMap sorts all the entries using key value pairs
	}
	
	
	@Override
	public int addItem(Item i) {
		items.put(i.getItemID(), i);//map.put(key,value)
		return items.size();
	}

	@Override
	public int removeItem(Item i) {
		items.remove(i.getItemID()); //map.remove(key)
		return items.size();
	}

	@Override
	public void printItemList() {
		System.out.println("items in cart");
		for (Integer itemId:items.keySet()) { //get all the keys from the map
			Item i= items.get(itemId); //gets the value from the map using key
			System.out.println(i);
			
		}

	}

	@Override
	public double getTotalPrice(double taxPercentage, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
