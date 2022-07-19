package com.example.banking.domain;
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
	public boolean withdraw(double amount) {
		System.err.println("CheckingAccount::withdraw");
		if (amount <= 0.0) return false;
		if (amount > (balance + overdraftAmount)) return false;
		this.balance -= amount;
		return true;
	}

	@Override
	public String toString() {
		return "CheckingAccount [overdraftAmount=" + overdraftAmount + ", balance=" + balance + ", iban="
				+ getIban() + "]";
	}


   
	
}
