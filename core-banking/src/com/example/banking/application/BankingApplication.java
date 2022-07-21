package com.example.banking.application;

import com.example.banking.domain.Account;
import com.example.banking.domain.Customer;
import com.example.banking.domain.exception.InsufficientBalanceException;

// Ctrl + Shift + F
// Ctrl + Shift + O
public class BankingApplication {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InsufficientBalanceException {
		System.out.println("Number of accounts is %d".formatted(Account.getCount()));
		//  i) Automatic/Stack/local/temporary variable
		// ii) reference variable -> Account	
		var acc = new Account("tr1", 10_000); 
		              // Heap Object
		System.out.println(acc.toString());
		acc.deposit(5_000);
		System.out.println(acc);
		acc.deposit(2_500);
		System.out.println(acc);
		try {
			acc.withdraw(3_500);
			System.out.println(acc);
			acc.withdraw(1_000_000);
			System.out.println(acc);
		} catch (InsufficientBalanceException e) {
			System.err.println("Problem: "+e.getMessage()+", deficit: "+e.getDeficit());
		} 
		
		//  i) Stack/local/temporary variable
		// ii) value-typed variable -> int (primitive type)	
		var age = 42;
		
		var jack = new Customer("1", "jack bauer");
		jack.addAccount(new Account("tr1", 10_000));
		jack.addAccount(new Account("tr2", 20_000));
		jack.addAccount(new Account("tr3", 30_000));
		System.out.println(jack.getAccounts().size());
		jack.removeAccount("tr4")
		    .ifPresent( account -> {
				try {
					account.withdraw(account.getBalance());
				} catch (InsufficientBalanceException e) {
					e.printStackTrace();
				}
			});
		var account = jack.findAccount("tr2");
		account.withdraw(1_000_000_000);
		// if (account != null)
		//   account.withdraw(1_000);
		jack.getAccount("tr5")
		    .ifPresent( hesap -> {
				try {
					hesap.withdraw(1_000);
				} catch (InsufficientBalanceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		System.out.println("Number of accounts is %d".formatted(Account.getCount()));
	}
}
