package com.design.parkinglot.Impl;

import com.design.parkinglot.Api.ParkingStrategy;
import com.design.parkinglot.dtos.Building;

public class RoundRobinParking implements ParkingStrategy {

	private volatile String buildingId;

	public synchronized String getBuilding() {
		ParkingServiceImpl parkingServiceImpl = (ParkingServiceImpl) ParkingServiceImpl.getParkingService();
		if (parkingServiceImpl.getList().size() > 0) {
			for (int i = 0; i < parkingServiceImpl.getList().size(); i++) {
				Building building = parkingServiceImpl.getList().get(i);
				if (this.buildingId != null) {
					if (this.buildingId != null && building.getBuildingNumber().equals(this.buildingId)) {
						int index = i + 1;
						String fetchBuildingId = "";
						while (this.buildingId != fetchBuildingId) {
							if (index < parkingServiceImpl.getList().size()) {
								building = parkingServiceImpl.getList().get(index);
								if (building.isSpaceAvailable()) {
									fetchBuildingId = building.getBuildingNumber();
									break;
								}
							} else {
								index = (index % parkingServiceImpl.getList().size());
								fetchBuildingId = parkingServiceImpl.getList().get(index).getBuildingNumber();
								break;
							}
							index++;
						}
						if (fetchBuildingId.trim().length() > 0) {
							this.buildingId = fetchBuildingId;
							break;
						} else {
							building = parkingServiceImpl.getList().get(i);
							if (building.isSpaceAvailable()) {
								this.buildingId = building.getBuildingNumber();
								break;
							}
						}
					}
				} else {
					if (building.isSpaceAvailable()) {
						this.buildingId = building.getBuildingNumber();
					}
				}
			}
		}
		return buildingId;
	}

}
