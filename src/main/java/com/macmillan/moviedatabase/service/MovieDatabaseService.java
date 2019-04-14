package com.macmillan.moviedatabase.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.macmillan.moviedatabase.Movie;

public interface MovieDatabaseService {

	boolean validateMovie(Movie movie);

	List<Movie> findAllMovies();

	void addMovie(Movie newMovie);

	void deleteMovieById(Long id);

	void deleteMovieByName(String id);

	void updateMovie(Movie movie);

}