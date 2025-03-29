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
}
