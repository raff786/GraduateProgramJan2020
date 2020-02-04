package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.onlineShoppingCart.items;
import com.mastek.training.onlineShoppingCart.shoppingCart;

class OnlineShoppingCartTest {

	shoppingCart c;
	items[] i;

	@BeforeEach
	void setUp() throws Exception {
		c= new shoppingCart();
		items i[] = new items[10];
		i[3]= new items("T-Shirt", 2, 1.99);
		//System.out.println("Before Test");
		c.setItem(i);
		c.setTax(20);
		c.setGiftCard("Black");
	
		
	}

	@AfterEach
	void tearDown() throws Exception {
		//System.out.println("After Test");
	}

//	@Test
//	void testDisplayItemDetails() {
//		System.out.println(
//				"New Item: "+ c.getNewItem()+
//				"\nPrice: "+ c.getPricePerItem()+
//				"\nquantity: "+ c.getNoOfItems()+
//				"\nGrand Total: "+ c.getGrandPrice()+
//				"\nGrand Total including tax: "+ c.getGrandPriceWithTax()
//				);
//}
	
	@Test
	void testNoOfItemsPerOrder() {
		//assertEquals(2, c.getNoOfItems(),"Please check Number of items again");
		//assertEquals(6, c.getNoOfItems(),"Please check Number of items again");
	}
	
	
//	Create a class structure for online shopping cart, to add Items, remove, view items and print grand total, apply tax [20%] , apply Giftcode{['Black']:50% off}
//	Item details: item name , quantity and unit price with max of 10 items per order

}
