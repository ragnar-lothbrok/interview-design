package com.design.parkinglot.dtos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Building {

	private List<ParkingSpace> vacantParkingSpaces;

	private List<ParkingSpace> occupiedParkingSpaces;

	private String buildingNumber;

	public Building(String buildingNumber, Integer parkingSpaceCount) {
		this.buildingNumber = buildingNumber;
		vacantParkingSpaces = new ArrayList<ParkingSpace>(parkingSpaceCount);
		for (int i = 0; i < parkingSpaceCount; i++) {
			ParkingSpace ps = new ParkingSpace(buildingNumber);
			vacantParkingSpaces.add(ps);
		}
		occupiedParkingSpaces = new ArrayList<ParkingSpace>();
	}

	public Boolean isSpaceAvailable() {
		return vacantParkingSpaces.size() != 0;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public ParkingSpace getParkingSpace(Vehicle vehicle) {
		ParkingSpace parkingSpace = null;
		if (vacantParkingSpaces.size() != 0) {
			parkingSpace = vacantParkingSpaces.get(0);
			parkingSpace.setVehicle(vehicle);
			parkingSpace.setVehiclePresent(true);
			occupiedParkingSpaces.add(parkingSpace);
			vacantParkingSpaces.remove(0);
		}
		return parkingSpace;
	}

	public Vehicle leaving(ParkingSpace parkingSpace) {
		Vehicle vehicle = null;
		if (occupiedParkingSpaces.size() != 0) {
			Iterator<ParkingSpace> parkingSpaceiterator = occupiedParkingSpaces.iterator();
			while (parkingSpaceiterator.hasNext()) {
				ParkingSpace ps = parkingSpaceiterator.next();
				if (ps.getVehicle().equals(parkingSpace.getVehicle())) {
					parkingSpaceiterator.remove();
					ps.setVehicle(null);
					ps.setVehiclePresent(false);
					vacantParkingSpaces.add(parkingSpace);
					vehicle = ps.getVehicle();
				}
			}
		}
		return vehicle;
	}

}
