package dev.juancastro.bankaccount.account;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    @Test
    void savingsAccountUnder10000_shouldBeInactive() {
        SavingsAccount account = new SavingsAccount(9999, 0.12f);

        assertThat(account.print(), containsString("Active: false"));
    }

    @Test
    public void testDepositWhenInactive() {
        SavingsAccount account = new SavingsAccount(8000, 12);
        account.deposit(2000);
        String info = account.print();
        assertThat(info, containsString("Balance: 8000.0"));
        assertThat("account inactive", account.isActive(), is(false));
    }

    @Test
    public void testWithdrawCausingInactiveState() {
        SavingsAccount account = new SavingsAccount(15000, 12);
        account.withdraw(5001);
        String info = account.print();
        assertThat(info, containsString("Balance: 9999.0"));
        assertThat("account should be inactive", account.isActive(), is(false));
    }
}
