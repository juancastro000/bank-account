package dev.juancastro.bankaccount.account;

import java.util.Locale;

public class SavingsAccount extends Account {
    private boolean active;

    public SavingsAccount(float balance, float annualRate) {
        super(balance, annualRate);
        active = balance >= 10000;
    }

    @Override
    public void deposit(float amount) {
        if (active && amount > 0) {
            super.deposit(amount);
            updateStatus();
        }
    }
    @Override
    public void withdraw(float amount) {
        if (active && amount > 0 && amount <= balance) {
            super.withdraw(amount);
            updateStatus();
        }
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
        int totalTransactions = deposits + withdrawals;
        return String.format(Locale.US, 
                "Balance: %.1f, Annual Rate: %.1f%%, Active: %b, Monthly Fee: %.1f, Total Transactions: %d", 
                balance, annualRate, active, monthlyFee, totalTransactions);
    }
    
    private void updateStatus() {
        active = balance >= 10000;
    }

    public boolean isActive() {
        return active;
    }
}