package com.cineholic.spotlight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineholic.spotlight.entities.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

}
