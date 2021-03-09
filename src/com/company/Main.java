package com.company;
/*
 * ----------------------------------------------------------------------------
 * "THE BEER-WARE LICENSE" (Revision 42):
 * <tommyop02@gmail.com> wrote this file.  As long as you retain this notice you
 * can do whatever you want with this stuff. If we meet some day, and you think
 * this stuff is worth it, you can buy me a beer in return.   tommyop02
 * ----------------------------------------------------------------------------
 */


import java.util.Scanner;


public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static Bank wellsFargo = new Bank("Wells Fargo");
    public static void main(String[] args) {
//	Bank wellsFargo = new Bank("Wells Fargo");
//	Branch branch1 = new Branch("Epping");
//	branch1.addNewCustomer("Tom", 3000.00);
//	branch1.showCustomers();
//	branch1.findCustomerTransactions("Tom");
//	branch1.addTransaction("Tom", -500.00);
//	branch1.findCustomerTransactions("Tom");
//	wellsFargo.addBranch("Chicago");
//	wellsFargo.addBranch("Detroit");
//	wellsFargo.findBranch("Chicago");
//	wellsFargo.addCustomer("Chicago", "Tommaso", 6000.00);
//	wellsFargo.listBranches();
//	wellsFargo.customerTransactions("Chicago", "Tommaso");
		boolean quit = false;
		startBankManager();
		printActions();
		while(!quit) {
			System.out.print("\nEnter your choice: (8 to show available options)");
			int option = scanner.nextInt();
			scanner.nextLine();

			switch(option) {
				case 0:
					System.out.println("Shutting down...");
					quit = true;
					break;
				case 1:
					showBranches();
					break;
				case 2:
					addBranch();
					break;
				case 3:
					showBranchCustomers();
					break;
				case 4:
					showCustomerTransactions();
					break;
				case 5:
					addCustomerToBranch();
					break;
				case 6:
					addCustomerTransaction();
					break;
				case 7:
					searchBranch();
					break;
				case 8:
					printActions();
					break;
			}
		}
    }

    private static void startBankManager() {
		System.out.println("[+] Logged in successfully.\n" +
				"Hello and welcome to the Bank Manager App.\n " +
				"Please wait for system initialization.\n" +
				" ");
	}

    private static void printActions() {
		System.out.println("Please choose from the following options:\n" +
				"\t0 - to shutdown the system\n" +
				"\t1 - to show a list of registered branches\n" +
				"\t2 - to add a new branch\n" +
				"\t3 - to show a list of customers for a chosen branch\n" +
				"\t4 - to show a list of transactions for a selected customer\n" +
				"\t5 - to add a new customer to an existing branch\n" +
				"\t6 - to add a new transaction to an existing customer\n" +
				"\t7 - to search for a specific branch\n"  +
				"\t8 - to print this menu again"+
				"\n");
		System.out.println("[+]  Enter your choice and press return....");
	}

	public static void showBranches() {
    	wellsFargo.listBranches();
		System.out.println("----------------------------------------------------");
	}

	public static void addBranch() {
		System.out.print("Please enter name for the new branch: ");
    	String branchName = scanner.nextLine();
    	wellsFargo.addBranch(branchName);
		System.out.println("----------------------------------------------------");
	}

	public static void showBranchCustomers(){
		System.out.print("Please enter the name of the branch you wish to access: ");
		String branchName = scanner.nextLine();
		wellsFargo.branchCustomers(branchName);
		System.out.println("----------------------------------------------------");
	}

	public static void showCustomerTransactions() {
		System.out.print("Please enter the name of the branch you wish to access: ");
		String branchName = scanner.nextLine();
		System.out.print("Please enter the name of the customer to display: ");
		String customerName = scanner.nextLine();
		wellsFargo.customerTransactions(branchName,customerName);
		System.out.println("----------------------------------------------------");
	}

	public static void addCustomerToBranch() {
		System.out.print("Please enter the name of the branch you wish to access: ");
		String branchName = scanner.nextLine();
		System.out.print("Now please enter the name for the new customer you wish to add to the "
				+ branchName + " branch: ");
		String customerName = scanner.nextLine();
		System.out.print("Lastly, please enter this customer's initial transaction: ");
		Double initialTransaction = scanner.nextDouble();
		wellsFargo.addCustomer(branchName,customerName,initialTransaction);
		System.out.println("----------------------------------------------------");
	}

	public static void addCustomerTransaction() {
		System.out.print("Please enter the name of the branch you wish to access: ");
		String branchName = scanner.nextLine();
		System.out.print("Now please enter the name of the customer you wish to add a transaction for: ");
		String customerName = scanner.nextLine();
		System.out.print("Lastly, please enter the new transaction amount: ");
		Double newTransaction = scanner.nextDouble();
		wellsFargo.addCustomerTransaction(branchName,customerName,newTransaction);
		System.out.println("----------------------------------------------------");
	}

	public static void searchBranch() {
		System.out.print("Search for: ");
		String branchName = scanner.nextLine();
		wellsFargo.findBranch(branchName);
		System.out.println("----------------------------------------------------");
	}
}