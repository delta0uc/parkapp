package com.delta.parking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.delta.parking.service.ReservationService;
import com.delta.parking.exception.ReservationConflictException;
import com.delta.parking.exception.ReservationNotFoundException;
import com.delta.parking.exception.UnknownUserException;
import com.delta.parking.model.Reservation;

@RestController
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;

	@GetMapping(path="/api/v1/reservations")
	public List<Reservation> getReservations(@RequestHeader("userId") int userId) {
		return reservationService.getReservations(userId);
	}
	
	@DeleteMapping(path="/api/v1/reservation/{reservationId}")
	public ResponseEntity deleteReservation(@PathVariable int reservationId) throws ReservationNotFoundException {
		reservationService.deleteReservation(reservationId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(path="/api/v1/reservation")
	public ResponseEntity createReservation(@RequestBody Reservation reservation) throws UnknownUserException, ReservationConflictException {
		reservationService.createReservation(reservation);
		return new ResponseEntity(HttpStatus.CREATED);
	}
}
