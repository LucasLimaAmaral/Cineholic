package com.cineholic.spotlight.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineholic.spotlight.dtos.CustomerDTO;
import com.cineholic.spotlight.dtos.CustomerResponseDTO;
import com.cineholic.spotlight.entities.Customer;
import com.cineholic.spotlight.services.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll(){
		List<Customer> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id){
		Customer obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<CustomerResponseDTO> postCustomer(@RequestBody @Valid CustomerDTO dto){
		CustomerResponseDTO response = service.addCustomer(dto);
		
		return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).body(response);
	}
}
