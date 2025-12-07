package com.cineholic.spotlight.dtos;

import java.util.List;

import com.cineholic.spotlight.entities.Ticket;

public class PurchaseResponseDTO {

	private String resultado;
	private List<Ticket> compra;
	
	public PurchaseResponseDTO() {
		
	}

	public PurchaseResponseDTO(String resultado, List<Ticket> compra) {
		super();
		this.resultado = resultado;
		this.compra = compra;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<Ticket> getCompra() {
		return compra;
	}
	
	
}
