package com.cineholic.spotlight.dtos;

import jakarta.validation.constraints.NotNull;

public class RoomDTO {
	
	@NotNull
	private String nome;
	
	@NotNull
	private Integer row;
	
	@NotNull
	private Integer column;
	
	public RoomDTO() {
		
	}

	public RoomDTO(String nome, Integer row, Integer column) {
		super();
		this.nome = nome;
		this.row = row;
		this.column = column;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}
	
	
}
