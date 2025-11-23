package com.cineholic.spotlight.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public class SessionDTO {
	
	@NotNull
	private LocalDateTime moment; 
	
	@NotNull
	private Double price;
	
	@NotNull
	private Long movieId;
	
	@NotNull
	private Long roomId;
	
	public SessionDTO() {
		
	}

	public SessionDTO(@NotNull LocalDateTime moment, @NotNull Double price, @NotNull Long movieId,
			@NotNull Long roomId) {
		super();
		this.moment = moment;
		this.price = price;
		this.movieId = movieId;
		this.roomId = roomId;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	
	
}
