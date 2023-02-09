import java.io.File;
import java.io.FileNotFoundException;

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

public class BankTellerTester {
	
	/**
	 * Checks whether the constructor of BankTeller class creates a new BankTeller 
	 * object with an empty ArrayList of bank accounts.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testBankTellerConstructor() {
		BankTeller test = new BankTeller();
		if(test.getAccountsCount() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks whether the BankTeller.addBankAccount() method throws an 
	 * IllegalStateException when it is passed a bank account with an identifier already used.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testBankTellerAddBankAccountUsedIdentifier() {
		BankTeller test = new BankTeller();
		BankAccount tester = new BankAccount("Alex", 10);
		BankAccount tester2 = new BankAccount("Alex", 99);
		try {
			test.addBankAccount(tester);
			test.addBankAccount(tester2);
		} catch(IllegalStateException e) {
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
		return false;
	}
	
	/**
	 * This method checks whether the BankTeller.loadTransactions() method that takes a File 
	 * parameter throws a FileNotFoundException, when it is passed a File object 
	 * that does not correspond to an actual file within the file system, and a non 
	 * null reference of type BankAccount.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testBankTellerLoadTransactionsFileNotFound() {
		File file = new File("test.txt");
		BankTeller test = new BankTeller();
		BankAccount testBA = new BankAccount("Alex", 1000);
		try {
			test.loadTransactions(file, testBA);
		} catch(NullPointerException e) {
			return false;
		} catch(FileNotFoundException e) {
			return true;
		}
		return false;
	}
	
	/**
	 * Runs the tests and prints out the results
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(testBankTellerConstructor());
		System.out.println(testBankTellerAddBankAccountUsedIdentifier());
		System.out.println(testBankTellerLoadTransactionsFileNotFound());

	}

}
