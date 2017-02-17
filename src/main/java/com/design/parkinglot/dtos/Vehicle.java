package com.design.parkinglot.dtos;

public class Vehicle {

	private String regiNumber;
	private String color;

	public String getRegiNumber() {
		return regiNumber;
	}

	public void setRegiNumber(String regiNumber) {
		this.regiNumber = regiNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Vehicle(String regiNumber, String color) {
		super();
		this.regiNumber = regiNumber;
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((regiNumber == null) ? 0 : regiNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (regiNumber == null) {
			if (other.regiNumber != null)
				return false;
		} else if (!regiNumber.equals(other.regiNumber))
			return false;
		return true;
	}

}
