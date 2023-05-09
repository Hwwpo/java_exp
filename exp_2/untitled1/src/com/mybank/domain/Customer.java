package com.mybank.domain;

public class Customer {
    private String firstName;
    private String lastName;
    private Account [] accounts;
    private int numberOfAccounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new Account[10];
        this.numberOfAccounts = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean addAccount(double amt) {
        if(numberOfAccounts < 9) {
            accounts[numberOfAccounts++] = new Account(amt);
            return true;
        }
        System.out.println("账户满了");
        return false;
    }

    public boolean addAccount(Account acc) {
        if(numberOfAccounts < 9) {
            accounts[numberOfAccounts++] = acc;
            return true;
        }
        return false;
    }

    public int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public Account getAccounts(int index) {
        return accounts[index];
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
