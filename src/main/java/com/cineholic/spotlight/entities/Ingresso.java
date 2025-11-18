package com.cineholic.spotlight.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Ingresso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	private Sessao sessao;
	
	@OneToOne
	private AssentoSessao assento;
	
	
	public Ingresso() {
		
	}

	public Ingresso(Long id, Sessao sessao, AssentoSessao assento) {
		super();
		this.id = id;
		this.sessao = sessao;
		this.assento = assento;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Sessao getSessao() {
		return sessao;
	}


	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}


	public AssentoSessao getAssento() {
		return assento;
	}


	public void setAssento(AssentoSessao assento) {
		this.assento = assento;
	}


	@Override
	public int hashCode() {
		return Objects.hash(assento, id, sessao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingresso other = (Ingresso) obj;
		return Objects.equals(assento, other.assento) && Objects.equals(id, other.id)
				&& Objects.equals(sessao, other.sessao);
	}
	
	
}
