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
import java.util.Scanner;

public class ProcessScheduler {

  private int currentTime; // stores the current time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private WaitingProcessQueue queue; // this processing unit's queue

  /**
   * Initializes the ProcessScheduler object.
   */
  public ProcessScheduler() {
    currentTime = 0;
    numProcessesRun = 0;
    queue = new WaitingProcessQueue();
  }

  /**
   * This method inserts the given process in the WaitingProcessQueue queue.
   * 
   * @param process - the process being inserted into
   */
  public void scheduleProcess(CustomProcess process) {
    queue.insert(process);
    // prints out the process message for the driver application
    System.out.println("Process ID " + process.getProcessId() + " scheduled. Burst Time = "
        + process.getBurstTime());
  }

  /**
   * runs the ready processes already scheduled in this processScheduler's queue
   * 
   * @return the list of processes with start and finish statement
   */
  public String run() {
    String ret; // string to be returned
    // initial message. Differs message according to grammar whether it is a singular process or
    // plural
    if (queue.size() == 1) {
      ret = "Starting " + queue.size() + " process\n\n";
    } else {
      ret = "Starting " + queue.size() + " processes\n\n";
    }
    // runs process until queue is empty
    while (!queue.isEmpty()) {
      ret = ret + "Time " + currentTime + " : Process ID " + queue.peekBest().getProcessId()
          + " Starting.\n";
      CustomProcess processed = queue.removeBest(); // stores the "done" processes to get data.
      currentTime += processed.getBurstTime(); // adds burstTime to currentTime
      ret = ret + "Time " + currentTime + " : Process ID " + processed.getProcessId()
          + " Completed.\n";
      numProcessesRun++;
    }
    ret = ret + "\nTime " + currentTime + ": All scheduled processes completed.\n";
    return ret;
  }

  /**
   * gets current time of instance
   * 
   * @return
   */
  public int getCurrentTime() {
    return this.currentTime;
  }

  /**
   * gets the number of processes
   * 
   * @return
   */
  public int getNumProcessesRun() {
    return this.numProcessesRun;
  }

  /**
   * Inquiry printout before input prompt.
   */
  private static void inquiry() {
    System.out.println();
    System.out.println("Enter command:");
    System.out.println("[schedule <burstTime>] or [s <burstTime>]");
    System.out.println("[run] or [r]");
    System.out.println("[quit] or [q]");
    System.out.println();
  }

  /**
   * prints out invalid input response for driver application
   * 
   * @return
   */
  private static String invalidInput() {
    return "WARNING: Please enter a valid command!\n";
  }

  /**
   * Driver application for the ProcessScheduler
   * 
   * @param args
   */
  public static void main(String[] args) {
    ProcessScheduler ps = new ProcessScheduler(); // initializes a process scheduler object
    System.out.println("==========   Welcome to the SJF Process Scheduler App   ========");
    String input; // input string initialized here to check for do-while condition
    //do while function to run code once first but then stop looping when q is inputed
    do {
      inquiry();
      Scanner sc = new Scanner(System.in); // scanner object for input
      input = sc.nextLine();// enter input
      String[] inputSplit = input.split(" "); // split input for the schedule command
      if (inputSplit.length > 2) {
        System.out.print(invalidInput());
      } else if (inputSplit[0].equalsIgnoreCase("schedule")
          || inputSplit[0].equalsIgnoreCase("s")) {
        try {
          int burst = Integer.parseInt(inputSplit[1]); // changes the string value to int for custom
                                                       // process initialization
          ps.scheduleProcess(new CustomProcess(burst));
          // catches when second element of string array value is not an integer or is not a
          // positive integer
        } catch (NumberFormatException e) {
          System.out.println("burstTime has to be non-zero positive integer");
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
        }
      } else if (inputSplit[0].equalsIgnoreCase("run") || inputSplit[0].equalsIgnoreCase("r")) {
        System.out.print(ps.run()); //just runs the run function
      } else if (inputSplit[0].equalsIgnoreCase("quit") || inputSplit[0].equalsIgnoreCase("q")) {
        // prints out the number of processes and time elapsed and closing statement.
        System.out.println(ps.getNumProcessesRun() + " processes run in " + ps.getCurrentTime()
            + " units of time!");
        System.out.println("Thank you for using our scheduler!");
        System.out.println("Goodbye!");
      } else {
        System.out.print(invalidInput());
      }
    } while (!input.equals("q"));
  }
}
