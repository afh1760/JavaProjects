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
public class WaitingProcessQueue implements WaitingQueueADT<CustomProcess> {

  private static final int INITIAL_CAPACITY = 20; // the initial capacity of this
                                                  // waiting process queue
  private CustomProcess[] data; // min heap-array storing the CustomProcesses inserted in this
                                // WaitingProcessQueue.
                                // data is an oversize array
  private int size; // number of CustomProcesses stored in this WaitingProcessQueue

  /**
   * Initializes a WaitingProcessQueue object by setting size = 0 and data: an array with the size
   * of the initial capacity field
   */
  public WaitingProcessQueue() {
    this.size = 0;
    data = new CustomProcess[INITIAL_CAPACITY];
  }

  /**
   * Returns parent of node at said position
   * 
   * @param pos - node position
   * @return parent node position
   */
  private int parent(int pos) {
    return (pos - 1) / 2;
  }

  /**
   * Returns left child of node at said position
   * 
   * @param pos - node position
   * @return left child position
   */
  private int leftChild(int pos) {
    return (2 * pos);
  }

  /**
   * Returns right child of node at said position
   * 
   * @param pos - node position
   * @return right child position
   */
  private int rightChild(int pos) {
    return (2 * pos) + 1;
  }

  /**
   * checks of node is a leaf node
   * 
   * @param pos - position of node
   * @return - true if it is a leaf node, false otherwise
   */
  private boolean isLeaf(int pos) {
    if (pos >= (size / 2) && pos <= size) {
      return true;
    }
    return false;
  }

  /**
   * Swaps two nodes in the array.
   * 
   * @param fpos - first node
   * @param spos - second node
   */
  private void swap(int fpos, int spos) {
    CustomProcess tmp = data[fpos]; // creates a temporary variable
    data[fpos] = data[spos];
    data[spos] = tmp;
  }

  /**
   * Percolates element up to the proper index for a min Heap.
   * 
   * @param index - index of element
   */
  private void minHeapPercolateUp(int index) {
    int current = index; // initializes a variable with the starting index
    while (data[current].compareTo(data[parent(current)]) < 0) {
      swap(current, parent(current));
      current = parent(current);
    }
  }


  /**
   * Sets node at said position to move it to the correct position by minHeap rules.
   * 
   * @param pos - node position.
   */
  private void minHeapPercolateDown(int index) {
    // If node is non-leaf and larger than child
    if (!isLeaf(index)) {
      if (data[index].compareTo(data[leftChild(index)]) > 0
          || data[index].compareTo(data[rightChild(index)]) > 0) {
        // Swap with left child and percolate down left child
        if (data[leftChild(index)].compareTo(data[rightChild(index)]) < 0) {
          swap(index, leftChild(index));
          minHeapPercolateDown(leftChild(index));
        }
        // Swap with right child and percolate down right child
        else {
          swap(index, rightChild(index));
          minHeapPercolateDown(rightChild(index));
        }
      }
    }
  }

  /**
   * inserts an element onto the minHeap then percolates it up.
   */
  @Override
  public void insert(CustomProcess element) {
    if (size >= data.length) {
      CustomProcess[] data2 = new CustomProcess[data.length * 2];
      for (int i = 0; i < data.length; i++) {
        data2[i] = data[i];
      }
      data = data2;
    }
    data[size++] = element;
    minHeapPercolateUp(size - 1);
  }

  /**
   * removes the root node and rearranges the minHeap
   */
  @Override
  public CustomProcess removeBest() {
    if (isEmpty()) {
      throw new NullPointerException();
    }
    CustomProcess removed = data[0]; // temporary variable holding the removed node to be returned
    // Sets the last indexed node to be the root and percolates down
    if (size == 1) {
      data[0] = null;
      return removed;
    }
    data[0] = data[--size];
    minHeapPercolateDown(0);
    return removed;
  }

  /**
   * return the parent custom process node
   */
  @Override
  public CustomProcess peekBest() {
    if (isEmpty()) {
      throw new NullPointerException();
    }
    return data[0];
  }

  /**
   * Return the size of the array
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * Checks if the WaitingProcessQueue is empty
   */
  @Override
  public boolean isEmpty() {
    return data[0] == null;
  }

  /**
   * Returns a String representation of this WaitingProcessQueue
   * 
   * @return a string representation of this WaitingProcessQueue
   */
  public String toString() {
    if (isEmpty()) {
      return " ";
    }
    // Sets initial string to the root then uses a for loop to iterate through the rest of the
    // elements
    String x = data[0].toString(); // String to be returned
    for (int i = 1; i < size; i++) {
      x = x + " " + data[i].toString();
    }
    return x;
  }
}
