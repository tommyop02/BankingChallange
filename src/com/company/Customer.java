package com.company;
/*
 * ----------------------------------------------------------------------------
 * "THE BEER-WARE LICENSE" (Revision 42):
 * <tommyop02@gmail.com> wrote this file.  As long as you retain this notice you
 * can do whatever you want with this stuff. If we meet some day, and you think
 * this stuff is worth it, you can buy me a beer in return.   tommyop02
 * ----------------------------------------------------------------------------
 */


import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, Double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        this.transactions.add(initialTransaction);
    }

    public void addTransaction(Double transaction) {
        transactions.add(transaction);
    }

    public void showTransactions(Customer customer) {
        transactions = customer.getTransactions();
        System.out.println("Transactions recorded to date for customer " +
                customer.getName());
        for(int i=0; i<transactions.size(); i++) {
            System.out.println(i + ". $" + transactions.get(i));
        }

    }
    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public static Customer createCustomer(String name, Double initialTransaction) {
        return new Customer(name, initialTransaction);
    }
}