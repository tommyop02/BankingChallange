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

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void showCustomers() {
        System.out.println("List of customers for branch " + name + ".");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(i + ". " + customers.get(i).getName());
        }
    }

    public void addNewCustomer(String customerName, Double initialTransactionAmount) {
        Customer customer = Customer.createCustomer(customerName,initialTransactionAmount);
        customers.add(customer);

    }

    public void addTransaction(String name, Double transaction) {
        int customerID = findCustomerID(name);
        Customer customer = customers.get(customerID);
        customer.addTransaction(transaction);
        System.out.println("Transaction added successfully.");
    }

    public boolean exists(String customerName) {
        int customerID = findCustomerID(customerName);
        if(customerID >= 0){
            return true;
        } else return false;
    }

    private int findCustomerID(String name){
        int customerID = -1;
        for(int i=0; i<customers.size(); i++) {
            Customer customer = customers.get(i);
                    if(customer.getName().equals(name)) {
                        customerID = i;
                    }
        }
        return customerID;
    }

    public void findCustomerTransactions(String name) {
        int position = findCustomerID(name);
        Customer customer = customers.get(position);
        customer.showTransactions(customer);
    }

    public String getName() {
        return name;
    }
}