package dev.juancastro.bankaccount.account;

import java.util.Locale;

public class CurrentAccount extends Account {
    private float overdraft;

    public CurrentAccount(float balance, float annualRate) {
        super(balance, annualRate);
    }

    @Override
    public void withdraw(float amount) {
        float possibleOverdraft = amount - balance;
        if (possibleOverdraft > 0) {
            balance = 0;
            overdraft += possibleOverdraft;
        } else {
            balance -= amount;
        }
        withdrawals++;
    }

    @Override
    public String print() {
        return String.format(Locale.US,
            "Balance: %.1f, Overdraft: %.1f", 
            balance, overdraft
        );
    }
}