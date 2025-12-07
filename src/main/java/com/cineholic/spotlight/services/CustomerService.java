package com.cineholic.spotlight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.dtos.CustomerDTO;
import com.cineholic.spotlight.dtos.CustomerResponseDTO;
import com.cineholic.spotlight.entities.Customer;
import com.cineholic.spotlight.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Customer> findAll(){
		return repository.findAll();
	}
	
	public Customer findById(Long id) {
		Optional<Customer> obg = repository.findById(id);
		return obg.get();
	}
	
	public CustomerResponseDTO addCustomer(CustomerDTO request) {
		
		if(validator(request)) {
			throw new RuntimeException("Already exist an account with that email or the password and password confimation didnt match");
		}
		
		String name = request.getName();
		String email = request.getEmail();
		String hashPassword = passwordEncoder.encode(request.getPassword());
		
		Customer newCustomer = repository.save(new Customer(null, name, email, hashPassword));
		
		return new CustomerResponseDTO(newCustomer.getName(), newCustomer.getEmail());
	}
	
	private boolean validator(CustomerDTO request) {
		
		if( repository.existByEmail(request.getEmail()) || 
				request.getPassword() != request.getPasswordConfirm()) {
			return true;
		}
		
		return false;
		
	}
}
