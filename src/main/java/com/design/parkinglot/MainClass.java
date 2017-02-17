package com.design.parkinglot;

import java.awt.Color;
import java.util.UUID;

import com.design.parkinglot.Impl.FCFSParking;
import com.design.parkinglot.Impl.ParkingServiceImpl;
import com.design.parkinglot.Impl.RoundRobinParking;

public class MainClass {

	
	static Color []colors = new Color[]
			{
			    Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN,
			    Color.BLACK, Color.PINK, Color.ORANGE
			};
	public static void main(String[] args) {

		ParkingServiceImpl parkingServiceImpl = (ParkingServiceImpl) ParkingServiceImpl.getParkingService();
		for (int i = 0; i < 3; i++) {
			parkingServiceImpl.createBuilding(10);
		}

		RoundRobinParking RoundRobinParking = new RoundRobinParking();
		FCFSParking FCFSParking =new FCFSParking();
		for (int i = 0; i < 31; i++) {
			parkingServiceImpl.park(UUID.randomUUID().toString(), colors[i%colors.length].toString(), FCFSParking);
		}
	}
}
