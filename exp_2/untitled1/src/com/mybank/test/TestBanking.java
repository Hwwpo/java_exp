package com.mybank.test;

import com.mybank.domain.*;

import java.util.Scanner;

public class TestBanking {
    public static void main(String[] args) {
        Customer customer;
        Bank.addCustomer("Tom", "Green");
        customer = Bank.getCustomers(0);
        customer.addAccount(2000);  // 存 2000 元

        Bank.addCustomer("Marry", "White");
        customer = Bank.getCustomers(1);
        customer.addAccount(new SavingsAccount(1000, 0.005));

        Bank.addCustomer("Ming", "Li");
        customer = Bank.getCustomers(2);
        customer.addAccount(new CheckingAccount(10000, 5000));

        Scanner sc = new Scanner(System.in);

        for(int customer_index = 0; customer_index < Bank.getNumberOfCustomers(); customer_index++) {
            customer = Bank.getCustomers(customer_index);
            System.out.println(customer);
            String account_type="";
            for(int account_index=0; account_index<customer.getNumberOfAccounts(); account_index++) {
                Account account = customer.getAccounts(account_index);
                System.out.println("请输入取款金额");
                double amount = sc.nextDouble();
                if(account instanceof SavingsAccount) {
                    account_type = "SavingsAccount";
                    SavingsAccount sa = (SavingsAccount) account;
                    sa.accumulateInterest();
                    sa.withdraw(amount);
                }
                else if(account instanceof CheckingAccount) {
                    account_type = "CheckingAccount";
                    CheckingAccount ca = (CheckingAccount) account;
                    ca.withdraw(amount);
                }
                else {
                    account_type="Unknown type";
                    account.withdraw(amount);
                }
                System.out.println("账户类型" + account_type + "，账户余额：" + account.getBalance());
            }
        }
    }
}
