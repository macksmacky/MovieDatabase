package com.macmillan.moviedatabase.controller;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macmillan.moviedatabase.Movie;
import com.macmillan.moviedatabase.dao.MovieDatabaseDao;
import com.macmillan.moviedatabase.service.MovieDatabaseService;

@RestController
@RequestMapping("/api/v1")
public class MovieRestController {
	
	private final MovieDatabaseDao movieDatabaseDao;
	
	@Autowired
	MovieDatabaseService movieDatabaseService;
	
	MovieRestController(MovieDatabaseDao movieDatabaseDao){
		this.movieDatabaseDao = movieDatabaseDao;
	}
	
	@RequestMapping(value = "/timeOfDay", produces = {"application/JSON"})
	public Map<String, String> timeOfDay() {
		Calendar calendar = Calendar.getInstance();
		return Collections.singletonMap("timeOfDay", calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE)) ;
	}
	
	@PostMapping("/movie")
    public ResponseEntity<?> addMovie(@RequestBody Movie newMovie) {
		return movieDatabaseService.addMovie(newMovie);
	}
	
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
		movieDatabaseDao.deleteById(id);
		return new ResponseEntity<>("Movie deleted Successfully", HttpStatus.OK);
	}
	
	@GetMapping("/movie/list")
	public List<Movie> listMovies() {
		return movieDatabaseService.findAllMovies();
	}

}