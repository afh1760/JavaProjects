//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P05 Memeage
// Files:           Color.java, MemeageTests.java, ColorPlusChar.java, Memeage.java
// Course:          CS 300
//
// Author:          Alexander Hertadi
// Email:           hertadi@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
public class Color extends FourBytes{
	 
	/**
	   * Create a new FourBytes object with the specified initial value.
	   * @param value contains initial four bytes (32 bits) of data
	   */
	  public Color(int argb) {
	    super(argb);
	  }  
	  /**
	   * Create a new FourBytes object with the specified initial value.
	   * @param value lease significant initial two bytes (16 bits) of data
	   */
	  public Color(int alpha, int red , int green, int blue) {
	    super(0);
	    setAlpha(alpha);
	    setRed(red);
	    setGreen(green);
	    setBlue(blue);
	    
	  }
	  
	  /**
	   * Sets color by value argb
	   * @param other
	   */
	  public Color(Color other) {
	    super(other.getARGB());
	  }
	  
	  /**
	   * get ARGB value of color
	   * @return
	   */
	  public int getARGB() {
	    return getInt();
	  }
	  
	  /**
	   * Gets alpha value
	   * @return
	   */
	  public int getAlpha() {
        return getBits(8, 24);
	  }
	  
	  /**
	   * Gets red value
	   * @return
	   */
	  public int getRed() {
		return getBits(8, 16);
	  }
	  
	  /**
	   * gets green value
	   * @return
	   */
	  public int getGreen() {
	    return getBits(8, 8);  
	  }
	  
	  /**
	   * gets blue value
	   * @return
	   */
	  public int getBlue() {
	    return getBits(8, 0);
	  }
	  
	  /**
	   * Sets ARGB value
	   * @param argb
	   */
	  public void setARGB(int argb) {
	    setInt(argb);
	  }
	  
	  /**
	   * set alpha value
	   * @param alpha
	   */
	  public void setAlpha(int alpha) {
		setBits(8, 24, alpha);
	  }
	  
	  /**
	   * set red value
	   * @param red
	   */
	  public void setRed(int red) {
	    setBits(8, 16, red);  
	  }
	  
	  /**
	   * set green value
	   * @param green
	   */
	  public void setGreen(int green) {
	    setBits(8, 8, green);  
	  }
	  
	  /**
	   * set blue value
	   * @param blue
	   */
	  public void setBlue(int blue) {
	    setBits(8, 0, blue);  
	  }
}
