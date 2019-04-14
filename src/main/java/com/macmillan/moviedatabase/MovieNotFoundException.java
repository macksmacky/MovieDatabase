package com.macmillan.moviedatabase;

public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3931555019897563468L;

	public MovieNotFoundException(Long id) {
			super("Could not find movie by id of " + id);
	}
	
	public MovieNotFoundException(String name) {
		super("Could not find movie with name of " + name);
	}
}
