package com.cineholic.spotlight.entities;

import com.cineholic.spotlight.enums.RoleName;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Enumerated(EnumType.STRING)
	private RoleName name;

	public Role() {
	}

	public Role(RoleName name) {
		this.name = name;
	}


	public long getId() {
		return id;
	}


	public RoleName getName() {
		return name;
	}
	
	
}
