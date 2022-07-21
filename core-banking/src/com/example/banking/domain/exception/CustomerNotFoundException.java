package com.example.banking.domain.exception;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException {

	private final String identity;

	public CustomerNotFoundException(String identity) {
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}

}
