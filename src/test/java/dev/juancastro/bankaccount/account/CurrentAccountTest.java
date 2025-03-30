package dev.juancastro.bankaccount.account;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    @Test
    void withdrawOverdraft_shouldIncreaseOverdraft() {
        CurrentAccount account = new CurrentAccount(5000, 0.12f);

        account.withdraw(6000);

        assertThat(account.print(), containsString("Overdraft: 1000.0"));
    }
    @Test
    public void testWithdrawWithOverdraft() {
        CurrentAccount account = new CurrentAccount(3000, 12);
        account.withdraw(4000);
        String info = account.print();
        assertThat(info, containsString("Balance: 0.0"));
        assertThat("overdraft should be 1000",(double) account.getOverdraft(), is(closeTo(1000.0, 0.001)));
    }
    @Test
    public void testDepositReducesOverdraft() {
        CurrentAccount account = new CurrentAccount(3000, 12);
        account.withdraw(4000); 
        account.deposit(500);   
        String info = account.print();
        assertThat(info, containsString("Overdraft: 500.0"));
    }
}
