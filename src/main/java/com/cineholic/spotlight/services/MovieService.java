package com.cineholic.spotlight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.dtos.MovieDTO;
import com.cineholic.spotlight.entities.Movie;
import com.cineholic.spotlight.enums.Genre;
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
	
	public MovieDTO addMovie(MovieDTO movie) {
		
		String title = movie.getTitle();

		Genre genre = movie.getGenre();

		Integer duration = movie.getDuration();

		String synopsis = movie.getSynopsis();

		String posterUrl = movie.getPosterUrl();
		
		repository.save(new Movie(null ,title, genre, duration, synopsis, posterUrl));
		
		return movie;
	}
}
