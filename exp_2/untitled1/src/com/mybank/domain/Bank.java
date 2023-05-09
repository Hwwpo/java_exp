package com.mybank.domain;

public class Bank {
    public static Customer [] customers;
    public static int numberOfCustomers;

    static {
        customers = new Customer[10];
        numberOfCustomers=0;
    }

    public static boolean addCustomer(String firstName, String lastName) {
        if(numberOfCustomers < 9) {
            customers[numberOfCustomers++]=new Customer(firstName, lastName);
            return true;
        }
        return false;
    }

    public static int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public static Customer getCustomers(int index) {
        return customers[index];
    }
}
