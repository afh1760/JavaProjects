//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P07 Study Playlist
// Files: Song.java, DoublyLinkedNode.java, SongCollection.java, Playlist.java, ReversePlaylist.java
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
public class DoublyLinkedNode<T> {
  private T data; // private var storing data
  private DoublyLinkedNode<T> previous; // private field storing instance previous
  private DoublyLinkedNode<T> next; // private field dstoring next for instance

  /**
   * Initializes a new node with the specified information.
   * 
   * @param previous - node, which comes before this node in a doubly linked list
   * @param data     - to be stored within this node
   * @param next     - node, which comes after this node in a doubly linked list
   */
  public DoublyLinkedNode(DoublyLinkedNode<T> previous, T data, DoublyLinkedNode<T> next) {
    this.data = data;
    this.previous = previous;
    this.next = next;
  }

  /**
   * Initialize a new node with the specified data, and null next and previous reference.
   * 
   * @param data - to be stored within this node
   */
  public DoublyLinkedNode(T data) {
    this.data = data;
  }

  /**
   * Accessor method for this node's data.
   * 
   * @return the data stored within this node.
   */
  public T getData() {
    return this.data;
  }

  /**
   * Accessor method for this node's next node reference.
   * 
   * @return reference to the node that comes after this one in the list, or null when this is the
   *         last node in that list
   */
  public DoublyLinkedNode<T> getNext() {
    return this.next;
  }

  /**
   * Mutator method for this node's next node reference.
   * 
   * @param next - node, which comes after this node in a doubly linked list
   */
  public void setNext(DoublyLinkedNode<T> next) {
    this.next = next;
  }

  /**
   * Accessor method for this node's previous node reference.
   * 
   * @return reference to the node that comes before this one in the list or null when this is the
   *         first node in that list
   */
  public DoublyLinkedNode<T> getPrevious() {
    return this.previous;
  }

  /**
   * Mutator method for this node's previous node reference.
   * 
   * @param previous - node, which comes before this node in a doubly linked list
   */
  public void setPrevious(DoublyLinkedNode<T> previous) {
    this.previous = previous;
  }
}
