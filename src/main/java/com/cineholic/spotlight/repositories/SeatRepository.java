package com.cineholic.spotlight.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineholic.spotlight.entities.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{
	
	public List<Seat> findByRoom_id(Long id);
}
