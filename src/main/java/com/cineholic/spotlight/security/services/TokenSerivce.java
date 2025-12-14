package com.cineholic.spotlight.security.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cineholic.spotlight.entities.Customer;

@Service
public class TokenSerivce {
	

	@Value("${api.security.token.secret}") 
	private String secret;
	
	public String generatedToken(Customer costumer) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
			String token = JWT.create()
					.withIssuer("spotlight")
					.withSubject(costumer.getEmail())
					.withExpiresAt(this.generateExpirationDate())
					.sign(algorithm);
			return token;
		}catch(JWTCreationException ex){
			throw new RuntimeException("Erro enquanto eutenticando");
		}
	}
	
	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
			return JWT.require(algorithm)
					.withIssuer("spotlight")
					.build()
					.verify(token)
					.getSubject();
			
		}catch(JWTVerificationException ex){
			return null;
		}
	}
	
	
	private Instant generateExpirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-3"));
	}
}
