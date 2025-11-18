package com.cineholic.spotlight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.entities.Ingresso;
import com.cineholic.spotlight.repositories.IngressoRepository;

@Service
public class IngressoService {
	
	@Autowired
	private IngressoRepository repository;
	
	public List<Ingresso> findAll(){
		return repository.findAll();
	}
	
	public Ingresso findById(Long id) {
		Optional<Ingresso> obg = repository.findById(id);
		return obg.get();
	}
}
