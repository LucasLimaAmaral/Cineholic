package com.cineholic.spotlight.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineholic.spotlight.dtos.RoomDTO;
import com.cineholic.spotlight.entities.Room;
import com.cineholic.spotlight.services.RoomService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/rooms")
public class RoomResource {
	
	@Autowired
	private RoomService service;
	
	@GetMapping
	public ResponseEntity<List<Room>> findAll(){
		List<Room> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Room> findById(@PathVariable Long id){
		Room obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Room> postRoom(@RequestBody @Valid RoomDTO room){
		
		return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED)
				.body(service.addRoom(room));
	}
}
