package com.cineholic.spotlight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.entities.Sala;
import com.cineholic.spotlight.repositories.SalaRepository;

@Service
public class SalaService {
	
	@Autowired
	private SalaRepository repository;
	
	public List<Sala> findAll(){
		return repository.findAll();
	}
	
	public Sala findById(Long id) {
		Optional<Sala> obg = repository.findById(id);
		return obg.get();
	}
}
