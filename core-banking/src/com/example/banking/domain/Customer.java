package com.example.banking.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	// 1) attributes -> information hiding: private + getter->immutable
	private final String identityNo;
	private String fullName;
	private List<Account> accounts = new ArrayList<>();

	// 2) constructors
	public Customer(String identityNo, String fullName) {
		this.identityNo = identityNo;
		this.fullName = fullName;
	}

	// 3) getter (Immutable) / setter -> business method
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public List<Account> getAccounts() { // violates information hiding principle
		return accounts;
	}

	// 4. business method

}
