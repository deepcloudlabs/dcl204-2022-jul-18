package com.example.banking.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.example.banking.domain.exception.CustomerNotFoundException;

public final class Bank {
	private final Long id;
	private String name;
	private final Map<String, Customer> customers = new HashMap<>();

	// Constructor(id,name)
	public Bank(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public Collection<Customer> getCustomers() {
		return customers.values();
	}

	public Customer createCustomer(String identity, String fullname) {
		var customer = new Customer(identity, fullname);
		customers.put(identity,customer);
		return customer;
	}

	public Optional<Customer> getCustomer(String identity) {
		return Optional.ofNullable(customers.get(identity));
	}

	public Customer findCustomer(String identity) {
		return getCustomer(identity).orElseThrow(() -> new CustomerNotFoundException(identity));
	}

	public Optional<Customer> deleteCustomer(String identity) {
		return Optional.ofNullable(customers.remove(identity));
	}

	public double getTotalBalance() {
		return customers.values()
				        .stream()
				        .parallel()
				        .mapToDouble(Customer::getTotalBalance)
				        .sum();
	}
}
