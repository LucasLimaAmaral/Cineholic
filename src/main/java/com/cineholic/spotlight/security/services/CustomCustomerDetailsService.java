package com.cineholic.spotlight.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cineholic.spotlight.entities.Customer;
import com.cineholic.spotlight.repositories.CustomerRepository;
import com.cineholic.spotlight.security.jwt.CustomerDetailsImpl;

@Service
public class CustomCustomerDetailsService implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Customer customer = customerRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("usuario nao encontrado"));
		return new CustomerDetailsImpl(customer);
	}
	
}
