package com.delta.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Unknown, Invalid or Blocked User") 
public class UnknownUserException extends Exception {

	private static final long serialVersionUID = 1L;

}
