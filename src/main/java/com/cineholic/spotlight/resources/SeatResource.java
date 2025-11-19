package com.cineholic.spotlight.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineholic.spotlight.entities.Seat;
import com.cineholic.spotlight.services.SeatService;

@RestController
@RequestMapping(value = "/seats")
public class SeatResource {
	
	@Autowired
	private SeatService service;
	
	@GetMapping
	public ResponseEntity<List<Seat>> findAll(){
		List<Seat> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Seat> findById(@PathVariable Long id){
		Seat obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
