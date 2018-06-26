package com.delta.parking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.delta.parking.model.ParkingSpot;
import com.delta.parking.service.ParkingSpotService;

@RestController
public class ParkingSpotController {

	@Autowired
	private ParkingSpotService parkingSpotService;
	
	@GetMapping(path="/api/v1/parkingspot")
	public List<ParkingSpot> getParkingSpots(
			@RequestParam("lat") double latitude,
			@RequestParam("long") double longitude,
			@RequestParam("rad") double radius,
			@RequestParam("type") String parkingType,
			@RequestParam("start") int startTime,
			@RequestParam("end") int endTime) {
		
		return parkingSpotService.getAllAvailableParking(latitude, longitude, radius, parkingType, startTime, endTime);
	}
}
