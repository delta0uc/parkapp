package com.delta.parking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private int reservationId;
	private int parkingSpotId;
	private int startTime;
	private int endTime;
	private String paymentStatus;
	private int userId;
	
	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}



	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getParkingSpotId() {
		return parkingSpotId;
	}

	public void setParkingSpotId(int parkingSpotId) {
		this.parkingSpotId = parkingSpotId;
	}

}
