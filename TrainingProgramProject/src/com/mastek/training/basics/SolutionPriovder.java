package com.mastek.training.basics;

public class SolutionPriovder {

	//identify public static <return-data-type> <name of the function> (<parsmtype-1><param_name>,...)
	public static int getMaxNumber(int num1,int num2)  //declare inputs as params
	{
		int max =0; //declare output as local variable 
	    if (num1>num2) {	//validate the condiions for logical result
			max=num1;
		} else {
			max=num2;
		}
		return max;	//return the result for the calls
	}
	
	
public static void quotientAndRemainder(int num1,int num2) {
		int quotient = num1/num2;
		int remainder = num1%num2;
		
		System.out.print("the quotient is "+   quotient);
		System.out.print(" the remainder is "+   remainder + "\n");
	}

public static double kilometersToMiles (int num1) {

	double convertedMiles= num1* 0.62;
	System.out.println(convertedMiles);
	return convertedMiles;
}

public static int calulateArea (int num1,int num2) {

	if (num1==num2){
		int area =num1*num2;
		System.out.print("this is a square " + area + "\n");
		return area;	
		
	}else {
		int area = num1*num2;
		System.out.print("this is a rectangle "+ area + "\n");
		return area;
		  }
	}
	
	public static double timeTaken (double num1,double num2) {
		
		double timeTaken= num1/num2;
		System.out.print("the time taken is " + timeTaken +"\n");
		return timeTaken;
	
}
	public static double calculateCirlceArea (double num1) {
		
		double area = 3.14* (num1*num1);
		System.out.print("the area of the circle is " + area  +"\n");
		return area;
	
}
	
	public static void multiplications (int num1) {
		
		
		for (int i = 1; i <11 ; i++) {
			int answer= num1*i;
			System.out.print("the multiplications are " + answer  +"\n");
			
		}		
	
}
	public static int lowestNumber (int num1,int num2, int num3) {
	//5,2,18
		int lowest =0;
		if (num1<num2 && num1<num3) {
			lowest=num1;
			System.out.print("the lowest number is  " + lowest  +"\n");
		}
		if (num2<num1 && num2<num3) {
			lowest=num2;
			System.out.print("the lowest number is  " + lowest  +"\n");
		}
		if (num3<num1 && num3<num2) {
			lowest=num3;
			System.out.print("the lowest number is  " + lowest  +"\n");
		}
		
		return lowest;
	
	}
	
	public static void passOrFail (int mark1,int mark2, int mark3) {
		
		int total_percentage= (mark1+mark2+mark3)/100; 
		if(total_percentage<50) {
			System.out.println("failed");
		}System.out.println("failed");
	
	}
	
	
	
	
	
	

}



