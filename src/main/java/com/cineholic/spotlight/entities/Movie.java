package com.cineholic.spotlight.entities;

import java.io.Serializable;
import java.util.Objects;

import com.cineholic.spotlight.enums.Genre;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private Integer genre;
	private Integer duration;
	private String synopsis;
	private String posterUrl;
	
	public Movie() {
	}

	public Movie(Long id, String title, Genre genre, Integer duration, String synopsis, String posterUrl) {
		this.id = id;
		this.title = title;
		setGenre(genre);
		this.duration = duration;
		this.synopsis = synopsis;
		this.posterUrl = posterUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Genre getGenre() {
		return Genre.valueOf(genre);
	}

	public void setGenre(Genre genre) {
		if(genre != null) {
			this.genre = genre.getCode();
		}
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getPosterUrl() { 
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
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
		Movie other = (Movie) obj;
		return Objects.equals(id, other.id);
	}
}