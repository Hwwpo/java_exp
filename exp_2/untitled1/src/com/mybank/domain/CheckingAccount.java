package com.mybank.domain;

public class CheckingAccount extends Account {
    private double overdraftAmount;

    public CheckingAccount(double balance, double overdraftAmount) {
        super(balance);
        this.overdraftAmount = overdraftAmount;
    }

    public CheckingAccount(double balance) {
        super(balance);
        this.overdraftAmount = 0.0;
    }

    public double getOverdraftAmount() {
        return overdraftAmount;
    }

    @Override
    public boolean withdraw(double amt) {
        boolean flag = true;
        if(balance < amt) {
            double overdraftNeeded = amt - balance;
            if(overdraftNeeded > overdraftAmount) {
                System.out.println("允许透支的额度不足，交易失败");
                flag = false;
            }
            else {
                balance = 0.0;
                overdraftAmount -= overdraftNeeded;
            }
        }
        else {
            balance -= amt;
        }
        return flag;
    }
}
