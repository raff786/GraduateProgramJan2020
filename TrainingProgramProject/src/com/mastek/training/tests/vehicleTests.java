package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.Vehicle.BootSize;
import com.mastek.training.Vehicle.Colour;
import com.mastek.training.Vehicle.Condition;
import com.mastek.training.Vehicle.FuelType;
import com.mastek.training.Vehicle.Skills;
import com.mastek.training.Vehicle.TranmissionType;
import com.mastek.training.Vehicle.Vehicle;
import com.mastek.training.Vehicle.VehicleCar;
import com.mastek.training.Vehicle.VehicleMotorCycle;

class vehicleTests {

	@Test
	void testInventory() {
		Vehicle vh= new Vehicle();
		
		vh.setMake("volvo");
		vh.setModel("XC90");
		vh.setColour(Colour.Black);
		vh.setFuelType(FuelType.Diesel);
		vh.setTransmissionType(TranmissionType.Manaul);
		vh.setPrice(6999.99);
		vh.setCondition(Condition.New);
		
		System.out.println(
			"Make: "+vh.getMake()+
			"\nModel: "+vh.getModel()+
			"\nColour: "+vh.getColour()+
			"\nFuel Type: "+ vh.getFuelType()+
			"\nTransmission: "+ vh.getTransmissionType()+
			"\nPrice: "+vh.getPrice()		
				);
		
		
		assertEquals(6999.99,vh.getPrice(),"incorrect Price");
		
		
	}
	
	
	@Test
	void testdamagedcarcondition() {
		Vehicle vh1=new Vehicle("mer","c63",Colour.White,FuelType.Petrol,TranmissionType.Manaul,21000.99,Condition.damaged);
		
		assertEquals(12600.594000000001,vh1.getPrice(),"incorrect Price");
	}
	
	@Test
	void testVehicleCar() {
		VehicleCar vc= new VehicleCar("Audi","R8",Colour.Red,FuelType.Petrol,TranmissionType.Auto,50000.99,Condition.New,"S91RQ",2,2,BootSize.Small);
		System.out.println(vc.getBootsize());
		assertEquals(50000.99,vc.getPrice(),"this is the wrong price");
	}
	@Test
	void testSkillsMotorCycle() {
		Vehicle vmc=new VehicleMotorCycle("ducatti","iii21",Colour.White,FuelType.Petrol,TranmissionType.Manaul,100,Condition.used,
				"ff Nitro",Skills.aroundTheWorld);
		assertEquals(100,vmc.getPrice(),"this is the wrong price");
	}
	

}
