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

public class Bank {
    private ArrayList<Branch> branches;
    private String name;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public void addBranch(String name) {
        if(!exists(name)){
            Branch branch = new Branch(name);
            branches.add(branch);
            System.out.println("Branch " + name + " has been successfully added.");
        } else {
            System.out.println("Sorry, this branch has already been registered.");
        }
    }

    public void listBranches() {
        System.out.println("Here's a list of all registered branches for " + name + ".");
        for(int i=0; i<branches.size(); i++) {
            Branch branch = branches.get(i);
            System.out.println(branch.getName());
        }
    }

    private boolean exists(String branchName) {
        int branchID = findBranchID(branchName);
        if(branchID >= 0){
            return true;
        } else return false;
    }


    private int findBranchID(String name) {
        int branchID = -1;
        for(int i=0; i<branches.size(); i++) {
            Branch branch = branches.get(i);
            if(branch.getName().equals(name)) {
                branchID = i;
            }
        }
        return branchID;
    }

    public void findBranch(String name) {
        if(exists(name)) {
            System.out.println("Branch " + name + " found in our system.");
        } else {
            System.out.println("Sorry, branch not found. Check spelling or add branch as new.");
        }
    }

    public void branchCustomers(String branchName){
        if(exists(branchName)) {
            System.out.println("Branch found, loading customers list....");
            int branchID = findBranchID(branchName);
            Branch branch = branches.get(branchID);
            branch.showCustomers();
        } else {
            System.out.println("Sorry, branch not found. Check spelling or add branch as new.");
        }
    }

    public void addCustomer(String branchName, String customerName, Double initialDeposit) {
        if(exists(branchName)) {

            int branchID = findBranchID(branchName);
            Branch branch = branches.get(branchID);
            if(!branch.exists(customerName)){
                branch.addNewCustomer(customerName, initialDeposit);
                System.out.println("New customer " + customerName + " has been added to the " +
                        this.name + " " + branchName + " branch.");
            } else {
                System.out.println("Customer " + customerName +
                        " appears to be already registered with the " + branchName + " branch.");
            }

        } else {
            System.out.println("Sorry, branch not found. Check spelling or add branch as new.");
        }
    }

    public void customerTransactions(String branchName, String customer) {
        if(exists(branchName)) {
            int branchID = findBranchID(branchName);
            Branch selectedBranch = branches.get(branchID);
            if(selectedBranch.exists(customer)){
                System.out.println("Loading customer " + customer + " transactions....");
                selectedBranch.findCustomerTransactions(customer);
            } else {
                System.out.println("Customer " + customer + " is not registered with the "
                        + branchName + " branch.");
            }
        } else {
            System.out.println("Sorry, branch not found. Check spelling or add branch as new.");
        }
    }

    public void addCustomerTransaction(String branchName, String customerName, Double newTransaction) {
        if(exists(branchName)) {
            int branchID = findBranchID(branchName);
            Branch selectedBranch = branches.get(branchID);
            if(selectedBranch.exists(customerName)) {
                selectedBranch.addTransaction(customerName, newTransaction);
                System.out.println("New transaction for $" + newTransaction +
                        " has been added for customer " + customerName + " for the " +
                        branchName + " branch of " + this.name + " Bank");
            } else {
                System.out.println("Customer " + customerName + " is not registered with the "
                        + branchName + " branch.");
            }
        } else {
            System.out.println("Sorry, branch not found. Check spelling or add branch as new.");
        }
    }
}