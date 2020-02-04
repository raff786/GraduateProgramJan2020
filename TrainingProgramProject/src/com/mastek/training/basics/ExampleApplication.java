package com.mastek.training.basics;

public class ExampleApplication {

	public static void main(String[] args) {
		int maxResult =0;
		
		maxResult = SolutionPriovder.getMaxNumber(10, 2);
		System.out.println("Max result is " + maxResult);
		
		maxResult = SolutionPriovder.getMaxNumber(100, 100);
		System.out.println("Max result is " + maxResult);
		
		maxResult = SolutionPriovder.getMaxNumber(-150, -1288);
		System.out.println("Max result is " + maxResult);
		
		maxResult = SolutionPriovder.getMaxNumber(999999999, -1288);
		System.out.println("Max result is " + maxResult);
	}
}
