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
import java.util.zip.DataFormatException;

public class BankAccountTester {
	
	/**
	 * Calls the constructor of BankAccount class to create a new BankAccount 
	 * object with a given id and a valid initial balance (greater of equal to 10). 
	 * Checks whether the new account is created with the provided account id and balance. 
	 * It checks also that the list of transactions of the created account 
	 * contains only one transaction /"1 " + the initial balance/
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testBankAccountConstructorValidInitialBalance() {
		BankAccount test;
		try {
			test = new BankAccount("sdrtgyjkl", 50);
		} catch(IllegalArgumentException e) {
			return false;
		}
		if (test.getTransactionsCount() != 1) {
			return false;
		}
		return true;
	}
	
	/**
	 * This method checks whether the BankAccount constructor 
	 * throws an IllegalArgumentException when it is passed a balance smaller than 10.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testBankAccountConstructorNotValidInitialBalance() {
		try {
			new BankAccount("sdrtgyjkl", 5);
		} catch(IllegalArgumentException e) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks whether BankAccount.equals() method returns true 
	 * when it compares a bank account to another one having the same account identifier 
	 * (case sensitive comparison); and it returns false otherwise.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testBankAccountEquals() {
		BankAccount test = new BankAccount("Alex", 10);
		BankAccount test2 = new BankAccount("Alex", 99);
		if(test.equals(test2)) {
			return true;
		} 
		return false;
	}
	
	/**
	 * Checks whether BankAccount.withdraw() method throws a DataFormatException 
	 * when it is passed a negative number or a number not multiple of 10. 
	 * The account balance should not change after the withdraw() method returns.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testBankAccountWithdrawInvalidAmount() {
		BankAccount test = new BankAccount("Alex", 100);
		int check = test.getBalance(); //integer to compare
		try {
			test.withdraw(-10);
		} catch (DataFormatException e) {
			if(test.getBalance() == check) {
				return true;
			}
		}
		try {
			test.withdraw(23);
		} catch (DataFormatException e) {
			if(test.getBalance() == check) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks whether BankAccount.withdraw() method throws an IllegalStateException 
	 * when it is passed a number larger than the account's balance. 
	 * The account balance should not change after that withdraw() method call returns.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 * @throws DataFormatException  
	 */
	public static boolean testBankAccountWithdrawLargerOfBalanceAmount() {
		BankAccount test = new BankAccount("Alex", 100);
		int check = test.getBalance(); //integer to compare
		try {
			test.withdraw(1000);
		} catch (DataFormatException e) {
			return false;
		} catch (IllegalStateException e) {
			if(test.getBalance() == check) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks whether BankAccount.withdraw() method returns without any exception when it is passed 
	 * a positive number smaller than the account's balance. 
	 * The withdrawal amount should be subtracted from the balance after the withdraw() method call returns.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testBankAccountWithdrawValidAmount() {
		BankAccount test = new BankAccount("Alex", 100);
		int check = test.getBalance(); //integer to compare
		try {
			test.withdraw(50);
		} catch (DataFormatException e) {
			return false;
		} catch (IllegalStateException e) {
			if(test.getBalance() == check) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks whether BankAccount.deposit() method throws an IllegalArgumentException when it is passed 
	 * a negative number. The balance of the bank account should not change after the method 
	 * call returns.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testBankAccountDepositNegativeAmount() {
		BankAccount test = new BankAccount("Alex", 100);
		int check = test.getBalance(); //integer to compare
		try {
			test.deposit(-10);
		} catch (IllegalArgumentException e) {
			if(test.getBalance() == check) {
				return true;
			}
		}
		return false;
	}
	
	
	
	/**
	 * Runs the tests then print true/false
	 * @param args
	 * @throws DataFormatException 
	 */
	public static void main(String[] args) {
		System.out.println(testBankAccountConstructorValidInitialBalance());
		System.out.println(testBankAccountConstructorNotValidInitialBalance());
		System.out.println(testBankAccountEquals());
		System.out.println(testBankAccountWithdrawInvalidAmount());
		System.out.println(testBankAccountWithdrawLargerOfBalanceAmount());
		System.out.println(testBankAccountWithdrawValidAmount());
		System.out.println(testBankAccountDepositNegativeAmount());
		
	}
}
