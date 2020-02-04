package com.mastek.training.hrapp;

public class EmailAnnouncement extends Announcement {

	@Override
	public void sendAnnouncement() {
		// TODO Auto-generated method stub

		System.out.println("sending email to "+ getForGroup()+" By "+getFrom()+
				" with title "+ getSubject()+ " and text : "+getContentText());
	}

}
