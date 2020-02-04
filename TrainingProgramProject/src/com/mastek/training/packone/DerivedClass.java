package com.mastek.training.packone;

public class DerivedClass extends SimpleClass {
	
	public static void main(String[] args) {
		SimpleClass sc1 = new DerivedClass();
		//in the derived class, of the same package we can access all the types of members in the class except private
		System.out.println(
				//"Private "+ sc1.privateNumber+
				"\nDefaultNumber "+sc1.defualtNumber+
				"\nProtectedNUmber "+sc1.protectedNumber+
				"\nPublic "+sc1.publicNumber);
	}

}
