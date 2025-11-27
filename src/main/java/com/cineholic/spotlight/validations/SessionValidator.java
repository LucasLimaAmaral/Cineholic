package com.cineholic.spotlight.validations;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cineholic.spotlight.entities.Movie;
import com.cineholic.spotlight.entities.Room;
import com.cineholic.spotlight.entities.Session;
import com.cineholic.spotlight.repositories.MovieRepository;
import com.cineholic.spotlight.repositories.RoomRepository;
import com.cineholic.spotlight.repositories.SessionRepository;

@Component
public class SessionValidator {
	
	@Autowired
	private SessionRepository repository;
	
	@Autowired
	private RoomRepository roomRep;
	
	@Autowired
	private MovieRepository movieRep;
	
	public Session validAddSession(Long roomId, LocalDateTime data, Double price, Long movieId) {
		Room room = roomRep.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
		
		Movie movie = movieRep.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
		
		LocalDateTime end = data.plusMinutes(movie.getDuration() + 30);
		
		boolean conflito = repository.hasConflict(roomId, data, end);
		
		if(conflito) {
			throw new RuntimeException("Alrady exist an session in this gap of time");
		}
		
		return new Session(null, data, price, movie, room);
	}
}
