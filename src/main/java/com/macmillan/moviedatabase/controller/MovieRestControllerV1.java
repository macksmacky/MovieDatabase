package com.macmillan.moviedatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macmillan.moviedatabase.Movie;
import com.macmillan.moviedatabase.MovieNotFoundException;
import com.macmillan.moviedatabase.MovieValidatorException;
import com.macmillan.moviedatabase.service.MovieDatabaseService;
import com.macmillan.moviedatabase.service.TimeService;

@RestController
@RequestMapping("/api/v1")
public class MovieRestControllerV1 {

	@Autowired
	private MovieDatabaseService movieDatabaseService;

	@Autowired
	private TimeService ts;

	@GetMapping("/timeOfDay")
	public String timeOfDay() {
		return ts.getTimeOfDay();
	}

	@PostMapping("/movie")
	public ResponseEntity<?> addMovie(@RequestBody Movie newMovie) throws MovieValidatorException {
		movieDatabaseService.addMovie(newMovie);
		return ResponseEntity.ok(newMovie.getName() + " added with id of " + newMovie.getId());
	}

	@PutMapping("/movie")
	public ResponseEntity<?> updateMovie(@RequestBody Movie movie)
			throws MovieNotFoundException, MovieValidatorException {
		movieDatabaseService.updateMovie(movie);
		return ResponseEntity.ok(movie.getName() + " updated successfully.");
	}

	@DeleteMapping("/movie/{id}")
	public ResponseEntity<?> deleteMovieById(@PathVariable Long id) throws MovieNotFoundException {
		movieDatabaseService.deleteMovieById(id);
		return ResponseEntity.ok("Movie deleted Successfully");
	}

	@GetMapping("/movie/list")
	public List<Movie> listMovies() {
		return movieDatabaseService.findAllMovies();
	}

}
