package com.macmillan.moviedatabase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.macmillan.moviedatabase.Movie;
import com.macmillan.moviedatabase.MovieNotFoundException;
import com.macmillan.moviedatabase.MovieValidatorException;
import com.macmillan.moviedatabase.dao.MovieDatabaseDao;

@Service
public class MovieDatabaseServiceImpl implements MovieDatabaseService {

	@Autowired
	private MovieDatabaseDao movieDatabaseDao;

	@Override
	public boolean validateMovie(Movie movie) {
		if (movieDatabaseDao.findTitleByName(movie.getName()) != null) {
			return false;
		}
		if (movie.getRating() < 0 || movie.getRating() > 100) {
			// scale of 0-100
			return false;
		}
		return true;
	}

	@Override
	public List<Movie> findAllMovies() {
		return movieDatabaseDao.findAll();
	}

	@Override
	public void addMovie(Movie newMovie) throws MovieValidatorException {
		if (!validateMovie(newMovie)) {
			throw new MovieValidatorException();
		}
		movieDatabaseDao.save(newMovie);
	}

	@Override
	public void deleteMovieById(Long id) throws MovieNotFoundException {
		if (!movieDatabaseDao.findById(id).isPresent()) {
			throw new MovieNotFoundException(id);
		}

		movieDatabaseDao.deleteById(id);
	}

	@Override
	public void deleteMovieByName(String name) throws MovieNotFoundException {
		Movie movieToDelete = movieDatabaseDao.findTitleByName(name);
		if (movieToDelete == null) {
			throw new MovieNotFoundException(name);
		}

		movieDatabaseDao.delete(movieToDelete);
	}

	@Override
	public void updateMovie(Movie movie) throws MovieNotFoundException, MovieValidatorException {
		Optional<Movie> movieToUpdate = movieDatabaseDao.findById(movie.getId());
		if (!movieToUpdate.isPresent()) {
			throw new MovieNotFoundException(movie.getId());
		} else if (!validateMovie(movie)) {
			throw new MovieValidatorException();
		}

		movieDatabaseDao.save(movie);

	}

}
