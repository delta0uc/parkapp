package com.delta.parking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cell {

	@Id
	@GeneratedValue
	private int cellId;
	private double latitudeStart;
	private double latitudeEnd;
	private double longitudeStart;
	private double longitudeEnd;

	public int getCellId() {
		return cellId;
	}
	public void setCellId(int cellId) {
		this.cellId = cellId;
	}
	public double getLatitudeStart() {
		return latitudeStart;
	}
	public void setLatitudeStart(double latitudeStart) {
		this.latitudeStart = latitudeStart;
	}
	public double getLatitudeEnd() {
		return latitudeEnd;
	}
	public void setLatitudeEnd(double latitudeEnd) {
		this.latitudeEnd = latitudeEnd;
	}
	public double getLongitudeStart() {
		return longitudeStart;
	}
	public void setLongitudeStart(double longitudeStart) {
		this.longitudeStart = longitudeStart;
	}
	public double getLongitudeEnd() {
		return longitudeEnd;
	}
	public void setLongitudeEnd(double longitudeEnd) {
		this.longitudeEnd = longitudeEnd;
	}
	@Override
	public String toString() {
		return "Cell [cellId=" + cellId + ", latitudeStart=" + latitudeStart + ", latitudeEnd=" + latitudeEnd
				+ ", longitudeStart=" + longitudeStart + ", longitudeEnd=" + longitudeEnd + "]";
	}
}
