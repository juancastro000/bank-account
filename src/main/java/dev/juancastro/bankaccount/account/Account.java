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

    public void calculateMonthlyInterest() {
        float monthlyInterestRate = (annualRate / 100) / 12;
        float interest = balance * monthlyInterestRate;
        balance += interest;
    }

    public void monthlyStatement() {
        balance -= monthlyFee;
        calculateMonthlyInterest();
        deposits = 0;
        withdrawals = 0;
        monthlyFee = 0;
    }
}