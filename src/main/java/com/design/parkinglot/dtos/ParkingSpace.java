package com.design.parkinglot.dtos;

public class ParkingSpace {

	private Vehicle vehicle;
	private Boolean vehiclePresent;
	private String buildingId;

	public ParkingSpace(String buildingNumber) {
		this.buildingId = buildingNumber;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Boolean getVehiclePresent() {
		return vehiclePresent;
	}

	public void setVehiclePresent(Boolean vehiclePresent) {
		this.vehiclePresent = vehiclePresent;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

}
