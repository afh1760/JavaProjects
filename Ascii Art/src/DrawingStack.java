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
import java.util.EmptyStackException;
import java.util.Iterator;

public class DrawingStack implements StackADT<DrawingChange>, Iterable<DrawingChange> {

  private LinkedNode<DrawingChange> top; // top of the stack
  private int size; // number of elements in stack

  /**
   * Initializes a DrawingStack instance
   */
  public DrawingStack() {
    top = null;
    size = 0;
  }

  /**
   * Creates a new DrawingStackIterator obj with the parameter top of the stack
   */
  @Override
  public Iterator<DrawingChange> iterator() {
    return new DrawingStackIterator(top);
  }

  /**
   * "pushes"/adds an element to the top of the stack.
   * overrides the StackADT push() method
   */
  @Override
  public void push(DrawingChange element) {
    if (element == null) {
      throw new IllegalArgumentException();
    }
    if (isEmpty()) {
      LinkedNode<DrawingChange> head = new LinkedNode<DrawingChange>(element); // temp variable
      top = head;
    } else {
      LinkedNode<DrawingChange> temp = new LinkedNode<DrawingChange>(element, top); //temp var
      top = temp;
    }
    size++;

  }

  /**
   * Deletes the top element of the stack and returns it.
   * overrides the StackADT pop() method
   */
  @Override
  public DrawingChange pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    LinkedNode<DrawingChange> temp = top; //temp var to keep track of prev top
    if (top.getNext() != null) {
      top = top.getNext();
    } else {
      top = null;
    }
    size--;
    return temp.getData();
  }

  /**
   * return the top element of the stack
   * overrides StackADT peek() method
   */
  @Override
  public DrawingChange peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return top.getData();
  }

  /**
   * checks if the stack is empty.
   * overrides StackADT isEmpty() 
   */
  @Override
  public boolean isEmpty() {
    return top == null; //top would not be null if it weren't empty
  }

  /**
   * returns size instance
   */
  @Override
  public int size() {
    return this.size;
  }

}
