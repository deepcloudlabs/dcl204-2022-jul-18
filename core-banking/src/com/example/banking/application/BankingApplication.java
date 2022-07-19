package com.example.banking.application;

import com.example.banking.domain.Account;
import com.example.banking.domain.Customer;

// Ctrl + Shift + F
// Ctrl + Shift + O
public class BankingApplication {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//  i) Automatic/Stack/local/temporary variable
		// ii) reference variable -> Account	
		Account acc = new Account("tr1", 10_000); 
		              // Heap Object
		System.out.println(acc.toString());
		acc.deposit(5_000);
		System.out.println(acc);
		acc.deposit(2_500);
		System.out.println(acc);
		acc.withdraw(3_500);
		System.out.println(acc);
		acc.withdraw(1_000_000);
		System.out.println(acc);
		
		//  i) Stack/local/temporary variable
		// ii) value-typed variable -> int (primitive type)	
		int age = 42;
		
		var jack = new Customer("1", "jack bauer");
		jack.addAccount(new Account("tr1", 10_000));
		jack.addAccount(new Account("tr2", 20_000));
		jack.addAccount(new Account("tr3", 30_000));
		System.out.println(jack.getAccounts().size());
		jack.removeAccount("tr4")
		    .ifPresent( account -> account.withdraw(account.getBalance()));
		
	}
}
