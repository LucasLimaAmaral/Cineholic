package com.cineholic.spotlight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.entities.Ticket;
import com.cineholic.spotlight.repositories.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository repository;
	
	public List<Ticket> findAll(){
		return repository.findAll();
	}
	
	public Ticket findById(Long id) {
		Optional<Ticket> obg = repository.findById(id);
		return obg.get();
	}
	
	public List<Ticket> findBySession(Long id){
		return repository.findBySession_id(id);
	}
	
}
