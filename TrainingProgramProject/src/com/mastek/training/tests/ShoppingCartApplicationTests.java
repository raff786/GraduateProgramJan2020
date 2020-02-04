package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.myshop.Item;
import com.mastek.training.myshop.ListShoppingCart;
import com.mastek.training.myshop.MapShoppingCart;
import com.mastek.training.myshop.SetShoppingCart;
import com.mastek.training.myshop.ShoppingCart;

class ShoppingCartApplicationTests {
	ShoppingCart<Item> sc;

	@BeforeEach
	void setUp() throws Exception {
		//sc= new ListShoppingCart();  //  list example
		//sc= new SetShoppingCart();  //set example
		sc= new MapShoppingCart(); // Map Example
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		sc=null;
	}

	@Test
	void testShoppingCartAddItem() {
		
		
		int size = sc.addItem(new Item(1,"name", 233.0,1));
		assertEquals(1, size,"Item Added");
	}
	
	@Test
	void testShoppingCartPrintItem() {
		
		 sc.addItem(new Item(4,"item 3", 2233.0,1));
		 sc.addItem(new Item(1,"item 1", 233.0,1));
		 sc.addItem(new Item(1,"item 2", 1233.0,1));
		 sc.addItem(new Item(2,"item 2", 1233.0,1));
		 sc.addItem(new Item(2,"item 3", 2233.0,1));
		 sc.addItem(new Item(2,"item 3", 2233.0,1));
		 sc.addItem(new Item(18,"item 2", 1233.0,1));

		
		sc.printItemList();
	}
	
	
	@Test
	void testShoppingCartRemoveItem() {
		
		
		 sc.addItem(new Item(1,"item 1", 233.0,1));
		 sc.addItem(new Item(2,"item 2", 1233.0,1));
		 sc.addItem(new Item(2,"item 3", 2233.0,1));


		int size = sc.removeItem(new Item (2));
		sc.printItemList();
		
		assertEquals(1, size,"item removed");
		
		
		
	}

}
