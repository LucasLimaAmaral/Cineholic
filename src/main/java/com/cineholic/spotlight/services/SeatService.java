package com.cineholic.spotlight.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.entities.Room;
import com.cineholic.spotlight.entities.Seat;
import com.cineholic.spotlight.repositories.RoomRepository;
import com.cineholic.spotlight.repositories.SeatRepository;

import jakarta.transaction.Transactional;

@Service
public class SeatService {
	
	@Autowired
	private SeatRepository repository;
	
	@Autowired
	private RoomRepository roomRpository;
	
	public List<Seat> findAll(){
		return repository.findAll();
	}
	
	public Seat findById(Long id) {
		Optional<Seat> obg = repository.findById(id);
		return obg.get();
	}
	
	public List<Seat> findByRoom(Long roomId){
		return repository.findByRoom_id(roomId);
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void addSeats(Long roomId, Integer row, Integer column) {
		Room room = roomRpository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
		
		List<Seat> list= new ArrayList<>();
		
		for(int i = 0; i < row; i++) {
			
			char rowLetter = (char) ('A' + i);
			
			for(int j = 0; j < column; j++) {
				
				Seat seat = new Seat();
				
				seat.setRoom(room);
				seat.setNumber(rowLetter + String.valueOf(j));
				
				list.add(seat);
				
			}
			
		}
		
		repository.saveAll(list);
	}
}
