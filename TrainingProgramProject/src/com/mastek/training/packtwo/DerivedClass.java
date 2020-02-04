package com.mastek.training.packtwo;

import com.mastek.training.packone.SimpleClass;

public class DerivedClass extends SimpleClass {
	
	public static void main(String[] args) {
		DerivedClass sc1 = new DerivedClass();
		//in the derived class, of the same package we can only access public and protected members in the class except private
		System.out.println(
				//"Private "+ sc1.privateNumber+
				//"\nDefaultNumber "+sc1.defualtNumber+
				"\nProtectedNUmber "+sc1.protectedNumber+
				"\nPublic "+sc1.publicNumber);
	}

}
