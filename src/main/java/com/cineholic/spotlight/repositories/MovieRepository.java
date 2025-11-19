package com.cineholic.spotlight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineholic.spotlight.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
