package com.example.banking.domain;

import com.example.banking.domain.exception.InsufficientBalanceException;

// Account         -> super-class / base class
// CheckingAccount -> sub-class   / derived class
public class CheckingAccount extends Account { // Single Inheritance
     private final double overdraftAmount;

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	@Override
	public double withdraw(double amount) throws InsufficientBalanceException {
		System.err.println("CheckingAccount::withdraw");
		if (amount <= 0.0) 
			throw new IllegalArgumentException("Amount must be positive");
		final double maxBalance = balance + overdraftAmount;
		if (amount > maxBalance) 
			throw new InsufficientBalanceException(
					"Your balance does not cover expenses",amount-maxBalance);			
		this.balance -= amount;
		return balance;
	}
	
	@Override
	public String toString() {
		return "CheckingAccount [overdraftAmount=" + overdraftAmount + ", balance=" + balance + ", iban="
				+ getIban() + "]";
	}


   
	
}
