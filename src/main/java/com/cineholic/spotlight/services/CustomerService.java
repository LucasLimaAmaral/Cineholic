package com.cineholic.spotlight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.entities.Customer;
import com.cineholic.spotlight.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	public List<Customer> findAll(){
		return repository.findAll();
	}
	
	public Customer findById(Long id) {
		Optional<Customer> obg = repository.findById(id);
		return obg.get();
	}
}
