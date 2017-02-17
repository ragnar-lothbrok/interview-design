package com.design.parkinglot.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.design.parkinglot.Api.ParkingService;
import com.design.parkinglot.Api.ParkingStrategy;
import com.design.parkinglot.dtos.Building;
import com.design.parkinglot.dtos.ParkingSpace;
import com.design.parkinglot.dtos.Vehicle;

public class ParkingServiceImpl implements ParkingService {

	private List<Building> list = new ArrayList<Building>();

	Map<String, List<ParkingSpace>> colorParkingMap = new HashMap<String, List<ParkingSpace>>();
	Map<String, ParkingSpace> regNumberParkingMap = new HashMap<String, ParkingSpace>();

	private ParkingServiceImpl() {

	}

	public static class SingletonHelper {
		private static final ParkingService parkingService = new ParkingServiceImpl();
	}

	public static ParkingService getParkingService() {
		return SingletonHelper.parkingService;
	}

	public void park(String regNum, String color, ParkingStrategy parkingStrategy) {
		String buildingId = parkingStrategy.getBuilding();
		System.out.println(buildingId);
		if(buildingId != null){
			for (Building building : list) {
				if (building.getBuildingNumber().equals(buildingId)) {
					ParkingSpace parkingSpace = building.getParkingSpace(new Vehicle(regNum, color));
					if (parkingSpace != null) {
						regNumberParkingMap.put(regNum, parkingSpace);
						if (colorParkingMap.get(color) == null) {
							colorParkingMap.put(color, new ArrayList<ParkingSpace>());
						}
						colorParkingMap.get(color).add(parkingSpace);
						System.out.println("Car parked.");
					}else{
						System.out.println("Can not be parked.");
					}
					break;
				}
			}
		}else{
			System.out.println("Can not be parked.");
		}
	}

	public void unPark(String regNum) {
		ParkingSpace parkingSpace = regNumberParkingMap.get(regNum);
		if (parkingSpace != null) {
			System.out.println("unParked.");
			regNumberParkingMap.remove(regNum);
			for (Building building : list) {
				if (building.getBuildingNumber().equals(parkingSpace.getBuildingId())) {
					List<ParkingSpace> parkingSpaces = colorParkingMap.get(parkingSpace.getVehicle().getColor());
					if (parkingSpaces.size() > 0) {
						Iterator<ParkingSpace> parkingSpaceIterator = parkingSpaces.iterator();
						while (parkingSpaceIterator.hasNext()) {
							ParkingSpace temp = parkingSpaceIterator.next();
							if (temp.getVehicle().equals(parkingSpace.getVehicle())) {
								parkingSpaceIterator.remove();
							}
						}
					}
				}
			}
		}else{
			System.out.println("Can not be unparked.");
		}
	}

	public void createBuilding(Integer numberOfParkings) {
		list.add(new Building(UUID.randomUUID().toString(), numberOfParkings));
	}

	public List<Building> getList() {
		return list;
	}

}
