package com.cineholic.spotlight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.entities.Sessao;
import com.cineholic.spotlight.repositories.SessaoRepository;

@Service
public class SessaoService {
	
	@Autowired
	private SessaoRepository repository;
	
	public List<Sessao> findAll(){
		return repository.findAll();
	}
	
	public Sessao findById(Long id) {
		Optional<Sessao> obg = repository.findById(id);
		return obg.get();
	}
}
