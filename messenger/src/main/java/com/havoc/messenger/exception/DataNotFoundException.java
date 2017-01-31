package com.havoc.messenger.exception;

import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6036965349774961995L;

	public DataNotFoundException(String message){
		super(message);
	}
}
