package com.cineholic.spotlight.dtos;

import com.cineholic.spotlight.enums.Genre;

import jakarta.validation.constraints.NotNull;

public class MovieDTO {
	
	@NotNull
	private String title;
	
	@NotNull
	private Integer genre;
	
	@NotNull
	private Integer duration;
	
	@NotNull
	private String synopsis;
	
	@NotNull
	private String posterUrl;
	
	public MovieDTO() {
	}

	public MovieDTO(String title, Genre genre, Integer duration, String synopsis, String posterUrl) {
		this.title = title;
		setGenre(genre);
		this.duration = duration;
		this.synopsis = synopsis;
		this.posterUrl = posterUrl;
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
}
