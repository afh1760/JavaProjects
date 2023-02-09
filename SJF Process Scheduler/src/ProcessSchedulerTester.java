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
public class ProcessSchedulerTester {

  /**
   * checks the correctness of the insert operation implemented in the WaitingProcessQueue class
   * 
   * @return true if the function works as specifications, false if otherwise
   */
  public static boolean testInsertWaitingProcessQueue() {
    WaitingProcessQueue test = new WaitingProcessQueue(); // tester instance of WaitingPricessQueue
    test.insert(new CustomProcess(10));
    test.insert(new CustomProcess(2));
    test.insert(new CustomProcess(5));
    test.insert(new CustomProcess(3));
    test.insert(new CustomProcess(1));
    // checks output of the minHeap
    if (test.toString().equals("p5(1) p2(2) p3(5) p1(10) p4(3)")) {
      return true;
    }
    return false;
  }

  /**
   * checks the correctness of the removeBest operation implemented in the WaitingProcessQueue class
   * 
   * @return true if function behaves as expected, false otherwise.
   */
  public static boolean testRemoveBestWaitingProcessQueue() {
    WaitingProcessQueue test = new WaitingProcessQueue(); // tester instance of WaitingPricessQueue
    test.insert(new CustomProcess(10));
    test.insert(new CustomProcess(2));
    test.insert(new CustomProcess(5));
    test.insert(new CustomProcess(3));
    test.insert(new CustomProcess(1));
    // removes root element and tests array content
    test.removeBest();
    if (!test.toString().equals("p7(2) p9(3) p8(5) p6(10)")) {
      return false;
    }
    // repeat step to make sure.
    test.removeBest();
    if (!test.toString().equals("p9(3) p6(10) p8(5)")) {
      return false;
    }
    return true;
  }

  /**
   * Checks correctness of value return by compareTo() in the Custom Process class. It should
   * compare based on burst time, and if the burst time is equal it compares the process id.
   * 
   * @return true if function returns the expected value, false other wise.
   */
  public static boolean testCompareToCustomProcess() {
    CustomProcess test = new CustomProcess(5); // first tester instance
    CustomProcess test2 = new CustomProcess(10); // second tester instance with different burst time
                                                 // than 1st
    CustomProcess test3 = new CustomProcess(5); // Third tester instance with same burst time as 1st
    if (test.compareTo(test2) >= 0) {
      return false;
    }
    if (test3.compareTo(test) <= 0) {
      return false;
    }
    if (test.compareTo(test) != 0) {
      return false;
    }
    return true;
  }

  /**
   * tests the isEmpty() function within the WaitingProcessQueue class
   * @return true if it returns the expected value, false otherwise.
   */
  public static boolean testIsEmptyWaitingProcessQueue() {
    WaitingProcessQueue test = new WaitingProcessQueue(); // tester instance of WaitingPricessQueue
    if (!test.isEmpty()) {
      return false;
    }
    test.insert(new CustomProcess(10));
    if (test.isEmpty()) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(testInsertWaitingProcessQueue());
    System.out.println(testRemoveBestWaitingProcessQueue());
    System.out.println(testCompareToCustomProcess());
    System.out.println(testIsEmptyWaitingProcessQueue());
  }
}
