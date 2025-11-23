package com.cineholic.spotlight.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.entities.Seat;
import com.cineholic.spotlight.entities.Session;
import com.cineholic.spotlight.entities.Ticket;
import com.cineholic.spotlight.repositories.SessionRepository;
import com.cineholic.spotlight.validators.SessionValidator;

@Service
public class SessionService {

	@Autowired
	private SessionRepository repository;

	@Autowired
	private SeatService seatService;

	@Autowired
	private TicketService ticketService;
	
	private SessionValidator validator;
	
	public List<Session> findAll() {
		return repository.findAll();
	}

	public Session findById(Long id) {
		Optional<Session> obg = repository.findById(id);
		return obg.get();
	}

	public List<Session> findByMovies(Long movieId) {
		return repository.findByMovie_id(movieId);
	}

	public List<Seat> getSeatsAvailable(Long id) {

		Session obj = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Sessão não encontrada com ID: " + id));

		Set<Seat> allSeats = new HashSet<>(seatService.
				findByRoom(obj.getRoom().getId()));

		Set<Seat> OccupiedSeats = new HashSet<>(getOccupiedSeats(id));

		allSeats.removeAll(OccupiedSeats);

		return new ArrayList<>(allSeats);

	}

	public List<Seat> getOccupiedSeats(Long id) {
		List<Ticket> tickets = ticketService.findBySession(id);

		return tickets.stream()
				.map(Ticket::getSeat)
				.collect(Collectors.toList());
	}
	
	public boolean isOccupiedSeat(Long id, Long seatId) {
		Set<Long> oc = getOccupiedSeats(id).stream()
				.map(seat -> seat.getId())
				.collect(Collectors.toSet());
		
		return oc.contains(seatId);
	}
	
	public void validAddSession(Long roomId, LocalDateTime data, Double price, Long movieId) {
		
		repository.save(validator.validAddSession(roomId, data, price, movieId));
		
	}
}
