package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankTest {

	@Test
	@DisplayName("Create one customer with two accounts successfuly")
	void createBankAndOneCustomerSuccesfully() throws Throwable {
		var garanti = new Bank(1L, "Garanti BBVA");
		var jack = garanti.createCustomer("11111111110", "jack shephard");
		jack.addAccount(new Account("tr1", 10_000));
		jack.addAccount(new CheckingAccount("tr2", 20_000, 500));
		assertAll(
			() -> assertEquals(1L, garanti.getId()),	
			() -> assertEquals("Garanti BBVA", garanti.getName()),	
			() -> assertEquals(1, garanti.getCustomers().size()),	
			() -> assertTrue(garanti.getCustomer("11111111110").isPresent()),	
			() -> assertEquals(2,garanti.findCustomer("11111111110").getAccounts().size()),	
			() -> assertEquals(30_000,garanti.getTotalBalance(),Double.MIN_NORMAL)	
		);
	}

}
