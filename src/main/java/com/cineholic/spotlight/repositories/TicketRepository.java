package com.cineholic.spotlight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineholic.spotlight.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
