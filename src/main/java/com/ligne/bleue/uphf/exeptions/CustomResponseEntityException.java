package com.ligne.bleue.uphf.exeptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException ex,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), null, request.getDescription(false),
				false);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ActivityNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleActivityNotFoundException(ActivityNotFoundException ex,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), null, request.getDescription(false),
				false);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ProgramNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleProgramNotFoundException(ProgramNotFoundException ex,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), null, request.getDescription(false),
				false);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmptyFieldsException.class)
	public final ResponseEntity<ErrorDetails> handleEmptyFieldException(EmptyFieldsException ex, WebRequest request) {
		String msg = "Paramètre manquant ou invalide.";
		ErrorDetails errorDetails = new ErrorDetails(new Date(), msg, ex.getMessage(), request.getDescription(false),
				false);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String msg = "Paramètre manquant ou invalide.";
		ErrorDetails errorDetails = new ErrorDetails(new Date(), msg, ex.getMessage(), request.getDescription(false),
				false);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
