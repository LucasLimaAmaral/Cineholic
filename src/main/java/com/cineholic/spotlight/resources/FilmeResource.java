package com.cineholic.spotlight.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineholic.spotlight.entities.Filme;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeResource {
	
	@GetMapping
	public ResponseEntity<Filme> findAll(){
		Filme f = new Filme();
		return ResponseEntity.ok().body(f);
	}
}
