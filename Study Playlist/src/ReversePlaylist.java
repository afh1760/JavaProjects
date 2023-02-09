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
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReversePlaylist implements Iterator<Song> {
  private DoublyLinkedNode<Song> tail = null; // tail variable to keep track
  private DoublyLinkedNode<Song> current; // current song being iterated

  /**
   * Sets up Reverse playlist object
   * 
   * @param song - assumed tail of a song collection
   */
  public ReversePlaylist(DoublyLinkedNode<Song> song) {
    tail = song;
    current = tail;
  }

  /**
   * Checks if the list has a "next" element
   */
  public boolean hasNext() {
    if (current != null) {
      return true;
    }
    return false;
  }

  /**
   * Returns the current element and shift the current element to the previous node in the song
   * collection
   */
  @Override
  public Song next() {
    if (current == null) {
      throw new NoSuchElementException();
    }
    DoublyLinkedNode<Song> tempCurrent = current; // temp variable to store current, will be
                                                  // returned
    current = current.getPrevious();
    return tempCurrent.getData();
  }


}
