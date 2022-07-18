package com.example.banking.application;

import com.example.banking.domain.Account;

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
	}
}
