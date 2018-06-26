package com.delta.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="There is a time conflict with an existing reservation")
public class ReservationConflictException extends Exception {
	private static final long serialVersionUID = 1L;
}
