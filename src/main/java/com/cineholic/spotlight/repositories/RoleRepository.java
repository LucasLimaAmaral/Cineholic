package com.cineholic.spotlight.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineholic.spotlight.entities.Role;
import com.cineholic.spotlight.enums.ERole;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Optional<Role> findByName(ERole name);
}
