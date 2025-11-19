package com.cineholic.spotlight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.entities.Session;
import com.cineholic.spotlight.repositories.SessionRepository;

@Service
public class SessionService {
	
	@Autowired
	private SessionRepository repository;
	
	public List<Session> findAll(){
		return repository.findAll();
	}
	
	public Session findById(Long id) {
		Optional<Session> obg = repository.findById(id);
		return obg.get();
	}
}
