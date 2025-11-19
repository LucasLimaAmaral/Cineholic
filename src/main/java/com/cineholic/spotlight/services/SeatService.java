package com.cineholic.spotlight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.entities.Seat;
import com.cineholic.spotlight.repositories.SeatRepository;

@Service
public class SeatService {
	
	@Autowired
	private SeatRepository repository;
	
	public List<Seat> findAll(){
		return repository.findAll();
	}
	
	public Seat findById(Long id) {
		Optional<Seat> obg = repository.findById(id);
		return obg.get();
	}
}
