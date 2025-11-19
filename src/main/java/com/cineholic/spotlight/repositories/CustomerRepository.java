package com.cineholic.spotlight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineholic.spotlight.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
