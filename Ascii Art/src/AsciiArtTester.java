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
import java.util.NoSuchElementException;

public class AsciiArtTester {

  /**
   * Tests push and peek function of DrawingStack.java class.
   * 
   * @return true when function correctly
   */
  public static boolean testStackPushPeek() {
    DrawingStack test = new DrawingStack(); // test instance of DrawingStack
    try {
      test.peek();
      return false;
    } catch (EmptyStackException e) {

    }
    DrawingChange tester = new DrawingChange(1, 1, 'b', 'a'); // DrawChange Obj to push in the stack
    test.push(tester);
    if (test.peek() != tester) {
      return false;
    }
    DrawingChange tester2 = new DrawingChange(1, 2, 'A', 'X'); // DrawChange Obj to push in the
                                                               // stack
    test.push(tester2);
    if (test.peek() != tester2) {
      return false;
    }
    return true;
  }

  /**
   * Test method to test for pop() function of DrawingChangeStack class
   * 
   * @return true if function correct, false otherwise
   */
  public static boolean testStackPop() {
    DrawingStack test = new DrawingStack(); // test instance of DrawingStack
    DrawingChange tester = new DrawingChange(1, 1, 'b', 'a'); // DrawChange Obj to push in the stack
    test.push(tester);
    if (test.pop() != tester) {
      return false;
    }
    try {
      test.peek();
      return false;
    } catch (EmptyStackException e) {

    }
    return true;
  }

  /**
   * Test draw() function from canvas class
   * 
   * @return true if fuctions correctly, false otherwise
   */
  public static boolean testDraw() {
    Canvas test = new Canvas(3, 3); // test canvas instance
    try {
      test.draw(0, 3, 'c');
      return false;
    } catch (IllegalArgumentException e) {

    }
    test.draw(0, 0, 'c');
    char[][] testArray = test.getArray(); // to get canvas array to check for individual elements
    if (testArray[0][0] != 'c') {
      return false;
    }
    return true;
  }

  /**
   * Test method for undo() method in canvas class
   * 
   * @return when the method functions correctly, false otherwise
   */
  public static boolean testUndo() {
    Canvas test = new Canvas(3, 3); // test canvas instance
    if (test.undo()) {
      return false;
    }
    test.draw(0, 0, 'c');
    test.draw(0, 0, 'X');
    test.undo();
    char[][] testArray = test.getArray(); // to get canvas array to check for individual elements
    if (testArray[0][0] != 'c') {
      return false;
    }
    return true;
  }

  /**
   * Tests the redo() function from Canvas.java.
   * 
   * @return true when functioning correctly, false otherwise
   */
  public static boolean testRedo() {
    Canvas test = new Canvas(3, 3); // test canvas instance
    test.draw(0, 0, 'c');
    test.draw(0, 0, 'X');
    if (test.redo()) {
      return false;
    }
    test.undo();
    test.undo();
    test.redo();
    char[][] testArray = test.getArray(); // to get canvas array to check for individual elements
    if (testArray[0][0] != 'c') {
      return false;
    }
    return true;
  }

  /**
   * Test method for the iterator of the DrawingStack.
   * 
   * @return true if functions correctly, false otherwise
   */
  public static boolean testIterator() {
    DrawingStack test = new DrawingStack();
    DrawingChange tester = new DrawingChange(1, 1, 'b', 'a'); // DrawingChange instance to push
    DrawingChange tester2 = new DrawingChange(1, 2, 'b', 'a'); // DrawingChange instance to push
    DrawingChange tester3 = new DrawingChange(1, 3, 'b', 'a'); // DrawingChange instance to push
    test.push(tester);
    test.push(tester2);
    test.push(tester3);
    Iterator<DrawingChange> iterator = test.iterator(); // iterator for testing
    if (iterator.next() != tester3) {
      return false;
    }
    if (iterator.next() != tester2) {
      return false;
    }
    if (!iterator.hasNext()) {
      return false;
    }
    if (iterator.next() != tester) {
      return false;
    }
    if (iterator.hasNext()) {
      return false;
    }
    try {
      iterator.next();
      return false;
    } catch (NoSuchElementException e) {

    }
    return true;
  }


  /**
   * Test method that calls multiple other test methods. Return true when all test methods return
   * true
   * 
   * @return true if functions correctly, false otherwise
   */
  public static boolean runAsciiArtTestSuite() {
    if (!testStackPushPeek()) {
      return false;
    }
    if (!testDraw()) {
      return false;
    }
    if (!testUndo()) {
      return false;
    }
    if (!testRedo()) {
      return false;
    }
    if (!testIterator()) {
      return false;
    }
    if (!testStackPop()) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    // System.out.println(testStackPushPeek());
    System.out.println(runAsciiArtTestSuite());
    System.out.println(testIterator());
    // System.out.println(testUndo());
  }
}
