//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Exceptional Bank Teller
// Files:           BankAccount.java, BankAccountTester.java, BankTeller.java, BankTellerTester.java
// Course:          
//
// Author:          Alexander Hertadi
// Email:           hertadi@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.ArrayList;
import java.util.zip.DataFormatException;

public class BankAccount {

	private String identifier; // account Identifier
	private int balance;  // account balance
	private ArrayList<String> transactions; // transactions for account
	
	/**
	 * Creates a new bank account with a given account identifier and an initial balance. 
	 * A deposit transaction /"1 " + initialBalance/ must be added to this account's list of transactions
	 * @param accountID - this account's unique identifier
	 * @param initialBalance - this account's initial balance
	 * @throws IllegalArgumentException - if initBalance is less than 10
	 */
	public BankAccount(String accountID, int initialBalance) {
		if (initialBalance < 10) {
	        throw new IllegalArgumentException("Initial Balance Less Than 10...");
	    }
		identifier = new String(accountID);
		balance = initialBalance;
		transactions = new ArrayList<String>();
		transactions.add(0, "1 " + initialBalance);
		
	}
	
	/**
	 * Gets the unique identifier of this account
	 * @return the unique identifier of this account
	 */
	public String getID(){
		return identifier;
	}
	
	/**
	 * Gets the current balance of this bank account
	 * @return the current balance of this bank account
	 */
	public int getBalance() {
		return balance;
	}
	
	/**
	 * Checks if an other bank account is equal to this one
	 * @param other - another BankAccount object
	 * @return true if this bankAccount's identifier equals the other bankAccount's identifier. 
	 *         The comparison is case sensitive
	 */
	public boolean equals(BankAccount other) {
		if(other.identifier.equals(this.identifier)) {
			return true;
		} 
		return false;
	}
	
	/**
	 * This method deposits an amount to this bank account. 
	 * It also adds the transaction /"1 " + depositAmount/ 
	 * to this account list of transactions and updates this bank account's balance.
	 * @param depositAmount - the amount of money to deposit to this bank account
	 * @throws IllegalArgumentException - with a descriptive error message if depositAmount is negative
	 */
	public void deposit(int depositAmount) {
		if (depositAmount < 0) {
	        throw new IllegalArgumentException("Deposit less than 0. That's not a deposit");
	    }
		transactions.add(0, "1 " + depositAmount);
		balance += depositAmount;
	}
	
	/**
	 * This method withdraws a specific amount of money. 
	 * It also adds the transaction /"0 " + withdrawalAmount/ 
	 * to this accunt's list of transactions and updates this bank account's balance.
	 * @param withdrawAmount - the amount of money to withdraw from this bank account
	 * @throws DataFormatException if withdrawalAmount is negative or is not a multiple of 10
	 * @throws IllegalStateException if the withdrawalAmount is larger than this bank account's balance
	 */
	public void withdraw(int withdrawAmount) throws DataFormatException {
		if (withdrawAmount < 0 || withdrawAmount % 10 != 0) {
	        throw new DataFormatException("Withdraw not a positive number and/or is not a multiple of 10");
	    }
		if (withdrawAmount > balance) {
	        throw new IllegalStateException("Non sufficient funds");
	    }
		transactions.add(0, "0 " + withdrawAmount);
		balance -= withdrawAmount;
	}
	
	/**
	 * Gets the most recent FIVE transactions in an array of length 5. 
	 * This array may contain null references if the total number of transactions is less than 5. 
	 * If getTransactionsCount() is less than 5, 
	 * these transactions should be stored at the range of indices 0 .. getTransactionsCount()-1. 
	 * For instance, if the total number of transactions is 0, this array will contain five null references. 
	 * If the total number of transactions is 1, it will contain the transaction at index 0, 
	 * followed by 4 null references, and so on.
	 * @return the most recent transactions in an array that may contain up to 5 string references
	 */
	public String[] getMostRecentTransactions() {
		String [] recentTransactions = new String[5];
		for(int i = 0; i < transactions.size(); i++) {
			if(i > 4) {
				break;
			} else {
				recentTransactions[i] = transactions.get(i);
			}
		}
		return recentTransactions;
		
	}
	
	/**
	 * Gets the total number of transactions performed on this bank account, 
	 * meaning the size of the ArrayList of transactions of this bank account
	 * @return the total number of transactions performed on this account
	 */
	public int getTransactionsCount() {
		return transactions.size();
	}
}
