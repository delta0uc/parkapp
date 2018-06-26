package com.delta.parking.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.delta.parking.model.ParkingSpot;

public interface ParkingSpotDao extends JpaRepository<ParkingSpot, Integer> {
	@Query("Select spot from ParkingSpot spot where type = ?1 AND cellId IN ?2")
	public List<ParkingSpot> getAllSpots(String parkingType, List<Integer> searchCells);
}
