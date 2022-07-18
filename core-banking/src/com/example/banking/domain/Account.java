package com.example.banking.domain;

// Ctrl + Shift + +
// Alt + Shift + S
// DDD (Domain-Driven Design)
// class -> encapsulation
public class Account extends Object { // DDD -> Entity
	// members: attribute + method
	// attributes -> state -> information hiding
	// identity
	// i) instance variable (Heap) ii) reference variable
	private final String iban; 
	// i) instance variable (Heap) ii) value-typed variable
	private double balance; 
	// public methods
	// 2 Overloaded (1) Constructors
	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}
	public Account(String iban) {
		// delegates the initialization to the first constructor
		this(iban,10); 
	}
	// (2) getter 
	public String getIban() {
		return iban;
	}
	public double getBalance() {
		return balance;
	}
	
	// (3) business methods
	public boolean deposit(double amount) {
		// validation
		if (amount <= 0.0) return false;
		// this.balance = this.balance + amount;
		this.balance += amount;
		return true;
	}
	
	public boolean withdraw(double amount) {
		// validation
		if (amount <= 0.0) return false;
		// business rule
		if (amount > this.balance) return false;
		//this.balance = this.balance - amount;
		this.balance -= amount;
		return true;
	}
	
	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}
	
	
}