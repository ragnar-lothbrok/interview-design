package com.design.parkinglot.Impl;

import com.design.parkinglot.Api.ParkingStrategy;
import com.design.parkinglot.dtos.Building;

public class FCFSParking implements ParkingStrategy {

	public synchronized String getBuilding() {
		ParkingServiceImpl parkingServiceImpl = (ParkingServiceImpl) ParkingServiceImpl.getParkingService();
		if (parkingServiceImpl.getList().size() > 0) {
			for (int i = 0; i < parkingServiceImpl.getList().size(); i++) {
				Building building = parkingServiceImpl.getList().get(i);
				if (building.isSpaceAvailable()) {
					return building.getBuildingNumber();
				}
			}
		}
		return null;
	}

}
