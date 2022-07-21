package com.example.banking.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class Customer {
	// 1) attributes -> information hiding: private + getter->immutable
	private final String identityNo;
	private String fullName;
	private Map<String, Account> accounts = new HashMap<>();

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
		return accounts.values().stream().toList(); // immutable
		// return accounts; // violates information hiding principle
	}

	// 4. business method
	public void addAccount(Account account) {
		this.accounts.put(account.getIban(), account);
	}

	public Optional<Account> removeAccount(String iban) {
		return Optional.ofNullable(accounts.remove(iban));
	}

	public Optional<Account> getAccount(String iban) {
		return Optional.ofNullable(accounts.get(iban));
	}

	public Account findAccount(String iban) {
		return accounts.get(iban);
	}

	public double getTotalBalance() {
		return accounts.values().stream().mapToDouble(Account::getBalance).sum();
	}
}