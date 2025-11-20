package com.cineholic.spotlight.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineholic.spotlight.entities.Session;
import com.cineholic.spotlight.services.SessionService;

@RestController
@RequestMapping(value = "/sessions")
public class SessionResource {
	
	@Autowired
	private SessionService service;
	
	@GetMapping
	public ResponseEntity<List<Session>> findAll(){
		List<Session> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Session> findById(@PathVariable Long id){
		Session obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/movie/{id_movie}")
	public ResponseEntity<List<Session>> findByMovie(@PathVariable Long id_movie){
		List<Session> list = service.findByMovies(id_movie);
		return ResponseEntity.ok().body(list);
	}
}
