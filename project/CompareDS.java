/*
 * p1_project Name : Alexander Francis Hertadi Email : hertadi@wisc.edu Lecture : CS400 Lecture 002
 * Program : This program tests implementations of data structures and compares the runtime between
 * each implementation attempt
 */

/**
 * Compares the runtimes of two implementations of a data structure, in this case Mine and Brian's
 * For the number of values being worked on each of these are inserted and then called the get
 * function. It then measures the time by nanoseconds.
 * 
 * @author A. F. Hertadi
 *
 */
public class CompareDS {

  public static void main(String[] args) {
    DS_My alex = new DS_My(); // instance of DS_My for first run
    DS_Brian brian = new DS_Brian(); // instance of DS_Brian for first run
    DS_My alex2 = new DS_My(); // instance of DS_My for second run
    DS_Brian brian2 = new DS_Brian(); // instance of DS_Brian for second run
    DS_My alex3 = new DS_My(); // instance of DS_My for third run
    DS_Brian brian3 = new DS_Brian(); // instance of DS_Brian for third run
    DS_My alex4 = new DS_My(); // instance of DS_My for fourth run
    DS_Brian brian4 = new DS_Brian(); // instance of DS_Brian for fourth run


    System.out.println("CompareDS.main Compares work time for: DS_My and DS_Brian");
    System.out.println("Description: Inserts and gets values for the specified number of values");
    System.out.println();
    System.out.println("DS_My is doing work for 100 values");
    long startTimeAlex = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      alex.insert(Integer.toString(i), Integer.toString(i));
      alex.get(Integer.toString(i));
    }
    long endTimeAlex = System.nanoTime();
    System.out.println("It took " + (endTimeAlex - startTimeAlex) + " ns to process 100 items");
    System.out.println();
    System.out.println("DS_Brian is doing work for 100 values");
    long startTimeBrian = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      brian.insert(Integer.toString(i), Integer.toString(i));
      brian.get(Integer.toString(i));
    }
    long endTimeBrian = System.nanoTime();
    System.out.println("It took " + (endTimeBrian - startTimeBrian) + " ns to process 100 items");
    System.out.println();

    System.out.println("DS_My is doing work for 1000 values");
    long startTimeAlex2 = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      alex2.insert(Integer.toString(i), Integer.toString(i));
      alex2.get(Integer.toString(i));
    }
    long endTimeAlex2 = System.nanoTime();
    System.out.println("It took " + (endTimeAlex2 - startTimeAlex2) + " ns to process 1000 items");
    System.out.println();
    System.out.println("DS_Brian is doing work for 1000 values");
    long startTimeBrian2 = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      brian2.insert(Integer.toString(i), Integer.toString(i));
      brian2.get(Integer.toString(i));
    }
    long endTimeBrian2 = System.nanoTime();
    System.out
        .println("It took " + (endTimeBrian2 - startTimeBrian2) + " ns to process 1000 items");


    System.out.println();
    System.out.println("DS_My is doing work for 10000 values");
    long startTimeAlex3 = System.nanoTime();
    for (int i = 0; i < 10000; i++) {
      alex3.insert(Integer.toString(i), Integer.toString(i));
      alex3.get(Integer.toString(i));
    }
    long endTimeAlex3 = System.nanoTime();
    System.out.println("It took " + (endTimeAlex3 - startTimeAlex3) + " ns to process 10000 items");
    System.out.println();
    System.out.println("DS_Brian is doing work for 10000 values");
    long startTimeBrian3 = System.nanoTime();
    for (int i = 0; i < 10000; i++) {
      brian3.insert(Integer.toString(i), Integer.toString(i));
      brian3.get(Integer.toString(i));
    }
    long endTimeBrian3 = System.nanoTime();
    System.out
        .println("It took " + (endTimeBrian3 - startTimeBrian3) + " ns to process 10000 items");

    System.out.println();
    System.out.println("DS_My is doing work for 100000 values");
    long startTimeAlex4 = System.nanoTime();
    for (int i = 0; i < 100000; i++) {
      alex4.insert(Integer.toString(i), Integer.toString(i));
      alex4.get(Integer.toString(i));
    }
    long endTimeAlex4 = System.nanoTime();
    System.out
        .println("It took " + (endTimeAlex4 - startTimeAlex4) + " ns to process 100000 items");
    System.out.println();
    System.out.println("DS_Brian is doing work for 100000 values");
    long startTimeBrian4 = System.nanoTime();
    for (int i = 0; i < 100000; i++) {
      brian4.insert(Integer.toString(i), Integer.toString(i));
      brian4.get(Integer.toString(i));
    }
    long endTimeBrian4 = System.nanoTime();
    System.out
        .println("It took " + (endTimeBrian4 - startTimeBrian4) + " ns to process 100000 items");
  }
}
