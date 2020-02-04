package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.basics.SolutionPriovder;

class SolutionProviderTest {
	//assert <condition>(<expected-Result>,<call the function for the actual result>,
	//<Message to display if Expected Result does not match Actual result>)
	@Test
	void testGetMaxNumberValidParams() {
//		fail("Not yet implemented");
		assertEquals(10,SolutionPriovder.getMaxNumber(10, 2),"Invalid Max number retuned ");
	}
	@Test
	void testGetMaxNumberEqualParams() {
		assertEquals(100,SolutionPriovder.getMaxNumber(100, 100),"Invalid Max number retuned ");
	}
	@Test
	void testGetMaxNumberNegativeValueParams() {
		assertEquals(-150,SolutionPriovder.getMaxNumber(-150, -1288),"Invalid Max number retuned ");
	}
	@Test
	void testGetMaxNumberMaxLimitsForIntParams() {
		assertEquals(999999999, SolutionPriovder.getMaxNumber(999999999, 1288),"Invalid Max number retuned ");
	}
	
	
	@Test
	void testConvertKilometersToMiles() {
		assertEquals(6.2, SolutionPriovder.kilometersToMiles(10),"Invalid Conversion retuned ");
	}
	
	@Test
	void testCalculateArea() {
		assertEquals(25,SolutionPriovder.calulateArea(5, 5));
	}
	
	@Test
	void testTimeTaken() {
		assertEquals(1.0,SolutionPriovder.timeTaken(10, 10));
	}
	
	@Test
	void testCircleArea() {
		assertEquals(3.14,SolutionPriovder.calculateCirlceArea(1));
	}

	@Test
	void testMultiplication() {
		SolutionPriovder.multiplications(2);
	}
	@Test
	void testLowestNUmber() {
		assertEquals(5,SolutionPriovder.lowestNumber(5, 10, 18));
	}
}
