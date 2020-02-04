package com.mastek.training.passport;

import java.io.Serializable;
import java.io.StringReader;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.glassfish.json.JsonParserImpl;

import com.mastek.training.hrapp.Employee;

public class PassportApplication implements Serializable{
	private int passportID;
	private String firstName;
	private String surName;
	private String dateOfBirth;
	private String nationality;
	private String placOfBirth;
	private Sex sex;
	
	public PassportApplication(){
		
	}
	
	public int getPassportID() {
		return passportID;
	}
	public void setPassportID(int passportID) {
		this.passportID = passportID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPlacOfBirth() {
		return placOfBirth;
	}
	public void setPlacOfBirth(String placOfBirth) {
		this.placOfBirth = placOfBirth;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "PassportApplication [passportID=" + passportID + ", firstName=" + firstName + ", surName=" + surName
				+ ", dateOfBirth=" + dateOfBirth + ", nationality=" + nationality + ", placOfBirth=" + placOfBirth
				+ ", sex=" + sex + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + passportID;
		result = prime * result + ((placOfBirth == null) ? 0 : placOfBirth.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassportApplication other = (PassportApplication) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		if (passportID != other.passportID)
			return false;
		if (placOfBirth == null) {
			if (other.placOfBirth != null)
				return false;
		} else if (!placOfBirth.equals(other.placOfBirth))
			return false;
		if (sex != other.sex)
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		return true;
	}
	
	public static String getJSONString(PassportApplication newD) {
		JsonObjectBuilder jsonBuilder = new JsonObjectBuilder();
		jsonBuilder.add("passportid", newD.getPassportID());
		jsonBuilder.add("firstName", newD.getFirstName());
		jsonBuilder.add("surName", newD.getSurName());
		jsonBuilder.add("dateOfBirth", newD.getDateOfBirth());
		jsonBuilder.add("nationality", newD.getNationality());
		jsonBuilder.add("placeOfBirth", newD.getPlacOfBirth());
		jsonBuilder.add("sex", newD.getSex().toString());
		
		String jsonEmp= jsonBuilder.build().toString();
		System.out.println(jsonEmp);
		return jsonEmp;
		
	}
	



	
	
	
	
	

}
