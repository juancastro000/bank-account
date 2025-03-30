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

    @Test
    void deposit_shouldIncreaseBalanceAndDeposits() {
        Account account = new SavingsAccount(15000, 0.12f);

        account.deposit(3000);

        assertThat(account.print(), containsString("Balance: 18000.0"));
        assertThat(account.print(), containsString(" Total Transactions: 1"));
    }

    @Test
    void withdraw_shouldDecreaseBalanceAndIncreaseWithdrawals() {
        Account account = new SavingsAccount(10000, 0.12f);

        account.withdraw(2000);

        assertThat(account.print(), containsString("Balance: 8000.0"));
        assertThat(account.print(), containsString(" Total Transactions: 1"));
    }

    @Test
    public void testMonthlyStatementCalculatesInterestCorrectly() {
        SavingsAccount account = new SavingsAccount(15000, 12);
        account.deposit(0); 
        account.withdraw(0); 
        account.monthlyFee = 0;
        
        account.monthlyStatement();
    
       
        assertThat(account.print(), containsString("Balance: 15150.0"));
        assertThat(account.print(), containsString("Total Transactions: 0"));
    }
}