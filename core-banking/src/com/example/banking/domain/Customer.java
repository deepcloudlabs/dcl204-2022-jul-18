package com.example.banking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

	public List<Account> getAccounts() { 
		return Collections.unmodifiableList(accounts); // immutable
		// return accounts; // violates information hiding principle
	}

	// 4. business method
	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	
	public Optional<Account> removeAccount(String iban) {
		var optionalAccount = getAccount(iban);
		if (optionalAccount.isPresent())
			accounts.remove(optionalAccount.get());
		return optionalAccount;
	}
	
	public Optional<Account> getAccount(String iban) {
		for (Account account : accounts) {
			if (account.getIban().equals(iban)) {
				return Optional.of(account);	
			}
		}
		return Optional.empty();
	}
}
