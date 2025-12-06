package com.cineholic.spotlight.dtos.response;

public class SessionResponseDTO {
	
	private String status;

	public SessionResponseDTO(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
