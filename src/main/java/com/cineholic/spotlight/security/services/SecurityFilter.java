package com.cineholic.spotlight.security.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cineholic.spotlight.entities.Customer;
import com.cineholic.spotlight.repositories.CustomerRepository;
import com.cineholic.spotlight.security.jwt.CustomerDetailsImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecurityFilter extends OncePerRequestFilter{
	
	@Autowired
	TokenSerivce tokenService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
		String token = recoverToken(request);
		String login = tokenService.validateToken(token);
		
		if(login != null) {
			Customer customer = customerRepository.findByEmail(login).orElseThrow(() -> new RuntimeException("usuario nao encontrado"));
			CustomerDetailsImpl customerImpl = new CustomerDetailsImpl(customer);
			
			Authentication authentication = new UsernamePasswordAuthenticationToken(customerImpl.getUsername(), null, customerImpl.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		filterChain.doFilter(request, response);
	}
	
	
	private String recoverToken(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		
		if(authHeader == null) return null;
		
		return authHeader.replace("Bearar ", "");
	}
}
