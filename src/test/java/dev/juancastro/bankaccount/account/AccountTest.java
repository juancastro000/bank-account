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
        Account account = new SavingsAccount(5000, 0.12f);

        account.deposit(3000);

        assertThat(account.print(), containsString("Balance: 8000.0"));
        assertThat(account.print(), containsString("Deposits: 1"));
    }

    @Test
    void withdraw_shouldDecreaseBalanceAndIncreaseWithdrawals() {
        Account account = new SavingsAccount(10000, 0.12f);

        account.withdraw(2000);

        assertThat(account.print(), containsString("Balance: 8000.0"));
        assertThat(account.print(), containsString("Withdrawals: 1"));
    }
}