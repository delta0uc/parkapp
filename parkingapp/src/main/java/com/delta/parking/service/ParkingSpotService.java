package com.delta.parking.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.delta.parking.dao.AdjacentCellsDao;
import com.delta.parking.dao.CellDao;
import com.delta.parking.dao.ParkingSpotDao;
import com.delta.parking.dao.ReservationDao;
import com.delta.parking.model.ParkingSpot;
import com.delta.parking.model.Reservation;

@Service
public class ParkingSpotService {

	@Autowired
	private ParkingSpotDao parkingSpotDao;
	
	@Autowired
	private CellDao cellDao;
	
	@Autowired
	private AdjacentCellsDao adjacentCellsDao;
	
	@Autowired
	private ReservationDao reservationDao;

	public List<ParkingSpot> getAllAvailableParking(double latitude, double longitude, double radius,
			String parkingType, int startTime, int endTime) {
		int currentCellId = getCell(latitude, longitude);
		
		List<Integer> searchCells = getAdjacentCells(currentCellId);
		searchCells.add(currentCellId);
		
		List<ParkingSpot> allParkingSpots = parkingSpotDao.getAllSpots(parkingType, searchCells);
		
		List<ParkingSpot> availableSpots = new ArrayList<>();
		for(ParkingSpot spot: allParkingSpots) {
			if(checkAvailability(spot, startTime, endTime)) {
				availableSpots.add(spot);
			}
		}
		return availableSpots;
	}
	
	private int getCell(double latitude, double longitude) {
		return cellDao.getCell(latitude, longitude);
	}
	
	private List<Integer> getAdjacentCells(int cellId){
		return adjacentCellsDao.findNeighbors(cellId); 
	}
	
	private boolean checkAvailability(ParkingSpot spot, int startTime, int endTime) {
		if(startTime < spot.getAvalabilityStart() || startTime > spot.getAvalabilityEnd() ||
				endTime < spot.getAvalabilityStart() || endTime > spot.getAvalabilityEnd()) {
			return false;
		}
		
		List<Reservation> reservationList = reservationDao.findAllByParkingSpotId(spot.getId());
		for(Reservation reservation: reservationList) {
			if((startTime > reservation.getStartTime() && startTime < reservation.getEndTime()) ||
					(endTime > reservation.getStartTime() && endTime < reservation.getEndTime())) {
				return false;
			}
		}
		return true;
	}
}