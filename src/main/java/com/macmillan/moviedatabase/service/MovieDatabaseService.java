package com.macmillan.moviedatabase.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.macmillan.moviedatabase.Movie;

public interface MovieDatabaseService {

	boolean validateMovie(Movie movie);

	List<Movie> findAllMovies();

	ResponseEntity<String> addMovie(Movie newMovie);

	ResponseEntity<String> deleteMovieById(Long id);

	ResponseEntity<String> deleteMovieByName(String id);

}