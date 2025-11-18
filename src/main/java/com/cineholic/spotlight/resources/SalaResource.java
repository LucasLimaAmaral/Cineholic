package com.cineholic.spotlight.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineholic.spotlight.entities.Sala;
import com.cineholic.spotlight.services.SalaService;

@RestController
@RequestMapping(value = "/salas")
public class SalaResource {
	
	@Autowired
	private SalaService service;
	
	@GetMapping
	public ResponseEntity<List<Sala>> findAll(){
		List<Sala> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Sala> findById(@PathVariable Long id){
		Sala obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
