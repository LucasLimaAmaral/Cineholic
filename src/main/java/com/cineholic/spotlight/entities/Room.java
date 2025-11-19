package com.cineholic.spotlight.entities;

import java.io.Serializable;
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
public class Room implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String number;
	private Integer capacity;
	
	@JsonIgnore
	@OneToMany(mappedBy = "room")
	private List<Session> sessions = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "room")
	private List<Seat> seats = new ArrayList<>();
	
	public Room() {
	}

	public Room(Long id, String number, Integer capacity) {
		super();
		this.id = id;
		this.number = number;
		this.capacity = capacity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacity, id, number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(capacity, other.capacity) && Objects.equals(id, other.id)
				&& Objects.equals(number, other.number);
	}
}