package com.cineholic.spotlight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.entities.Assento;
import com.cineholic.spotlight.repositories.AssentoRepository;

@Service
public class AssentoService {
	
	@Autowired
	private AssentoRepository repository;
	
	public List<Assento> findAll(){
		return repository.findAll();
	}
	
	public Assento findById(Long id) {
		Optional<Assento> obg = repository.findById(id);
		return obg.get();
	}
}
