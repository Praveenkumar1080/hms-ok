package com.cg.hms.exceptions;

public class DuplicateEntryException extends RuntimeException {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public DuplicateEntryException() {
	
}
public DuplicateEntryException(String msg) {
	super(msg);
}
}
