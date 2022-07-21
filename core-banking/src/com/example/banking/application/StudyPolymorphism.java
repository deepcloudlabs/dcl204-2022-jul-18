package com.example.banking.application;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.exception.InsufficientBalanceException;

@SuppressWarnings("unused")
public class StudyPolymorphism {

	public static void main(String[] args) throws InsufficientBalanceException {
		Account account ;
		
		if (ThreadLocalRandom.current().nextBoolean()) {
			account = new Account("tr1", 10_000);
		} else {
			account = new CheckingAccount("tr1", 10_000, 2_000);			
		}
		System.err.println(account.getClass());
		account.withdraw(3_000);
		
		List<Account> accounts = List.of(
				new Account("tr1", 10_000),
				new CheckingAccount("tr1", 10_000, 2_000)
		);
		
	}

}
