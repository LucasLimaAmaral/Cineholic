package com.cineholic.spotlight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineholic.spotlight.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{

}
