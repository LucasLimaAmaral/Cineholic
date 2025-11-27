package com.cineholic.spotlight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpotlightApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotlightApplication.class, args);
	}

}
