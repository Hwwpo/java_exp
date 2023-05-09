package com.mybank.domain;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }
    public void accumulateInterest() {
        balance += balance * interestRate;
    }
}
