package com.mastek.training.hrapp;

public class SMSAnnouncement extends Announcement {

	//Each derived class of the bas abstract class must override all abstract methods from the methods
	@Override
	public void sendAnnouncement() {
		// TODO Auto-generated method stub
		
		System.out.println("sending sms to "+ getForGroup()+" By "+getFrom()+
				" with title "+ getSubject()+ " and text : "+getContentText());

	}

}
