package com.hungrycoders.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hungrycoders.exception.InvalidDoctorStatusException;
import com.hungrycoders.payload.response.GenericResponse;

@RestControllerAdvice
public class GlobalExceptionalHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<GenericResponse<List<String>>> handleValidationException(
			MethodArgumentNotValidException exception) {

		BindingResult result = exception.getBindingResult();

		List<String> errors = result.getAllErrors().stream().map(error -> {
			if (error instanceof FieldError fieldError) {
				return fieldError.getField() + " : " + fieldError.getDefaultMessage();
			}
			return error.getDefaultMessage();
		}).collect(Collectors.toList());

		return new ResponseEntity<>(new GenericResponse<>("Validation Failed", errors), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(exception = InvalidDoctorStatusException.class)
	public ResponseEntity<GenericResponse<String>> handleInvalidDoctorException(
			InvalidDoctorStatusException exception) {

		return new ResponseEntity<GenericResponse<String>>(
				new GenericResponse<>("Validation Failed : " + exception.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
