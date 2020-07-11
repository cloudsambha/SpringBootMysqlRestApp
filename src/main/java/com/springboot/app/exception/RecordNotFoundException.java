package com.springboot.app.exception;

public class RecordNotFoundException extends RuntimeException {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1368134947172570287L;

	public RecordNotFoundException(String exception) {
	    super(exception);
	  }

	}