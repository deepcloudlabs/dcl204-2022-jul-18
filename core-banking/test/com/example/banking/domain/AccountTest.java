package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountTest { // CUT (Class Under Test) -> Account

	@Order(value = 1)
	@DisplayName("create an account with iban and balance successfuly")
	@ParameterizedTest 
	@CsvFileSource(resources = "accounts.csv")
	void createAccountSuccessfully(String iban, double balance) throws Exception {
		// 1. fixture/setup
		// 2. call exercise method
		var account = new Account(iban, balance);
		// 3. verification
		assertAll(() -> assertEquals(iban, account.getIban()), () -> assertEquals(balance, account.getBalance()));
		// 4. destroy setup
	}
	
	@Order(value = 2)
	@DisplayName("create an account with iban")
	@ParameterizedTest 
	@CsvSource({
	    "tr1", "tr2", "tr3"	
	})
	void createAccountWithNoBalanceSuccessfully(String iban) throws Exception {
		// 1. fixture/setup
		// 2. call exercise method
		var account = new Account(iban);
		// 3. verification
		assertAll(() -> assertEquals(iban, account.getIban()), () -> assertEquals(10.0, account.getBalance()));
		// 4. destroy setup
	}

	@Order(value = 3)
	@DisplayName("toString() should i) start with Account ii) contain iban= and balance= ")
	@ParameterizedTest 
	@CsvSource({
		"tr1", "tr2", "tr3"	
	})
	void toStringTest(String iban) throws Exception {
		// 1. fixture/setup
		// 2. call exercise method
		var account = new Account(iban);
		// 3. verification
		assertAll(
				() -> assertTrue(account.toString().startsWith("Account")), 
				() -> assertTrue(account.toString().contains("iban=")),
				() -> assertTrue(account.toString().contains("balance="))
		);
		// 4. destroy setup
	}

	@Order(value = 10)
	@ParameterizedTest 
	@CsvFileSource(resources = "withdraw-negative.csv")
	@DisplayName("""
				withdraw with negative amount should fail
			""")
	void withdrawWithNegativeAmountShouldFail(String iban, double balance, double amount) throws Exception {
		// 1. fixture/setup
		var account = new Account(iban, balance);
		// 2. call exercise method
		var result = account.withdraw(amount);
		// 3. verification
		assertAll(() -> assertFalse(result), () -> assertEquals(balance, account.getBalance(), Double.MIN_NORMAL));
		// 4. destroy setup
	}

	@Order(value = 12)
	@ParameterizedTest 
	@CsvFileSource(resources = "withdraw-over-balance.csv")
	@DisplayName("""
				withdraw with amount larger than the balance should fail
			""")
	void withdrawOverBalanceShouldFail(String iban, double balance, double amount) throws Exception {
		// 1. fixture/setup
		var account = new Account(iban, balance);
		// 2. call exercise method
		var result = account.withdraw(amount);
		// 3. verification
		assertAll(() -> assertFalse(result), () -> assertEquals(balance, account.getBalance(), Double.MIN_NORMAL));
		// 4. destroy setup
	}
	
	@Order(value = 16)
	@ParameterizedTest 
	@CsvFileSource(resources = "withdraw-all.csv")
	@DisplayName("""
				withdraw all should success
			""")
	void withdrawAllBalanceShouldSuccess(String iban, double balance) throws Exception {
		// 1. fixture/setup
		var account = new Account(iban, balance);
		// 2. call exercise method
		var result = account.withdraw(balance);
		// 3. verification
		assertAll(() -> assertTrue(result), () -> assertEquals(0.0, account.getBalance(), Double.MIN_NORMAL));
		// 4. destroy setup
	}

	@Order(value = 20)
	@ParameterizedTest 
	@CsvFileSource(resources = "deposit-negative.csv")
	@DisplayName("""
			deposit with negative amount should fail
			""")
	void depositWithNegativeAmountShouldFail(String iban, double balance, double amount) throws Exception {
		// 1. fixture/setup
		var account = new Account(iban, balance);
		// 2. call exercise method
		var result = account.deposit(amount);
		// 3. verification
		assertAll(() -> assertFalse(result), () -> assertEquals(balance, account.getBalance(), Double.MIN_NORMAL));
		// 4. destroy setup
	}
	
	@Order(value = 22)
	@ParameterizedTest 
	@CsvFileSource(resources = "deposit-positive.csv")
	@DisplayName("""
			deposit with positive amount should success
			""")
	void depositWithPositiveAmountShouldSuccess(String iban, double balance, double amount,double finalBalance) throws Exception {
		// 1. fixture/setup
		var account = new Account(iban, balance);
		// 2. call exercise method
		var result = account.deposit(amount);
		// 3. verification
		assertAll(() -> assertTrue(result), () -> assertEquals(finalBalance, account.getBalance(), Double.MIN_NORMAL));
		// 4. destroy setup
	}
}

