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
import java.util.Scanner;
import java.util.zip.DataFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
public class BankTeller {

	private ArrayList<BankAccount> bankAccounts; //ArrayList containing bank accounts created 
	
	/**
	 * Creates a new BankTeller object with an empty list of accounts
	 */
	public BankTeller() {
		bankAccounts = new ArrayList<BankAccount>();
	}
	
	/**
	 * Adds newAccount to the list of accounts of this BankTeller
	 * @param newAccount - a new account to add
	 * @throws IllegalStateException - with a descriptive error message if the accountID of 
	 * newAccount is used by another account already added to the list of accounts
	 * @throws IllegalArgumentException - with a descriptive error message if newAccount is null
	 */
	public void addBankAccount(BankAccount newAccount) {
		for(int i=0; i < bankAccounts.size(); i++) {
			if(bankAccounts.get(i).getID().equals(newAccount.getID())) {
				throw new IllegalStateException("Account already exists");
			}
		}
		if(newAccount == null) {
			throw new IllegalArgumentException("There is no new account?");
		}
		bankAccounts.add(newAccount);
	}
	
	/**
	 * Returns the bank account that has exactly the provided identifier. 
	 * Case sensitive comparison must be considered.
	 * @param id
	 * @return
	 * @throws NoSuchElementException - with a descriptive error message if 
	 * no account in this bankTeller's accounts list has the provided id
	 */
	public BankAccount findAccount(String id) {
		BankAccount a = null; // instance that is null until banl account matched with id
		for(int i = 0; i <= bankAccounts.size(); i++) {
			if(bankAccounts.get(i).getID().equals(id)) {
				a = bankAccounts.get(i); 
			}
		}
		if(a == null) {
			throw new NoSuchElementException("The account does not exist");
		}
		return a;
	}
	
	/**
	 * Adds a new transaction to the account's list of transactions. 
	 * When added, a withdrawal or deposit transaction should change the account's balance
	 * @param transaction - to add
	 * @param account
	 * @throws DataFormatException - if the format of the transaction is not correct
	 * @throws NullPointerException - if account is null
	 */
	public void addTransaction(String transaction, BankAccount account) 
			throws DataFormatException {
		if(account == null) {
			throw new NullPointerException("Bank Account???");
		}
		String[] splitTransaction = transaction.split(" ");
		if(!splitTransaction[0].equals("0") || !splitTransaction[0].equals("0") 
				|| splitTransaction.length != 2) {
			throw new DataFormatException("Invalid Input");
		}
		if(splitTransaction[0].equals("0")) {
			int amount = Integer.valueOf(splitTransaction[1]);
			account.deposit(amount);
		}
		if(splitTransaction[0].equals("1")) {
			int amount = Integer.valueOf(splitTransaction[1]);
			account.withdraw(amount);
		}
	}
	
	/**
	 * Loads a set of transactions from a provided file object. Each transaction is in a separate 
	 * line. Each transaction line should contain two items: the transaction code "0" or "1" 
	 * followed by the transaction amount separated by spaces. Extra spaces at the beginning and 
	 * at the end of a transaction line should be ignored. Not correctly formatted lines must be 
	 * skipped. Valid transactions must change the balance of the bank account. 
	 * If java.util.Scanner object is used to read from the file object, 
	 * make sure to close the scanner object whenever a FileNotFoundException was thrown or not.
	 * @param file - a java.io.File object referring to a file 
	 *               that contains a set of transactions, each in one line
	 * @param account - a reference to a BankAccount object
	 * @throws NullPointerException - if account is null
	 * @throws FileNotFoundException - if the file object does not correspond to an actual 
	 *                                 file within the file system.
	 */
	public void loadTransactions(File file, BankAccount account) 
			throws FileNotFoundException {
		if (account == null) {
			throw new NullPointerException("No account selected?");
		}
		if (!file.exists()) {
			throw new FileNotFoundException("File not found");
		}
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			try {
				addTransaction(line, account);
			} catch(DataFormatException e) {
				continue;
			}
		}
		sc.close();
	}
	
	/**
	 * Returns the total number of accounts created so far (i.e., the size of the Arraylist of accounts
	 * @return the total number of accounts added to this BankTeller
	 */
	public int getAccountsCount() {
		return bankAccounts.size();
	}
	
	
}
