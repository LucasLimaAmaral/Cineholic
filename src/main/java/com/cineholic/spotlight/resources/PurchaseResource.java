package com.cineholic.spotlight.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineholic.spotlight.dtos.PurchaseRequestDTO;
import com.cineholic.spotlight.dtos.response.PurchaseResponseDTO;
import com.cineholic.spotlight.services.PurchaseRequestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseResource {
	
	@Autowired
	private PurchaseRequestService service;
	
	@PostMapping
	public ResponseEntity<PurchaseResponseDTO> postPurchase(@RequestBody @Valid PurchaseRequestDTO request){
		
		PurchaseResponseDTO response = service.processRequest(request);
		
		return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).body(response);
	}
	
}
