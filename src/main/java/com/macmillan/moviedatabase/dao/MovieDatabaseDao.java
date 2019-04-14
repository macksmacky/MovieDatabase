package com.macmillan.moviedatabase.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.macmillan.moviedatabase.Movie;

public interface MovieDatabaseDao extends JpaRepository<Movie, Long>{

	@Query("SELECT m.name FROM Movie m where m.name = :name") 
    String findTitleByName(@Param("name") String name);
}
