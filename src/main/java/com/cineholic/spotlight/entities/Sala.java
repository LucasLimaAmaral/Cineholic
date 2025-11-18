package com.cineholic.spotlight.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Sala implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numero;
	private Integer capacidade;
	
	@OneToMany(mappedBy = "sala")
	private List<Sessao> sessoes = new ArrayList<>();
	
	public Sala() {
		
	}

	public Sala(Long id, String numero, Integer capacidade) {
		super();
		this.id = id;
		this.numero = numero;
		this.capacidade = capacidade;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Integer getCapacidade() {
		return capacidade;
	}


	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}


	@Override
	public int hashCode() {
		return Objects.hash(capacidade, id, numero);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(capacidade, other.capacidade) && Objects.equals(id, other.id)
				&& Objects.equals(numero, other.numero);
	}
	
	
}
