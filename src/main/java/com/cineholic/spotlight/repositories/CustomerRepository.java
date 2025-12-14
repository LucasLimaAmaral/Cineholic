package com.cineholic.spotlight.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cineholic.spotlight.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query(value = """
			SELECT COUNT(*) > 0
			FROM customer c
			WHERE c.email = :newEmail
			""", nativeQuery = true)
	boolean existByEmail(@Param("newEmail")String newEmail);
	
	Optional<Customer> findByEmail(String email);
	
	boolean existByName(String name);
}
