/*
 * p2_project
 *  Name : Alexander Francis Hertadi 
 * Email : hertadi@wisc.edu 
 * Lecture : CS400 Lecture 002
 * Program : This program tests implementations of data structures(RBT and BST) and compares the
 * runtime between each implementation attempt and height
 */

/**
 * Compares the runtimes of two implementations of a data structure, in this case BST and RBT
 * For the number of values being worked on each of these are inserted and then called the get
 * function. It then measures the time by nanoseconds. Lastly the height is compared.
 * Since it is a uniform order BST height = number of elements
 * 
 * @author A. F. Hertadi
 *
 */
public class CompareDS {

  public static void main(String[] args)
      throws IllegalNullKeyException, DuplicateKeyException, KeyNotFoundException {
    BST<Integer, Integer> bst= new BST<Integer, Integer>(); // instance of BST for first run
    RBT<Integer, Integer> rbt = new RBT<Integer, Integer>(); // instance of RBT for first run
    BST<Integer, Integer> bst2 = new BST<Integer, Integer>(); // instance of BST for second run
    RBT<Integer, Integer> rbt2 = new RBT<Integer, Integer>(); // instance of RBT for second run
    BST<Integer, Integer> bst3 = new BST<Integer, Integer>(); // instance of BST for third run
    RBT<Integer, Integer> rbt3 = new RBT<Integer, Integer>(); // instance of RBT for third run


    System.out.println("CompareDS.main Compares work time for: BST and RBT");
    System.out.println("Description: Inserts and gets values for the specified number of values");
    System.out.println();
    System.out.println("BST is doing work for 100 values");
    long startTimeBST = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      bst.insert(i, i);
      bst.get(i);
    }
    long endTimeBST = System.nanoTime();
    System.out.println("It took " + (endTimeBST - startTimeBST) + " ns to process 100 items");
    System.out.println("BST height: "+bst.getHeight());
    System.out.println();
    System.out.println("RBT is doing work for 100 values");
    long startTimeRBT = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      rbt.insert(i, i);
      rbt.get(i);
    }
    long endTimeRBT = System.nanoTime();
    System.out.println("It took " + (endTimeRBT - startTimeRBT) + " ns to process 100 items");
    System.out.println("RBT height: "+rbt.getHeight());
    System.out.println();

    System.out.println("BST is doing work for 1000 values");
    long startTimeBST2 = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      bst2.insert(i, i);
      bst2.get(i);
    }
    long endTimeBST2 = System.nanoTime();
    System.out.println("It took " + (endTimeBST2 - startTimeBST2) + " ns to process 1000 items");
    System.out.println("BST height: "+bst2.getHeight());
    System.out.println();
    System.out.println("RBT is doing work for 1000 values");
    long startTimeRBT2 = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      rbt2.insert(i, i);
      rbt2.get(i);
    }
    long endTimeRBT2 = System.nanoTime();
    System.out
        .println("It took " + (endTimeRBT2 - startTimeRBT2) + " ns to process 1000 items");
    System.out.println("RBT height: "+rbt2.getHeight());


    System.out.println();
    System.out.println("BST is doing work for 10000 values");
    long startTimeBST3 = System.nanoTime();
    for (int i = 0; i < 10000; i++) {
      bst3.insert(i, i);
      bst3.get(i);
    }
    long endTimeBST3 = System.nanoTime();
    System.out.println("It took " + (endTimeBST3 - startTimeBST3) + " ns to process 10000 items");
    System.out.println("BST height: "+bst3.getHeight());
    System.out.println();
    System.out.println("RBT is doing work for 10000 values");
    long startTimeRBT3 = System.nanoTime();
    for (int i = 0; i < 10000; i++) {
      rbt3.insert(i, i);
      rbt3.get(i);
    }
    long endTimeRBT3 = System.nanoTime();
    System.out
        .println("It took " + (endTimeRBT3 - startTimeRBT3) + " ns to process 10000 items");
    System.out.println("RBT height: "+rbt3.getHeight());
  }
}
