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
/**
 * Class to represent the nodes of the binary search tree.
 * 
 * @author Michelle Jensen (mejensen5)
 */

public class CampTreeNode {

  private Camper data; // Data of selected camper(FIrstname, Lastname, Age)
  private CampTreeNode leftNode; // Left node of this node
  private CampTreeNode rightNode; // right node of this node

  /**
   * Constructor for an empty CampTreeNode. Sets all values to null.
   */
  public CampTreeNode() {
    data = null;
    leftNode = null;
    rightNode = null;
  }

  /**
   * Getter for data field.
   * 
   * @return The data of this CampTreeNode
   */
  public Camper getData() {
    return data;
  }

  /**
   * Getter for leftNode field.
   * 
   * @return The leftNode of this CampTreeNode
   */
  public CampTreeNode getLeftNode() {
    return leftNode;
  }

  /**
   * Getter for rightNode field.
   * 
   * @return The rightNode of this CampTreeNode
   */
  public CampTreeNode getRightNode() {
    return rightNode;
  }

  /**
   * Setter for data field
   * 
   * @param camper, the Camper that the data field will be set to
   */
  public void setData(Camper camper) {
    data = camper;
  }

  /**
   * Setter for leftNode field
   * 
   * @param node, the CampTreeNode that the leftNode field will be set to
   */
  public void setLeftNode(CampTreeNode node) {
    leftNode = node;
  }

  /**
   * Setter for rightNode field
   * 
   * @param node, the CampTreeNode that the rightNode field will be set to
   */
  public void setRightNode(CampTreeNode node) {
    rightNode = node;
  }

}
