package com.cineholic.spotlight.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineholic.spotlight.entities.Ticket;
import com.cineholic.spotlight.services.TicketService;

@RestController
@RequestMapping(value = "/tickets")
public class TicketResource {
	
	@Autowired
	private TicketService service;
	
	@GetMapping
	public ResponseEntity<List<Ticket>> findAll(){
		List<Ticket> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ticket> findById(@PathVariable Long id){
		Ticket obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
