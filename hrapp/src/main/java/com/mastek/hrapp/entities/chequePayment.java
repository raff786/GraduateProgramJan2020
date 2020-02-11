package com.mastek.hrapp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="JPA_TABLE_PER_CLASS_CHEQUE_PAYMENT")//defined the table 
public class chequePayment extends Payment{
	
	int checkNumber;
	String bankName;
	
	
	public int getCheckNumber() {
		return checkNumber;
	}
	public void setCheckNumber(int checkNumber) {
		this.checkNumber = checkNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Override  //use inherit fields for toString aswell as normal fields
	public String toString() {
		return "chequePayment [checkNumber=" + checkNumber + ", bankName=" + bankName + ", paymentId=" + paymentId
				+ ", amount=" + amount + "]";
	}
	
	
	

}
