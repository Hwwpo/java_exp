package com.mybank.domain;

public class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amt) {
        if(amt >= 0) {
            this.balance += amt;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amt) {
        if(amt <= this.balance) {
            this.balance -= amt;
            return true;
        }
        System.out.println("余额不足");
        return false;
    }

    public double getBalance() {
        return balance;
    }
}
