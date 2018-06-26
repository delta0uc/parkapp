package com.delta.parking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.parking.dao.ReservationDao;
import com.delta.parking.dao.UserDao;
import com.delta.parking.exception.ReservationConflictException;
import com.delta.parking.exception.ReservationNotFoundException;
import com.delta.parking.exception.UnknownUserException;
import com.delta.parking.model.Reservation;
import com.delta.parking.model.User;

@Service
public class ReservationService {
	@Autowired
	private ReservationDao reservationDao;
	@Autowired
	private UserDao userDao;
	
	public List<Reservation> getReservations(int userId) {
		return reservationDao.findByUserId(userId);
	}

	public void deleteReservation(int reservationId) throws ReservationNotFoundException {
		if(!reservationDao.findById(reservationId).isPresent()) {
			throw new ReservationNotFoundException();
		}
		reservationDao.deleteById(reservationId);
	}

	public void createReservation(Reservation reservation) throws UnknownUserException, ReservationConflictException {
		int userId = reservation.getUserId();
		
		User user = userDao.findById(userId).orElse(null);
		
		if(user == null || !user.getStatus().equals("ACTIVE")) {
			throw new UnknownUserException();
		}
		
		List<Reservation> reservationList = reservationDao.findAllByParkingSpotId(reservation.getParkingSpotId());;
		for(Reservation entry: reservationList) {
			if((reservation.getStartTime() > entry.getStartTime() && reservation.getStartTime() < entry.getEndTime()) ||
					(reservation.getEndTime() > entry.getStartTime() && reservation.getEndTime() < entry.getEndTime())) {
				throw new ReservationConflictException();
			}
		}
		reservationDao.save(reservation);
	}
}
