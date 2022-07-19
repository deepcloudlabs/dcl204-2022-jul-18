package com.example.banking.domain;
// Account         -> super-class / base class
// CheckingAccount -> sub-class   / derived class
public class CheckingAccount extends Account {
     private double overdraftAmount;

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}
     
}
