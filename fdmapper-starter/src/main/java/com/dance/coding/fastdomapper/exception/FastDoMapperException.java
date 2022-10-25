package com.dance.coding.fastdomapper.exception;

public class FastDoMapperException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	 public FastDoMapperException(String message) {
	        super(message);
	    }

	    public FastDoMapperException(Throwable cause) {
	        super(cause);
	    }

	    public FastDoMapperException(String message, Throwable cause) {
	        super(message, cause);
	    }
	
}
