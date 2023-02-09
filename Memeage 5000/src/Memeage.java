import java.io.File;
import java.io.IOException;

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
public class Memeage extends Image{
  public Memeage(File file) throws IOException{
    super(file);
  }
  public Memeage(File file, String meme) throws IOException, IllegalArgumentException{
    super(file);
    setMeme(meme);
  }
  
  /**
   * sets the hidden characters
   * @param meme
   * @throws IllegalArgumentException
   */
  public void setMeme(String meme) throws IllegalArgumentException{
    char[] stringSplit = meme.toCharArray();
    char[] stringSplitPlus = new char[meme.toCharArray().length + 1];
    if(stringSplitPlus.length > getWidth()*getHeight()) {
      throw new IllegalArgumentException("Meme too long for image");
    }
    for(int x = 0; x < stringSplit.length; x++) {
      
      if((int)(stringSplit[x])> 127) {
        throw new 
          IllegalArgumentException("character within the meme message"
              + " has a character code that is greater than 127");
      }
    }
    for(int x = 0; x < meme.toCharArray().length; x++) {
      stringSplitPlus[x] = stringSplit[x];
    }
    stringSplitPlus[meme.toCharArray().length] = '\0';
    int i = 0;
    for(int y = 0; y < getHeight(); y++) {
      for(int x = 0; x < getWidth(); x++) {
        if (i >= stringSplitPlus.length) return;
        ColorPlusChar indPixel = new ColorPlusChar(new Color(getColor(x, y)));
        char arr = stringSplitPlus[i];
        indPixel.hideChar(arr);
        i++;
        
        setColor(x, y, indPixel);
        
      }
    }
  }
  
  /**
   * gets hidden characters in image
   * @return
   * @throws IllegalStateException
   */
  public String getMeme() throws IllegalStateException{
    char[] memeSplit = new char[10000];
    boolean isThereEnd = false;
    int i = 0;
    for(int y = 0; y < getHeight(); y++) {
      for(int x = 0; x < getWidth(); x++) {
        ColorPlusChar indPixel = new ColorPlusChar(new Color(getColor(x, y)));
        char arr = indPixel.revealChar();
        memeSplit[i] = arr;
        i++;
        if(arr == '\0') {
          isThereEnd = true;       
          return new String(memeSplit);
        }
        if((int)(arr)> 127) {
          throw new 
            IllegalStateException("character within the meme message"
                + " has a character code that is greater than 127");
        }
              
      }
    }
    if(isThereEnd == false) {
      throw new IllegalStateException("String has no end?");
    }
    return new String(memeSplit);
  }
  
}
