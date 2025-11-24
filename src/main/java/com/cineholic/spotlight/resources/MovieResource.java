package com.cineholic.spotlight.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineholic.spotlight.dtos.MovieDTO;
import com.cineholic.spotlight.entities.Movie;
import com.cineholic.spotlight.services.MovieService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
	
	@Autowired
	private MovieService service;
	
	@GetMapping
	public ResponseEntity<List<Movie>> findAll(){
		List<Movie> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Movie> findById(@PathVariable Long id){
		Movie obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	public ResponseEntity<MovieDTO> postMovie(@RequestBody @Valid MovieDTO movie){
		
		return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED)
				.body(service.addMovie(movie));
	}
}
