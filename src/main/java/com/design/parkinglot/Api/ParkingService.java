package com.design.parkinglot.Api;

import com.design.parkinglot.dtos.ParkingSpace;

public interface ParkingService {

	void park(String regNum, String color, ParkingStrategy parkingStrategy);

	void unPark(String regNum);
	
	void createBuilding(Integer numberOfParkings);
}
