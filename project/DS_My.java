/*
 * p1_project 
 * Name : Alexander Francis Hertadi 
 * Email : hertadi@wisc.edu 
 * Lecture : CS400 Lecture 002
 * Program : This program tests implementations of data structures and compares the runtime between
 * each implementation attempt
 */


/**
 * My implementation of a data structure containing 2 elements per space.
 * 
 * I used 2 arrays for the key and value running in parallel indexes for each data entry. To combat
 * the non-modify-able size of an array I made a new array with twice the length once the array has
 * only 1 space left.
 * 
 * @author A. F. Hertadi
 *
 */
public class DS_My implements DataStructureADT<String, String> {

  private String[] ky; // stores key variable
  private String[] val; // stores value variable
  private static final int INITIAL_CAPACITY = 20; // initial capacity of array
  private int size; // current number of elements

  public DS_My() {
    this.size = 0;
    ky = new String[INITIAL_CAPACITY];
    val = new String[INITIAL_CAPACITY];
  }

  @Override
  public void insert(String key, String value) {
    if (key == null) {
      throw new IllegalArgumentException("null key");
    }

    for (int i = 0; i < this.size; i++) {
      if (ky[i].equals(key)) {
        throw new RuntimeException("duplicate key");
      }
    }

    // Array length doubling when full
    if (size >= ky.length - 1) {
      String[] ky2 = new String[ky.length * 2]; // new key array with double length
      String[] val2 = new String[ky.length * 2]; // new value array with double length
      for (int i = 0; i < ky.length; i++) {
        ky2[i] = ky[i];
        val2[i] = val[i];
      }
      ky = ky2; // finally renaming temporary array as the main key array
      val = val2; // finally renaming temporary array as the main value array
    }
    ky[size] = key;
    val[size++] = value; // increments size up after setting val[size] to be the value

  }

  @Override
  public boolean remove(String key) {
    if (key == null) {
      throw new IllegalArgumentException("null key");
    }
    for (int i = 0; i < this.size; i++) {
      if (key.equals(ky[i])) {
        for (int j = i; j < this.size; j++) {
          ky[j] = ky[j + 1]; // After deleting data point moves all elements after up one index
          val[j] = val[j + 1];
        }
        size--;
        return true;
      }
    }
    return false;
  }

  @Override
  public String get(String key) {
    if (key == null) {
      throw new IllegalArgumentException("null key");
    }
    for (int i = 0; i < this.size; i++) {
      if (key.equals(ky[i])) {
        return val[i];
      }
    }
    return null;
  }

  @Override
  public boolean contains(String key) {
    for (int i = 0; i < this.size; i++) {
      if (key.equals(ky[i])) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int size() {

    return this.size;
  }
}

