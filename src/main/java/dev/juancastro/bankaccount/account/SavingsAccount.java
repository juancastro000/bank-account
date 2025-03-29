package dev.juancastro.bankaccount.account;

import java.util.Locale;

public class SavingsAccount extends Account {
    public SavingsAccount(float balance, float annualRate) {
        super(balance, annualRate);
    }

    @Override
    public String print() {
        return String.format(Locale.US, "Balance: %.1f, Annual Rate: %.1f%% Deposits: %d", balance, annualRate * 100, deposits);
    }
}