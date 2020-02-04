package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import com.mastek.training.hotelMembership.ClassType;
import com.mastek.training.hotelMembership.MembershipDuration;
import com.mastek.training.hotelMembership.PlatinumMembership;
import com.mastek.training.hotelMembership.StandardMembership;

public class HotelMembershipTests {
	StandardMembership sm ;

	@Test
	public void TestdisplayStandardMembership() {
		 sm = new StandardMembership("Atiq","12/12/2019",10,10,MembershipDuration.Monthly,ClassType.Aerobics );
		
		System.out.println(
				"name: "+sm.getName()+
				"\nJoiningDate: "+sm.getJoiningDate()					
					);
		
		
		assertEquals("Atiq",sm.getName(),"Incorrect Name");  // why its showing null as actual
		
	}
	@Test
	public void TestdisplayNameAndClasType() {
		StandardMembership sm1 = new StandardMembership();
		sm1.setName("rob");
		sm1.setClassType(ClassType.Yoga);
		
		System.out.println(
				"name: "+sm1.getName()+
				"\nclass type: "+sm1.getClassType()					
					);
		
		
		
		
		assertEquals("rob",sm1.getName(),"Incorrect Name");  // why its showing null as actual
		
	}
	
	@Test
	public void TestdisplayNameAndClasType2nd() {
		StandardMembership sm2 = new StandardMembership("rob2",ClassType.Yoga);
		
		System.out.println(
				"name: "+sm2.getName()+
				"\nclass type: "+sm2.getClassType()					
					);
		
		
		
		
		assertEquals("rob2",sm2.getName(),"Incorrect Name");  // why its showing null as actual
		
	}
	@Test
	public void TestGetTotalPrice() {
		StandardMembership sm3 = new StandardMembership("Atiq","12/12/2019",10,10,MembershipDuration.sixMonths,ClassType.Aerobics );
		
		System.out.println(
				"total Price " + sm3.getTotalPrice()+
				"tax "+sm3.getTax());
		
		
		assertEquals(75.99,sm3.getTotalPrice(),"Incorrect price");  // why its showing null as actual
		
	
	}
	@Test
	public void TestGetTotalPricePlatinum() {
	PlatinumMembership pm= new PlatinumMembership("Atiq","12/12/2019",10,10,MembershipDuration.sixMonths,ClassType.Aerobics );
		System.out.println(
			"\ntotal Price for platinum " + pm.getTotalPrice()+
			"\ntax "+pm.getTax());
		assertEquals(75.99,pm.getTotalPrice(),"Incorrect price");  // not showing the correct platinum price
	
	}
		
	
}
