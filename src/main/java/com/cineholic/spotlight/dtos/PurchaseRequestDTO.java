package com.cineholic.spotlight.dtos;

import java.util.List;
import java.util.Objects;

import jakarta.validation.constraints.NotNull;

public class PurchaseRequestDTO {
	
	@NotNull
	private Long sessionId;
	
	@NotNull
	private Long customerId;
	
	@NotNull
	private List<Long> seatsId;
	
	public PurchaseRequestDTO() {
		
	}

	public PurchaseRequestDTO(@NotNull Long sessionId, @NotNull Long customerId, @NotNull List<Long> seatsId) {
		super();
		this.sessionId = sessionId;
		this.customerId = customerId;
		this.seatsId = seatsId;
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<Long> getSeatsId() {
		return seatsId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, seatsId, sessionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseRequestDTO other = (PurchaseRequestDTO) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(seatsId, other.seatsId)
				&& Objects.equals(sessionId, other.sessionId);
	}
	
	
}
