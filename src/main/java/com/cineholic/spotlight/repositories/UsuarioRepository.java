package com.cineholic.spotlight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineholic.spotlight.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
