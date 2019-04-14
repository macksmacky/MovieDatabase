package com.macmillan.moviedatabase.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.macmillan.moviedatabase.Movie;

public interface MovieDatabaseService {

	/**
	 * @param newMovie
	 */
	void addMovie(Movie newMovie);

	/**
	 * @param id
	 */
	void deleteMovieById(Long id);

	/**
	 * @param id
	 */
	void deleteMovieByName(String id);

	/**
	 * @return
	 */
	List<Movie> findAllMovies();

	/**
	 * @param movie
	 */
	void updateMovie(Movie movie);

	/**
	 * @param movie
	 * @return
	 */
	boolean validateMovie(Movie movie);

}