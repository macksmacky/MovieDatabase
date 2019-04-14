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
import com.macmillan.moviedatabase.service.MovieDatabaseService;
import com.macmillan.moviedatabase.service.TimeService;

@RestController
@RequestMapping("/api/v1")
public class MovieRestController {

	@Autowired
	MovieDatabaseService movieDatabaseService;

	@Autowired
	TimeService ts;

	@GetMapping("/timeOfDay")
	public String timeOfDay(){
		return ts.getTimeOfDay();
	}

	@PostMapping("/movie")
	public ResponseEntity<?> addMovie(@RequestBody Movie newMovie) {
		return movieDatabaseService.addMovie(newMovie);
	}
	
	@PutMapping("/movie")
	public ResponseEntity<?> updateMovie(@RequestBody Movie newMovie) {
		return movieDatabaseService.updateMovie(newMovie);
	}

	@DeleteMapping("/movie/{id}")
	public ResponseEntity<?> deleteMovieById(@PathVariable Long id) {
		return movieDatabaseService.deleteMovieById(id);
	}

	@DeleteMapping("/movie/{name}")
	public ResponseEntity<?> deleteMovieByName(@PathVariable String name) {
		return movieDatabaseService.deleteMovieByName(name);
	}

	@GetMapping("/movie/list")
	public List<Movie> listMovies() {
		return movieDatabaseService.findAllMovies();
	}

}
