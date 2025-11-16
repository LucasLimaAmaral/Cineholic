package com.cineholic.spotlight.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Filme implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String genero;
	private Double duration;
	private String sinopse;
	private String cartazUrl;
	
	public Filme() {
		
	}


	public Filme(Long id, String titulo, String genero, Double duration, String sinopse, String cartazUrl) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.duration = duration;
		this.sinopse = sinopse;
		this.cartazUrl = cartazUrl;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Double getDuration() {
		return duration;
	}


	public void setDuration(Double duration) {
		this.duration = duration;
	}


	public String getSinopse() {
		return sinopse;
	}


	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}


	public String getCartazUrl() {
		return cartazUrl;
	}


	public void setCartazUrl(String cartazUrl) {
		this.cartazUrl = cartazUrl;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cartazUrl, duration, genero, id, sinopse, titulo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(cartazUrl, other.cartazUrl) && Objects.equals(duration, other.duration)
				&& Objects.equals(genero, other.genero) && Objects.equals(id, other.id)
				&& Objects.equals(sinopse, other.sinopse) && Objects.equals(titulo, other.titulo);
	}
	
	
	
}
