//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P10 SJF Process Scheduler
// Files: CustomProcess.java, WaitingProcessQueue.java, ProcessSchedulerTester.java,
//////////////////// ProcessScheduler.java
// Course: CS 300
//
// Author: Alexander Hertadi
// Email: hertadi@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
public class CustomProcess implements java.lang.Comparable<CustomProcess> {
  private static int nextProcessId = 1; // stores the id to be assigned to the next process to be
                                        // created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution

  /**
   * COnstructor for the CustomProcess Class. Takes burstTime as param and sets PROCESS_ID based on
   * the counter.
   * 
   * @param burstTime - time required by this process for CPU execution
   */
  public CustomProcess(int burstTime) {
    if (burstTime < 1) {
      throw new IllegalArgumentException("burstTime has to be non-zero positive integer");
    }
    this.burstTime = burstTime;
    PROCESS_ID = nextProcessId;
    nextProcessId++;
  }

  /**
   * Returns a String representation of this CustomProcess
   * 
   * @return a string representation of this CustomProcess
   */
  public String toString() {
    return "p" + this.PROCESS_ID + "(" + this.burstTime + ")";
  }

  /**
   * Compares this burstTime with another instance of CustomProccess's busrtTime. If burstTime is
   * equal then ID is compared.
   * 
   * @param other - Other instance being compared to this
   * @return <0 if this is smaller than other. >0 if bigger, and ==0 if equal
   */
  @Override
  public int compareTo(CustomProcess other) {
    if (this.burstTime == other.burstTime) {
      return this.PROCESS_ID - other.PROCESS_ID;
    }
    return this.burstTime - other.burstTime;
  }
  
  /**
   * Gets this instance's process ID
   * @return - this.PROCESS_ID
   */
  public int getProcessId() {
    return this.PROCESS_ID;
  }
  
  /**
   * Gets this instance's burstTime
   * @return - this.burstTime
   */
  public int getBurstTime() {
    return this.burstTime;
  }


}
