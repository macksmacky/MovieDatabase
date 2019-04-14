package com.macmillan.moviedatabase.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.macmillan.moviedatabase.Movie;
import com.macmillan.moviedatabase.dao.MovieDatabaseDao;

@Service
public class MovieDatabaseServiceImpl implements MovieDatabaseService   {
	
	@Autowired
	MovieDatabaseDao movieDatabaseDao;
	
	@Override
	public boolean validateMovie(Movie movie) {
		if(movieDatabaseDao.findTitleByName(movie.getName()) != null){
			return false;
		} 
		if(movie.getRating() < 0 || movie.getRating() > 100) {
			// scale of 0-100
			return false;
		}
		return true;
	}
	
	@Override
	public List<Movie> findAllMovies(){
		return movieDatabaseDao.findAll();
	}

	@Override
	public ResponseEntity<String> addMovie(Movie newMovie) {
		if(validateMovie(newMovie)) {
			movieDatabaseDao.save(newMovie);
			return ResponseEntity.ok(newMovie.getName() + " added with id of " + newMovie.getId());
		}
		
		return ResponseEntity.badRequest().body("Movie names must be unique, and ratings must be on a scale of 0-100");
		
	}

}
