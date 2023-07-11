package com.cg.hms.exceptions;

public class NoRecordsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NoRecordsException() {
		
	}
	public NoRecordsException(String msg) {
		super(msg);
	}

}
