package dev.juancastro.bankaccount.account;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class AccountTest {
    
    @Test
    void createAccount() {
        Account account = new SavingsAccount(10000, 0.12f); 
        
        assertThat(account.print(), containsString("Balance: 10000.0"));
        assertThat(account.print(), containsString("Annual Rate: 12.0%"));
    }
}