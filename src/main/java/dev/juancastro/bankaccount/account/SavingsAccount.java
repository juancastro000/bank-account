package dev.juancastro.bankaccount.account;

import java.util.Locale;

public class SavingsAccount extends Account {
    private boolean active;

    public SavingsAccount(float balance, float annualRate) {
        super(balance, annualRate);
        active = balance >= 10000;
    }
    @Override
    public void monthlyStatement() {
        if (withdrawals > 4) {
            monthlyFee += (withdrawals - 4) * 1000;
        }
        super.monthlyStatement();
        updateStatus();
    }

    @Override
    public String print() {
        return String.format(Locale.US, "Balance: %.1f, Annual Rate: %.1f%% Active: %b, Deposits: %d, Withdrawals: %d", balance, annualRate * 100, active, deposits, withdrawals);
    }
    
    private void updateStatus() {
        active = balance >= 10000;
    }

    public boolean isActive() {
        return active;
    }
}