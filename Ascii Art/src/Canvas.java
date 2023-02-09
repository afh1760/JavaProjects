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
public class Canvas {
  private final int width; // width of the canvas
  private final int height; // height of the canvas
  private char[][] drawingArray; // 2D character array to store the drawing
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo

  /**
   * Constructor creates a new canvas which is initially blank (use the default value for char type
   * or you can use spaces Throws an IllegalArgumentException with a descriptive error message if
   * width or height is 0 or negative.
   * 
   * @param width
   * @param height
   */
  public Canvas(int width, int height) {

    if (width < 1 || height < 1) {
      throw new IllegalArgumentException("not a positive dimension");
    }
    this.width = width;
    this.height = height;
    this.drawingArray = new char[height][width];
    this.undoStack = new DrawingStack();
    this.redoStack = new DrawingStack();
  }

  /**
   * Draw a character at the given position drawingArray[row][col] This method should throw an
   * IllegalArgumentException if the drawing position is outside the canvas If that position is
   * already marked with a different character, overwrite it. After making a new change, add a
   * matching DrawingChange to the undoStack so that we can undo if needed. After making a new
   * change, the redoStack should be empty (meaning that you should clear the redoStack if it is not
   * already empty).
   * 
   * @param row - y coordinate
   * @param col - x coordinate
   * @param c   - character being written over
   */
  public void draw(int row, int col, char c) {
    if (row > this.height - 1 || col > this.width - 1) {
      throw new IllegalArgumentException();
    }
    char overwritten = drawingArray[row][col]; // stores previous character
    drawingArray[row][col] = c;
    while (!redoStack.isEmpty()) {
      redoStack.pop();
    }
    undoStack.push(new DrawingChange(row, col, overwritten, c));
  }

  /**
   * Undo the most recent drawing change. An undone DrawingChange should be popped off the
   * undoStack. An undone DrawingChange should be added to the redoStack so that // we can redo
   * if needed. The content of the drawingArray should be updated accordingly to this change.
   * 
   * @return true if successful. False otherwise.
   */
  public boolean undo() {
    if (undoStack.isEmpty()) {
      return false;
    }
    DrawingChange oops = undoStack.pop(); // keeps track of DrawingChange being popped
    drawingArray[oops.row][oops.col] = oops.prevChar;
    redoStack.push(oops);
    return true;
  }


  /**
   * Redo the most recent undone drawing change. A redone DrawingChange should be popped off the
   * redoStack. A redone DrawingChange should be added (back) to the undoStack so that we can undo
   * again if needed. The content of the drawingArray should be updated accordingly to this change.
   * 
   * @return true if successful. False otherwise.
   */
  public boolean redo() {
    if (redoStack.isEmpty()) {
      return false;
    }
    DrawingChange oops = redoStack.pop(); // stores the popped drawing change obj
    drawingArray[oops.row][oops.col] = oops.newchar;
    undoStack.push(oops);
    return true;
  }

  /**
   * Return a printable string version of the Canvas.
   */
  public String toString() {
    String newLine = new String(); // String to be returned as a representation of the Canvas
    for (int i = 0; i < height; i++) {
      newLine += System.lineSeparator();
      for (int j = 0; j < width; j++) {
        newLine += drawingArray[i][j];
      }
    }
    return newLine;
  }

  /**
   * self made function to get the doubleArray to check for individual elements
   * 
   * @return drawingArray
   */
  public char[][] getArray() {
    return drawingArray;
  }
}
