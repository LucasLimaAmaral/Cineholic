package com.cineholic.spotlight.entities;

import java.io.Serializable;
import java.util.Objects;

import com.cineholic.spotlight.enums.AssentoStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AssentoSessao implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numero;
	private AssentoStatus status;
	
	
	private Sessao sessao;
	
	public AssentoSessao() {
		
	}

	public AssentoSessao(Long id, Integer numero, AssentoStatus status, Sessao sessao) {
		super();
		this.id = id;
		this.numero = numero;
		this.status = status;
		this.sessao = sessao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public AssentoStatus getStatus() {
		return status;
	}

	public void setStatus(AssentoStatus status) {
		this.status = status;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, numero, sessao, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssentoSessao other = (AssentoSessao) obj;
		return Objects.equals(id, other.id) && Objects.equals(numero, other.numero)
				&& Objects.equals(sessao, other.sessao) && status == other.status;
	}
	
	
}
