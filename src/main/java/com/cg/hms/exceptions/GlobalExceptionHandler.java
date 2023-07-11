package com.cg.hms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(NoSuchElementException exe) {
		 return new ResponseEntity<String>(exe.getMessage(),HttpStatus.OK);
	}
	@ExceptionHandler(DuplicateEntryException.class)
	public ResponseEntity<String> handleDuplicateEntryException(DuplicateEntryException exe) {
		
		 return new ResponseEntity<String>(exe.getMessage(),HttpStatus.OK);
	}
	@ExceptionHandler(NoEntryException.class)
	public ResponseEntity<String> handlNoEntryException(NoEntryException exe) {
		
		 return new ResponseEntity<String>(exe.getMessage(),HttpStatus.OK);
	}
	@ExceptionHandler(NoRecordsException.class)
	public ResponseEntity<String> handlNoRecordsException(NoEntryException exe) {
		
		 return new ResponseEntity<String>(exe.getMessage(),HttpStatus.OK);
	}

	
	
}
