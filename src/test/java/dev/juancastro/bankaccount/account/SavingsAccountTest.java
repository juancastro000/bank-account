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
}
