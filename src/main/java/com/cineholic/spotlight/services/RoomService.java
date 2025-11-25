package com.cineholic.spotlight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.dtos.RoomDTO;
import com.cineholic.spotlight.entities.Room;
import com.cineholic.spotlight.repositories.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository repository;
	
	@Autowired
	private SeatService seatService;
	
	public List<Room> findAll(){
		return repository.findAll();
	}
	
	public Room findById(Long id) {
		Optional<Room> obg = repository.findById(id);
		return obg.get();
	}
	
	public Room addRoom(RoomDTO dto) {
		
		boolean exist = repository.existByNumber(dto.getNome());
		
		if(exist) {
			throw new RuntimeException("Already exist a room with this name");
		}
		
		Integer capacity = dto.getColumn() * dto.getRow();
		
		
		Room room = repository.save(new Room(null, dto.getNome(), capacity));
		
		seatService.addSeats(room.getId(), dto.getRow(), dto.getColumn());
		
		return room;
	}
	
}
