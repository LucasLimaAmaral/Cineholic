package com.cineholic.spotlight.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Sessao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime horario;
	private Double preco;
	
	private Filme filme;
	private Sala sala;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sessao")
	private List<AssentoSessao> assentos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "sessao")
	private List<Ingresso> ingressos = new ArrayList<Ingresso>();
	
	public Sessao() {
		
	}

	public Sessao(Long id, LocalDateTime horario, Double preco, Filme filme, Sala sala) {
		super();
		this.id = id;
		this.horario = horario;
		this.preco = preco;
		this.filme = filme;
		this.sala = sala;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sessao other = (Sessao) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
