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
public class ColorPlusChar extends Color{
  public ColorPlusChar(Color color, char character) {
    super(color);
    hideChar(character);
  }
  public ColorPlusChar(Color color) {
    super(color);
  }
//stores 8-bit character within the least significant bits of color components
  public void hideChar(char character) {
    FourBytes characterbit = new FourBytes(character);
    setBits(2, 24, characterbit.getBits(2, 6));
    setBits(2, 16, characterbit.getBits(2, 4));
    setBits(2, 8, characterbit.getBits(2, 2));
    setBits(2, 0, characterbit.getBits(2, 0));
  }
  // retrieves 8-bit character from the least significant bits of color components
  public char revealChar() {
    FourBytes characterbit = new FourBytes(0);
    characterbit.setBits(2, 6, getBits(2, 24));
    characterbit.setBits(2, 4, getBits(2, 16));
    characterbit.setBits(2, 2, getBits(2, 8));
    characterbit.setBits(2, 0, getBits(2, 0));
    return characterbit.getChar();
  }
}
