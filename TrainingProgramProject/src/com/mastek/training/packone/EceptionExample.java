package com.mastek.training.packone;

import java.util.Scanner;

public class EceptionExample {
	public static void main(String[] args) {
		int num1=0,num2=0,num3=0, result=0;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter Num1: ");
			num1= Integer.parseInt(sc.nextLine());
			System.out.println("Enter Num2: ");
			num2= Integer.parseInt(sc.nextLine());
			
			result=num1/num2;
			System.out.println("Division is : "+result);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); //print the exception information on the console
			System.err.println("invalid number entered");
		}
		catch(Exception ex) { //it handles all type of exceptions
			System.err.println("Exception Occured: "+ex); //print exception with message
			System.err.println("Exception message: "+ex.getMessage()); //print message
			ex.printStackTrace();// print the complete information about exception::Stack trace
			
			
		}
		finally {//block will be executed in all the scenarios of success or failure,
			//in case the exception is not handled it will abort the application after the finally block
			System.out.println("Scanner closed");
			sc.close();
		}
		
		System.out.println("Prgram completed ");
		
		
	}
}
