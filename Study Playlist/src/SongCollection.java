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

public class SongCollection implements Iterable<Song> {
  private DoublyLinkedNode<Song> head; // variable containing head of list
  private DoublyLinkedNode<Song> tail; // variable containing tail of list
  private boolean playDirectionForward; // play direction variable

  /**
   * Initializes the song collection list
   */
  public SongCollection() {
    head = null;
    tail = null;
    playDirectionForward = true;
  }

  /**
   * adds song to the end/tail of this doubly linked list when song is null, throws a
   * NullPointerException
   * 
   * @param song
   */
  public void add(Song song) {
    if (song == null) {
      throw new NullPointerException();
    }
    DoublyLinkedNode<Song> newNode = new DoublyLinkedNode<Song>(song);
    if (head == null && tail == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.setPrevious(tail);
      tail.setNext(newNode);
      tail = newNode;
    }

  }

  /**
   * removes and returns song from the front/head of this list when list is empty, throws a
   * NoSuchElementException
   * 
   * @return song removed
   */
  public Song remove() throws NoSuchElementException {
    if (head == null && tail == null) {
      throw new NoSuchElementException();
    }
    Song removed = head.getData(); // temp song var to be returned as the removed song
    head = head.getNext();
    if (head == null) {
      tail = null;
    }
    return removed;
  }

  /**
   * Sets the play direction to true or false according to if it is forward
   * 
   * @param isForward true if it is forward, false otherwise
   */
  public void setPlayDirection(boolean isForward) {
    if (isForward == true) {
      playDirectionForward = true;
    } else {
      playDirectionForward = false;
    }
  }

  /**
   * Creates a playlist object when playDirectionForward is true, and reverse playlist when
   * otherwise
   */
  @Override
  public Iterator<Song> iterator() {
    if (playDirectionForward == true) {
      return new Playlist(head);
    } else {
      return new ReversePlaylist(tail);
    }
  }

  ///////////////////////////////////////////////////////////////////////////////////
  // For each of the following big-O time complexity analyses, consider the problem
  // size to be the number of Songs that are stored within the argument songs, when
  // the method is first called.
  //
  // For analysisMethodA, the big-O time complexity is O(1).
  //
  // For analysisMethodB, the big-O time complexity is O(n).
  //
  // For analysisMethodC, the big-O time complexity is O(1).
  //
  ///////////////////////////////////////////////////////////////////////////////////
  public static void analysisMethodA(SongCollection songs) {
    songs.add(new Song("C is for Cookie.", "Cookie Monster"));
    songs.add(new Song("Rubber Duckie.", "Ernie"));
    songs.add(new Song("Elmo's Song.", "Elmo"));
  }

  public static void analysisMethodB(SongCollection songs) {
    SongCollection copy = new SongCollection();
    for (Song song : songs)
      copy.add(song);
    for (Song song : copy)
      System.out.println(song);
  }

  public static void analysisMethodC(SongCollection songs) {
    Iterator<Song> playlist = songs.iterator();
    for (int i = 0; i < 1000; i++)
      if (playlist.hasNext())
        System.out.println(playlist.next());
  }

  public static void main(String[] args) {
    SongCollection songs = new SongCollection();
    analysisMethodA(songs);
    analysisMethodB(songs);
    analysisMethodC(songs);
  }
}
