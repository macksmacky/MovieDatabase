package com.macmillan.moviedatabase;

public class MovieValidatorException extends RuntimeException {

	private static final long serialVersionUID = 594616972818936173L;

	public MovieValidatorException() {
			super("Movie names must be unique and have a rating of 0-100.");
	}
	
}
