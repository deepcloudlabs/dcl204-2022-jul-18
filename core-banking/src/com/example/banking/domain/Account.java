package com.example.banking.domain;
// final
// 1. (instance/local) variable -> read-only variable
// 2. class/method -> cannot extend class/cannot override method
      // since java se 17, sealed

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
	public final boolean deposit(final double amount) {
		// validation
		if (amount <= 0.0) return false;
		// this.balance = this.balance + amount;
		this.balance += amount;
		return true;
	}
	
	public boolean withdraw(final double amount) {
		System.err.println("Account::withdraw");
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