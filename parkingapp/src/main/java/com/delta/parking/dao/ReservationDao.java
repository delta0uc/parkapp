package com.delta.parking.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.delta.parking.model.Reservation;

public interface ReservationDao extends JpaRepository<Reservation, Integer>{

	public List<Reservation> findByUserId(int userId);

	public List<Reservation> findAllByParkingSpotId(int id);
}
