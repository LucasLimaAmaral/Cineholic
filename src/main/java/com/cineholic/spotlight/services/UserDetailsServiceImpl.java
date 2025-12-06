package com.cineholic.spotlight.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cineholic.spotlight.entities.Customer;
import com.cineholic.spotlight.entities.UserDetailsImpl;
import com.cineholic.spotlight.repositories.CustomerRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
		return new UserDetailsImpl(customer);
	}
	
}
