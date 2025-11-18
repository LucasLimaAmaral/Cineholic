package com.cineholic.spotlight.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineholic.spotlight.entities.Sessao;
import com.cineholic.spotlight.services.SessaoService;

@RestController
@RequestMapping(value = "/sessoes")
public class SessaoResource {
	
	@Autowired
	private SessaoService service;
	
	@GetMapping
	public ResponseEntity<List<Sessao>> findAll(){
		List<Sessao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Sessao> findById(@PathVariable Long id){
		Sessao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
