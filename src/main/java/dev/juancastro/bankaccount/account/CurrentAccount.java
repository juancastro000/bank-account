package dev.juancastro.bankaccount.account;

import java.util.Locale;

public class CurrentAccount extends Account {
    private float overdraft;

    public CurrentAccount(float balance, float annualRate) {
        super(balance, annualRate);
    }

    @Override
    public void deposit(float amount) {
        if (amount > 0) {
            if (overdraft > 0) {
                if (amount >= overdraft) {
                    amount -= overdraft;
                    overdraft = 0;
                    super.deposit(amount);
                } else {
                    overdraft -= amount;
                }
            } else {
                super.deposit(amount);
            }
        }
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
        int totalTransactions = deposits + withdrawals;
        return String.format(Locale.US, 
                "Balance: %.1f, Annual Rate: %.1f%%, Deposits: %d, Withdrawals: %d, Monthly Fee: %.1f, Total Transactions: %d, Overdraft: %.1f",
                balance, annualRate, deposits, withdrawals, monthlyFee, totalTransactions, overdraft);
    }
    public float getOverdraft() {
        return overdraft;
    }
}