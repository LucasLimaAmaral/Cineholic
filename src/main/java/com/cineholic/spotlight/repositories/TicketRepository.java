package com.cineholic.spotlight.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineholic.spotlight.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

	List<Ticket> findBySession_id(Long id);

}
