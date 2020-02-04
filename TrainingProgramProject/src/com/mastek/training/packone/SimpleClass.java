package com.mastek.training.packone;

public class SimpleClass {

	private int privateNumber=10;
	int defualtNumber=10;
	protected int protectedNumber=10;
	public int publicNumber=10;
	
	public static void main(String[] args) {
		SimpleClass sc1 = new SimpleClass();
		//in the same class we can access all the types of members in the class
		System.out.println(
				"Private "+ sc1.privateNumber+
				"\nDefaultNumber "+sc1.defualtNumber+
				"\nProtectedNUmber "+sc1.protectedNumber+
				"\nPublic "+sc1.publicNumber);
	}
}
