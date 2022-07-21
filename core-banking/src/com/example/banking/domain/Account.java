package com.example.banking.domain;
// final
// 1. (instance/local) variable -> read-only variable
// 2. class/method -> cannot extend class/cannot override method
      // since java se 17, sealed

import com.example.banking.domain.exception.InsufficientBalanceException;

// Ctrl + Shift + +
// Alt + Shift + S
// DDD (Domain-Driven Design)
// class -> encapsulation
public class Account extends Object { // DDD -> Entity
	private static int count = 0;
	
	public static int getCount() {
		return count ;
	}
	// members: attribute + method
	// attributes -> state -> information hiding
	// identity
	// i) instance variable (Heap) ii) reference variable
	private final String iban; 
	// i) instance variable (Heap) ii) value-typed variable
	protected double balance; 
	private AccountStatus status = AccountStatus.ACTIVE;
	

	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	// public methods
	// 2 Overloaded (1) Constructors
	public Account(String iban, double balance) {
		count++;
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
	public final double deposit(final double amount) throws IllegalArgumentException {
		// validation 
		if (amount <= 0.0) 
			throw new IllegalArgumentException("Amount must be positive");
		// this.balance = this.balance + amount;
		this.balance += amount;
		return balance;
	}
	
	public double withdraw(final double amount) throws InsufficientBalanceException {
		System.err.println("Account::withdraw");
		// validation
		if (amount <= 0.0) 
			throw new IllegalArgumentException("Amount must be positive");
		// business rule
		if (amount > this.balance) 
			throw new InsufficientBalanceException(
					"Your balance does not cover expenses",amount-balance);
		//this.balance = this.balance - amount;
		this.balance -= amount;
		return balance;
	}
	
	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}
	
	
}