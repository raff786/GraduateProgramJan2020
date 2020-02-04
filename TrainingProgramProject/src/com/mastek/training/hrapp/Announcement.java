package com.mastek.training.hrapp;

//declare class as abstract by following rules 
//1. any one of the methods in the class is declare as abstract 
//2. if any one of the abstract method from the base class is not overridden 

public abstract class Announcement {
	
	private String from;
	private String forGroup;
	private String subject;
	private String contentText;
	
	
	//Declare the method as abstract when we want derived class to define the logic of this method/behaviour
	//we cannot declare abstract methods/classes as final
	//we cannot declare abstract method as private methods, only public of protected is allowed 
	public abstract void sendAnnouncement();
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getForGroup() {
		return forGroup;
	}
	public void setForGroup(String forGroup) {
		this.forGroup = forGroup;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContentText() {
		return contentText;
	}
	public void setContentText(String contentText) {
		this.contentText = contentText;
	}
	
	

}
