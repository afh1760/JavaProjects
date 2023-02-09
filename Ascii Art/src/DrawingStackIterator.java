//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P08 Ascii Art
// Files: DrawingChange.java, DrawingStack.java, DrawingStackIterator.java, AsciiArtTester.java,
//////////////////// Canvas.java
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
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DrawingStackIterator implements Iterator<DrawingChange> {

  private LinkedNode<DrawingChange> current; //keep track of the current node

  /**
   * Initializes the DrawingStackIterator object by initializing current to be the head of a 
   * drawing stack.
   * @param change
   */
  public DrawingStackIterator(LinkedNode<DrawingChange> change) {
    current = change;
  }

  /**
   * check if the iterator still has elements to iterate.
   */
  @Override
  public boolean hasNext() {
    if (current != null) {
      return true;
    }
    return false;
  }

  /**
   * moves the current to the next element on the list and returns the current element
   */
  @Override
  public DrawingChange next() {
    if (current == null) {
      throw new NoSuchElementException();
    }
    LinkedNode<DrawingChange> tempCurrent = current; // temp variable to return
    current = current.getNext();
    return tempCurrent.getData();
  }

}
