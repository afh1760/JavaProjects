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
import java.io.File;
import java.io.IOException;

public class MemeageTests {
  
  /**
   * Tests getBits() method by creating a FourBytes instance and initializing its value then calling
   * getBits() and matching it with the expected value
   * @return true if getBits() functions correctly, false otherwise
   */
  public static boolean testFourBytesGetBits() {
    FourBytes test = new FourBytes(13312); //creates tester instance of FourBytes
    if (test.getBits(4, 10) == 13) {
      return true;
    }
    return false;

  }

  /**
   * Tests setBits() method by creating a FourBytes instance and initializing its value then calling
   * setBits() and matching it with the expected value
   * @return true if setBits() functions correctly, false otherwise
   */
  public static boolean testFourBytesSetBits() {
    FourBytes test = new FourBytes(0); //creates tester instance of FourBytes
    test.setBits(3, 8, 13);
    if (test.getInt() == 1280) {
      return true;
    }
    return false;
  }
  
  /**
   * Tests Color constructor by creating a Color instance and initializing its value then calling
   * getRed() and matching it with the expected value
   * @return true if Color constructor functions correctly, false otherwise
   */
  public static boolean testColor() {
    Color test = new Color(0); //creates tester instance of Color
    test.setRed(100);
    test.setBlue(200);
    test.setGreen(234);
    if(test.getRed() == 100 && test.getBlue() == 200) return true;
    return false;
  }
  
  /**
   * Tests Image constructor by creating a FourBytes instance and initializing its value then calling
   * setBits() and matching it with the expected value
   * @return true if getBits() functions correctly, false otherwise
   */
  public static boolean testImage() {
    Image test; //creates tester instance of Image               
    try {
      test = new Image(new File("testImage.png"));
      if(test.getWidth() == 3 && test.getHeight() == 3) {
        Color tester = new Color(test.getColor(1, 1));
        if(tester.getBlue() == 255 && tester.getGreen() == 255 && tester.getRed() == 0) {
          return true;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }
  
  /**
   * Tests ColorPlusChar constructor by creating a FourBytes instance and 
   * initializing its value then calling
   * revealchar and matching it with the expected value
   * @return true if revealChar functions correctly, false otherwise
   */
  public static boolean testColorPlusChar() {
    ColorPlusChar test = new ColorPlusChar(new Color(255, 255 , 255, 255), 'h');
    if(test.revealChar() == 'h') {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    System.out.println(testFourBytesGetBits());
    System.out.println(testFourBytesSetBits());
    System.out.println(testColor());
    System.out.println(testImage());
    System.out.println(testColorPlusChar());
//    FourBytes characterbit = new FourBytes('h');
//    System.out.print(characterbit.toString());
  }
}
