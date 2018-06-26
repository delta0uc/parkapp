package com.delta.parking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParkingSpot {
 
	@Id
	@GeneratedValue
	private int id;
	private int cellId;
	private String type;
	private double latitude;
	private double longitude;
	private int avalabilityStart;
	private int avalabilityEnd;
	private double costPerHour;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCellId() {
		return cellId;
	}
	public void setCellId(int cellId) {
		this.cellId = cellId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public double getCostPerHour() {
		return costPerHour;
	}
	public void setCostPerHour(double costPerHour) {
		this.costPerHour = costPerHour;
	}

	public int getAvalabilityStart() {
		return avalabilityStart;
	}

	public void setAvalabilityStart(int avalabilityStart) {
		this.avalabilityStart = avalabilityStart;
	}

	public int getAvalabilityEnd() {
		return avalabilityEnd;
	}

	public void setAvalabilityEnd(int avalabilityEnd) {
		this.avalabilityEnd = avalabilityEnd;
	}

	@Override
	public String toString() {
		return "ParkingSpot [id=" + id + ", cellId=" + cellId + ", type=" + type + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", avalabilityStart=" + avalabilityStart + ", avalabilityEnd="
				+ avalabilityEnd + ", costPerHour=" + costPerHour + "]";
	}

	
}
