//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P09 Camp Badger
// Files: Camper.java, CampManager.java, CampTreeNode.java, CamperBST.java,
//////////////////// CampEnrollmentApp.java
// Course: CS 300
//
// Author: Alexander Hertadi
// Email: hertadi@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Daniel Ni
// Partner Email: pni4@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// x Write-up states that pair programming is allowed for this assignment.
// x We have both read and understand the course Pair Programming Policy.
// x We have registered our team prior to the team registration deadline.
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

public class CampManager {

  private CamperBST campers; // BST object depicting campers organized to different camps
  private final static String[] CABIN_NAMES =
      new String[] {"Otter Overpass", "Wolverine Woodland", "Badger Bunkhouse"}; // List of cabin
                                                                                 // names to
                                                                                 // organize campers
                                                                                 // based on age

  /**
   * Constructor for the CampManager by initializing the campers field
   * 
   */
  public CampManager() {
    campers = new CamperBST();
  }

  /**
   * Prints statistics based on the current "state" of the camp. The statistics to be printed is the
   * total number of campers.
   */
  public void printStatistics() {
    System.out.println(campers.size());
  }

  /**
   * "Enrolls" a camper by determining their cabin and adding them to the tree.
   * 
   * @param newCamper
   */
  public void enrollCamper(Camper newCamper) {
    int age = newCamper.getAge(); //gets age of camper from camper class method
    if (age >= 8 && age <= 9) {
      newCamper.assignCabin(CABIN_NAMES[0]);
      campers.insert(newCamper);
    } else if (age >= 10 && age <= 12) {
      newCamper.assignCabin(CABIN_NAMES[1]);
      campers.insert(newCamper);
    } else if (age >= 13 && age <= 14) {
      newCamper.assignCabin(CABIN_NAMES[2]);
      campers.insert(newCamper);
    }
    // campers.insert(newCamper);
  }

  /**
   * "Unenrolls" a camper by removing them from the tree.
   * 
   * @param delCamper - the camper to be unenrolled the camp
   * @throws java.util.NoSuchElementException - if CamperBST.delete throws the exception
   *         java.util.NoSuchElementException
   */
  public void unenrollCamper(Camper delCamper) throws java.util.NoSuchElementException {
    campers.delete(delCamper);
  }

  public Iterator<Camper> traverse(String order) {
    return campers.traverse(order);
  }

}
