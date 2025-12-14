package com.cineholic.spotlight.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineholic.spotlight.repositories.CustomerRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private TokenService tokenSerivce;
	
	
	
}
