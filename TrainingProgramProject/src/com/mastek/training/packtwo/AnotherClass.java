package com.mastek.training.packtwo;

import com.mastek.training.packone.SimpleClass;

public class AnotherClass {
	public static void main(String[] args) {
		SimpleClass sc1 = new SimpleClass();
		//in another class, of another package we can only access all public members of the class except private
		System.out.println(
				//"Private "+ sc1.privateNumber+
				//"\nDefaultNumber "+sc1.defualtNumber+
				//"\nProtectedNUmber "+sc1.protectedNumber+
				"\nPublic "+sc1.publicNumber);
	}

}
