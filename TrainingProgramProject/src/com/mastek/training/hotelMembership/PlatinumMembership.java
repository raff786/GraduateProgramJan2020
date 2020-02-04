package com.mastek.training.hotelMembership;

public class PlatinumMembership extends StandardMembership {

	public static double DEFAULTZERO=0.00;


public PlatinumMembership(String name,String joiningDate,double membershipFee, double tax,MembershipDuration membershipDuration
		,ClassType classtype) {
	
	this.setName(name);
	this.setJoiningDate(joiningDate);
	this.setMembershipFee(membershipFee);
	this.setTax(tax);
	this.setMembershipDuration(membershipDuration);
	this.setClassType(classtype);
	
	
	
	
}

@Override
public void setMembershipFee(double membershipFee) {
	// TODO Auto-generated method stub
	membershipFee=0;
	super.setMembershipFee(membershipFee);
}

@Override
public double getClassPrice() {
	// TODO Auto-generated method stub
//	return DEFAULTZERO;
	if (getClassType()== ClassType.Aerobics|| getClassType()== ClassType.PersonalTraining
			||getClassType()==ClassType.Yoga|| getClassType()==ClassType.Zumba) {
		return DEFAULTZERO;
	}
	return super.getClassPrice();
}

@Override
public double getTotalPrice() {
	// TODO Auto-generated method stub
	return super.getTotalPrice();
}

}