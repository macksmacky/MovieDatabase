package com.macmillan.moviedatabase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.macmillan.moviedatabase.dao.MovieDatabaseDao;
import com.macmillan.moviedatabase.service.MovieDatabaseServiceImpl;


public class MovieDatabaseServiceTest {

	private MovieDatabaseServiceImpl mdbs;
	
	@Mock
	private MovieDatabaseDao mdd;
	
	@Before
	public void setUp() throws Exception {
		mdbs = new MovieDatabaseServiceImpl();
		MockitoAnnotations.initMocks(this);
		mdbs.setMovieDatabaseDao(mdd);
	}
	
	@Test
	public void validateMovieDuplicateTitleFailureTest() {
		Movie movie = new Movie();
		movie.setName("Name");
		movie.setRating(50);

		when(mdd.findTitleByName(Mockito.anyString())).thenReturn(new Movie());
		
		boolean validMovie = mdbs.validateMovie(movie);
		
		assertFalse(validMovie);
	}
	
	@Test
	public void validateMovieInvalidRatingOver100Test() {
		Movie movie = new Movie();
		movie.setName("Name");
		movie.setRating(125);
		
		when(mdd.findTitleByName(Mockito.anyString())).thenReturn(null);
		
		boolean validMovie = mdbs.validateMovie(movie);
		
		assertFalse(validMovie);
	}
	
	@Test
	public void validateMovieInvalidRatingNegativeTest() {
		Movie movie = new Movie();
		movie.setName("Name");
		movie.setRating(-1);
		
		when(mdd.findTitleByName(Mockito.anyString())).thenReturn(null);
		
		boolean validMovie = mdbs.validateMovie(movie);
		
		assertFalse(validMovie);
	}
	
	@Test
	public void validateMovieValidTest() {
		Movie movie = new Movie();
		movie.setName("Name");
		movie.setRating(50);
		
		when(mdd.findTitleByName(Mockito.anyString())).thenReturn(null);
		
		boolean validMovie = mdbs.validateMovie(movie);
		
		assertTrue(validMovie);
	}
}
