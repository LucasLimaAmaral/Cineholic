package com.cineholic.spotlight.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineholic.spotlight.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{
	
	public List<Session> findByMovie_id(Long id);
}
