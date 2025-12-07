package com.cineholic.spotlight.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.dtos.PurchaseRequestDTO;
import com.cineholic.spotlight.dtos.PurchaseResponseDTO;
import com.cineholic.spotlight.entities.Customer;
import com.cineholic.spotlight.entities.Seat;
import com.cineholic.spotlight.entities.Session;
import com.cineholic.spotlight.entities.Ticket;
import com.cineholic.spotlight.repositories.CustomerRepository;
import com.cineholic.spotlight.repositories.SeatRepository;
import com.cineholic.spotlight.repositories.SessionRepository;
import com.cineholic.spotlight.repositories.TicketRepository;

import jakarta.transaction.Transactional;

@Service
public class PurchaseRequestService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private CustomerRepository customerReposiry;
	
	@Autowired
	private SeatRepository seatRepository;
	
	
	@Transactional(rollbackOn = Exception.class)
	public PurchaseResponseDTO processRequest(PurchaseRequestDTO request) {
		
		Session session = sessionRepository.findById(request.getSessionId()).orElseThrow(() -> new RuntimeException("Session not found"));
		
		Customer customer = customerReposiry.findById(request.getCustomerId()).orElseThrow(() -> new RuntimeException("Client not found"));
		
		List<Ticket> list = new ArrayList<>();
		
		for(Long seatId : request.getSeatsId()) {
			
			Seat seat = seatRepository.findById(seatId).orElseThrow(() -> new RuntimeException("Seat not found"));
			
			if(ticketRepository.existsBySessionIdAndSeatId(request.getSessionId(), seatId)) {
				throw new RuntimeException("That seat is occupied: " + request.getSeatsId());
			}
			
			
			Ticket ti = new Ticket(null, session, seat, customer);
			
			list.add(ti);
			
		}
		
		ticketRepository.saveAll(list);
		
		return new PurchaseResponseDTO("Compra realizada", list);
	}
}
