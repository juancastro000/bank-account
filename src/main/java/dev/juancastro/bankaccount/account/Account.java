package dev.juancastro.bankaccount.account;

public abstract class Account {
    protected float balance;
    protected int deposits;
    protected int withdrawals;
    protected float annualRate;
    protected float monthlyFee;

    public Account(float balance, float annualRate) {
        this.balance = balance;
        this.annualRate = annualRate;
    }

    public abstract String print();

    public void deposit(float amount) {
        balance += amount;
        deposits++;
    }

    public void withdraw(float amount) {
        if (amount <= balance) {
            balance -= amount;
            withdrawals++;
        }
    }
}