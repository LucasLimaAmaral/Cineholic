package com.cineholic.spotlight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.entities.Room;
import com.cineholic.spotlight.repositories.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository repository;
	
	public List<Room> findAll(){
		return repository.findAll();
	}
	
	public Room findById(Long id) {
		Optional<Room> obg = repository.findById(id);
		return obg.get();
	}
}
