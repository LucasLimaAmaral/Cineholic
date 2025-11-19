package com.cineholic.spotlight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.entities.Movie;
import com.cineholic.spotlight.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	public List<Movie> findAll(){
		return repository.findAll();
	}
	
	public Movie findById(Long id) {
		Optional<Movie> obg = repository.findById(id);
		return obg.get();
	}
}
