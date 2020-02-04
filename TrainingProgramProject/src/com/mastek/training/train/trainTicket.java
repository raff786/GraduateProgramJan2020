package com.mastek.training.train;

public class trainTicket {
	
	private String destination;
	private String departure;
	private double pricePerPassenger;
	private int noOfPassengers;
	private ticketType  ticketType;  
	private double totalPrice;
	
	
	public static final int DEFAULT_ZERO=0;
	public static final int MAX_PASSENGERS=5;
	public static final int DISCOUNT_RATE=2;
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public double getPricePerPassenger() {
		
		return pricePerPassenger;
	}
	public void setPricePerPassenger(double pricePerPassenger) {
		if (ticketType ==  ticketType.CHILD) {
			pricePerPassenger= pricePerPassenger/DISCOUNT_RATE;
			this.pricePerPassenger = pricePerPassenger;
		}this.pricePerPassenger = pricePerPassenger;
		
	}
	public int getNoOfPassengers() {
//		if(noOfPassengers <0 || noOfPassengers>5) {
//			noOfPassengers=DEFAULT_ZERO;
//		}
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		if(noOfPassengers>MAX_PASSENGERS ||noOfPassengers<DEFAULT_ZERO) {
			noOfPassengers=DEFAULT_ZERO;
		}this.noOfPassengers = noOfPassengers;
	}
	public ticketType getTicketType() {
		return ticketType;
	}
	public void setTicketType(ticketType ticketType) {
		
		this.ticketType = ticketType;
	}
	public double getTotalPrice() {
//		if(getNoOfPassengers()<0 || getNoOfPassengers()>5) {
//			totalPrice=DEFAULT_ZERO;
//		}
			totalPrice=getNoOfPassengers()*getPricePerPassenger();
		return totalPrice;
		
		
	}
	
	
	
	
	
}
