package com.cineholic.spotlight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.entities.Filme;
import com.cineholic.spotlight.repositories.FilmeRepository;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository repository;
	
	public List<Filme> findAll(){
		return repository.findAll();
	}
	
	public Filme findById(Long id) {
		Optional<Filme> obg = repository.findById(id);
		return obg.get();
	}
}
