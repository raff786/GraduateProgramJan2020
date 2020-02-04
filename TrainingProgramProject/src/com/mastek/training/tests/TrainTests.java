package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.train.ticketType;
import com.mastek.training.train.trainTicket;

class TrainTests {

	trainTicket  tt;
	
	@BeforeEach
public void setUpTrainTicketCase() {
		System.out.println("Before Test");
		tt = new trainTicket();
		tt.setDestination("Leeds");
		tt.setDeparture("Meadowhall");
		tt.setNoOfPassengers(1);
		tt.setTicketType(ticketType.CHILD);
		tt.setPricePerPassenger(10.00);
		
		
		
	}
	
	
	
	@AfterEach
	public void tearDownTrainTicketCase() {
		System.out.println("After Test");
	}
	
	
	@Test
	void showTrainTickets() {
//		trainTicket tt = new trainTicket();
//		tt.setDestination("Leeds");
//		tt.setDeparture("Meadowhall");
//		tt.setPricePerPassenger(10.00);
//		tt.setNoOfPassengers(6);
//		tt.setTicketType("child");
//		
		
		System.out.println(
				
			"Destination Station: "+ tt.getDestination()+
			"\nDeparture Station: "+ tt.getDeparture()+
			"\nPrice Per Passenger: " + tt.getPricePerPassenger()+
			"\nNo Of Passengers: " + tt.getNoOfPassengers()+
			"\nTicket Type: " + tt.getTicketType()+
			"\nTotal Price: " + tt.getTotalPrice()	
				);

		
	}
	
	@Test
	void checkChildTickets() {
		assertEquals(5.0, tt.getPricePerPassenger(),"wrong ticket price shown");
	
		
	}
	
	@Test
	void maxTicketCheck() {
		assertEquals(1, tt.getNoOfPassengers(),"wrong number of passengers entered");
		//assertEquals(0, tt.getNoOfPassengers(),"wrong number of passengers entered");  //would i need to do this check
		
	}

}


//create a class structure for train ticket booking with from and to station
//price for each passenger, 50% off if passenger is child max 5 passengers for each ticket


