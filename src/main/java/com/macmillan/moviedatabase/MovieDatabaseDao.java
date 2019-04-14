package com.macmillan.moviedatabase;


import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDatabaseDao extends JpaRepository<Movie, Long>{

}
