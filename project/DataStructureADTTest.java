import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class DataStructureADTTest<T extends DataStructureADT<String, String>> {

  private T ds;

  protected abstract T createInstance();

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
  }

  @BeforeEach
  void setUp() throws Exception {
    ds = createInstance();
  }

  @AfterEach
  void tearDown() throws Exception {
    ds = null;
  }


  @Test
  void test00_empty_ds_size() {
    if (ds.size() != 0)
      fail("data structure should be empty, with size=0, but size=" + ds.size());
  }

  // TODO: review tests 01 - 04

  @Test
  void test01_insert_one() {
    String key = "1";
    String value = "one";
    ds.insert(key, value);
    assert (ds.size() == 1);
  }

  @Test
  void test02_insert_remove_one_size_0() {
    String key = "1";
    String value = "one";
    ds.insert(key, value);
    assert (ds.remove(key)); // remove the key
    if (ds.size() != 0)
      fail("data structure should be empty, with size=0, but size=" + ds.size());
  }

  @Test
  void test03_duplicate_exception_thrown() {
    String key = "1";
    String value = "one";
    ds.insert("1", "one");
    ds.insert("2", "two");
    try {
      ds.insert(key, value);
      fail("duplicate exception not thrown");
    } catch (RuntimeException re) {
    }
    assert (ds.size() == 2);
  }


  @Test
  void test04_remove_returns_false_when_key_not_present() {
    String key = "1";
    String value = "one";
    ds.insert(key, value);
    assert (!ds.remove("2")); // remove non-existent key is false
    assert (ds.remove(key)); // remove existing key is true
    if (ds.get(key) != null)
      fail("get(" + key + ") returned " + ds.get(key) + " which should have been removed");
  }


  // TODO: add tests 05 - 07 as described in assignment

  @Test
  void test05_insert_remove_one() {
    String key = "1";
    String value = "one";
    ds.insert(key, value);
    assert (ds.remove(key)); // remove the key
    if (ds.contains(key) != false)
      fail("contains(" + key + ") returned true which should have been false");
  }

  @Test
  void test06_insert_many_size() {
    ds.insert("1", "one");
    ds.insert("2", "two");
    ds.insert("3", "three");
    ds.insert("4", "four");
    ds.insert("5", "five");
    ds.insert("6", "six");
    if (ds.size() != 6)
      fail("data structure should have 6 elements, with size=6, but size=" + ds.size());
  }

  @Test
  void test07_duplicate_values() {
    ds.insert("1", "one");
    try {
      ds.insert("2", "one");
    } catch (RuntimeException re) {
      fail("duplicate exception thrown");
    }
  }

  /**
   * 1st self test. Removes an element that does not exist. Expected IllegalArgyumentException
   * 
   */
  @Test
  void test08_remove_null_value() {
    try {
      ds.remove(null);
      fail("non-existent element removed. Expected output: IllegalArgumentException.");
    } catch(IllegalArgumentException e) {}
  }

  /**
   * Self test function No.2. Tests that if a value is returned by get it also returns true in
   * contains
   */
  @Test
  void test09_get_implies_contains() {
    ds.insert("1", "one");
    assert (ds.get("1") == "one");
    if (ds.contains("1") == false) {
      fail("Get returns the value one but contains returns false");
    }

  }

  /**
   * Inserts an element with null value. If it throws an illegal argument exception then it fails
   */
  @Test
  void test10_insert_null_value() {
    try {
      ds.insert("2", null);
    } catch (IllegalArgumentException re) {
      fail("caught a faulty illegal argument exception");
    }
  }
  
  /**
   * Gets null key. If thrown an exception it passes
   */
  @Test
  void test11_get_null_key() {
    try {
      ds.get(null);
      fail("didn't catch an IllegalArgumentException");
    } catch (IllegalArgumentException re) {}
  }
}
