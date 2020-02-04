package com.mastek.training.hotelMembership;

public class StandardMembership {

		private String name;
		private String joiningDate;	
		private double membershipFee;
		private double tax;
		private MembershipDuration membershipDuration;
		private ClassType classType;
		private double TotalPrice;
		private double ClassPrice;
		
		
		public static int MONTHLYMEMBERSHIP =1;
		public static int SIXMONTHMEMBERSHIP =6;
		public static int YEARLYMEMBERSHIP=12;
		public static double YOGA=4.99;
		public static double AEROBICS=5.99;
		public static double ZUMBA = 10.50;
		public static double PERSONALTRAINING =25.00;
		
		
		
		public StandardMembership(String name,String joiningDate,double membershipFee, double tax,MembershipDuration membershipDuration
				,ClassType classtype) {
			
			this.setName(name);
			this.setJoiningDate(joiningDate);
			this.setMembershipFee(membershipFee);
			this.setTax(tax);
			this.setMembershipDuration(membershipDuration);
			this.setClassType(classtype);
			
			System.out.println("standard membership has been created");
			
			
		}
		
		public StandardMembership() {
			
			this.setName(name);
			this.setClassType(classType);
			
			System.out.println("this is the default constructor");
			
			
		}
		
		public StandardMembership(String name,ClassType classType) {
			this.setName(name);
			this.setClassType(classType);
			
			System.out.println("this is the 2nd constructor");
		}
		
		
		
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getJoiningDate() {
			return joiningDate;
		}
		public void setJoiningDate(String date) {
			this.joiningDate = date;
		}
		public double getMembershipFee() {
			return membershipFee;
		}
		public void setMembershipFee(double membershipFee) {
			this.membershipFee = membershipFee;
		}
		public double getTax() {
			return tax;
		}
		public void setTax(double tax) {
			this.tax = tax;
		}
		public ClassType getClassType() {
			return classType;
		}
		public void setClassType(ClassType classType) {
			this.classType = classType;
		}
		public double getClassPrice() {
			if (getClassType()==ClassType.Aerobics) {
				return ClassPrice=AEROBICS;
			}if (getClassType()==ClassType.PersonalTraining) {
				return ClassPrice=PERSONALTRAINING;
			}if (getClassType()==ClassType.Yoga) {
				return ClassPrice=YOGA;
			}if (getClassType()==ClassType.Zumba) {
				return ClassPrice=ZUMBA;
			}
			else return ClassPrice;
				
		}
		public MembershipDuration getMembershipDuration() {
			return membershipDuration;
		}
		public void setMembershipDuration(MembershipDuration membershipDuration) {
			this.membershipDuration = membershipDuration;
		}
		public double getTotalPrice() {
			if(getMembershipDuration()==MembershipDuration.Monthly) {
				
				return TotalPrice =(getMembershipFee()*MONTHLYMEMBERSHIP)+getClassPrice()+ getTax();
			}else if(getMembershipDuration()== MembershipDuration.sixMonths) {
				return TotalPrice =(getMembershipFee()*SIXMONTHMEMBERSHIP)+ getClassPrice()+ getTax();
			}else 
			
				return TotalPrice = (getMembershipFee()*YEARLYMEMBERSHIP)+getClassPrice()+ getTax();
		
		}
		
		
		
		
	
}
