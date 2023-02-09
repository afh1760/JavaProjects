/*
 * p2_project 
 * Name : Alexander Francis Hertadi 
 * Email : hertadi@wisc.edu 
 * Lecture : CS400 Lecture 002
 * Program : This program makes two types of data structures RBT and BST and then compares the 
 * performance
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Implements a generic Red-Black tree.
 *
 * DO NOT CHANGE THE METHOD SIGNATURES OF PUBLIC METHODS DO NOT ADD ANY PACKAGE LEVEL OR PUBLIC
 * ACCESS METHODS OR FIELDS.
 * 
 * You are not required to override remove. If you do not override this operation, you may still
 * have the method in your type, and have the method throw new UnsupportedOperationException. See
 * https://docs.oracle.com/javase/7/docs/api/java/lang/UnsupportedOperationException.html
 * 
 * @param <K> is the generic type of key, must be a Comparable tyle
 * @param <V> is the generic type of value
 */
public class RBT<K extends Comparable<K>, V> implements STADT<K, V> {

  // USE AND DO NOT EDIT THESE CONSTANTS
  public static final int RED = 0;
  public static final int BLACK = 1;
  public Node root; //keeps track of root node
  private int size; //number of nodes

  class Node {
    K key; //key of node
    V value; //value of node
    int color; //color of node
    Node leftChild; //left child of node
    Node rightChild; // right child of node
    Node parent; //parent pointer

    public Node(K someKey, V someValue, int color) {
      this.key = someKey;
      this.value = someValue;
      this.color = color;
      this.leftChild = new Node();
      this.rightChild = new Node();
    }
    
    /**
     * This is added to help with the balancing method later on. The presence of this "empty" black 
     * node helps immensely by reducing the number of sub-cases for the balancing method.
     */
    private Node() {
      this.key = null;
      this.value = null;
      this.color = BLACK;
    }


  }

  // TODO: define a default no-arg constructor
  public RBT() {
    root = null;
    size = 0;
  }

  /**
   * Returns the color of the node that contains the specified key. Returns RBT.RED if the node is
   * red, and RBT.BLACK if the node is black. Returns -1 if the node is not found.
   * 
   * @param
   * @return
   */
  public int colorOf(K key) {
    if (key == null) {
      return -1;
    }
    if (root == null) {
      return -1;
    } else {
      Node temp = root; //temp node starting from root
      while (temp != null) {
        if (key.compareTo(temp.key) == 0) {
          return temp.color;
        } else if (key.compareTo(temp.key) > 0) {
          temp = temp.rightChild;
        } else {
          temp = temp.leftChild;
        }
      }
    }
    return -1;
  }

  /**
   * Returns true if root is null or the color of the root is black. If root is null, returns true.
   * 
   * @return true if root is black, else returns false (for red)
   */
  public boolean rootIsBlack() {
    if (root == null || root.color == BLACK) {
      return true;
    }
    return false;
  }

  /**
   * Returns true if the node that contains this key is RED. If key is null, throws
   * IllegalNullKeyException. If key is not found, throws KeyNotFoundException.
   * 
   * @return true if the key is found and the node's color is RED, else return false if key is found
   *         and the node's color is BLACK.
   */
  public boolean isRed(K key) throws IllegalNullKeyException, KeyNotFoundException {
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    if (root == null) {
      throw new KeyNotFoundException();
    } else {
      Node temp = root; //starts from root
      while (temp != null) {
        if (key.compareTo(temp.key) == 0) {
          return (temp.color == RED);
        } else if (key.compareTo(temp.key) > 0) {
          temp = temp.rightChild;
        } else {
          temp = temp.leftChild;
        }
      }
    }
    throw new KeyNotFoundException();
  }

  /**
   * Returns true if the node that contains this key is BLACK. If key is null, throws
   * IllegalNullKeyException. If key is not found, throws KeyNotFoundException.
   * 
   * @return true if the key is found and the node's color is BLACK, else return false if key is
   *         found and the node's color is RED.
   */
  public boolean isBlack(K key) throws IllegalNullKeyException, KeyNotFoundException {
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    if (root == null) {
      throw new KeyNotFoundException();
    } else {
      Node temp = root; //temp variable starting from root
      while (temp != null) {
        if (key.compareTo(temp.key) == 0) {
          return (temp.color == BLACK);
        } else if (key.compareTo(temp.key) > 0) {
          temp = temp.rightChild;
        } else {
          temp = temp.leftChild;
        }
      }
    }
    throw new KeyNotFoundException();
  }
  
  /**
   * Returns the key that is in the root node of this ST. If root is null, returns null.
   * 
   * @return key found at root node, or null
   */
  @Override
  public K getKeyAtRoot() {
    return root.key;
  }

  /**
   * Tries to find a node with a key that matches the specified key. If a matching node is found, it
   * returns the returns the key that is in the left child. If the left child of the found node is
   * null, returns null.
   * 
   * @param key A key to search for
   * @return The key that is in the left child of the found key
   * 
   * @throws IllegalNullKeyException if key argument is null
   * @throws KeyNotFoundException    if key is not found in this BST
   */
  @Override
  public K getKeyOfLeftChildOf(K key) throws IllegalNullKeyException, KeyNotFoundException {
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    if (root == null) {
      throw new KeyNotFoundException();
    } else {
      Node temp = root; //temp node starting at root
      while (temp != null && temp.key != null) {
        if (key.compareTo(temp.key) == 0) {
          if (temp.leftChild == null) {
            return null;
          } else {
            return temp.leftChild.key;
          }
        } else if (key.compareTo(temp.key) > 0) {
          temp = temp.rightChild;
        } else {
          temp = temp.leftChild;
        }
      }
    }
    throw new KeyNotFoundException();
  }

  /**
   * Tries to find a node with a key that matches the specified key. If a matching node is found, it
   * returns the returns the key that is in the right child. If the right child of the found node is
   * null, returns null.
   * 
   * @param key A key to search for
   * @return The key that is in the right child of the found key
   * 
   * @throws IllegalNullKeyException if key is null
   * @throws KeyNotFoundException    if key is not found in this BST
   */
  @Override
  public K getKeyOfRightChildOf(K key) throws IllegalNullKeyException, KeyNotFoundException {
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    if (root == null) {
      throw new KeyNotFoundException();
    } else {
      Node temp = root; //temp node starting at root
      while (temp != null && temp.key != null) {
        if (key.compareTo(temp.key) == 0) {
          if (temp.rightChild == null) {
            return null;
          } else {
            return temp.rightChild.key;
          }
        } else if (key.compareTo(temp.key) > 0) {
          temp = temp.rightChild;
        } else {
          temp = temp.leftChild;
        }
      }
    }
    throw new KeyNotFoundException();
  }

  /**
   * Returns the height of this BST. H is defined as the number of levels in the tree.
   * 
   * If root is null, return 0 If root is a leaf, return 1 Else return 1 + max( height(root.left),
   * height(root.right) )
   * 
   * Examples: A BST with no keys, has a height of zero (0). A BST with one key, has a height of one
   * (1). A BST with two keys, has a height of two (2). A BST with three keys, can be balanced with
   * a height of two(2) or it may be linear with a height of three (3) ... and so on for tree with
   * other heights
   * 
   * @return the number of levels that contain keys in this BINARY SEARCH TREE
   */
  @Override
  public int getHeight() {
    if (root == null) {
      return 0;
    } else {
      return getHeight(root);
    }
  }

  /**
   * Helper function for getHeight to get specific height from a certain node. Uses recursion to get
   * height of each subtree
   * 
   * @param node - node to get height of
   */
  private int getHeight(Node node) {
    if (node == null || node.key == null) {
      return 0;
    }

    int lHeight = getHeight(node.leftChild);
    int rHeight = getHeight(node.rightChild);

    if (lHeight > rHeight) {
      return lHeight + 1;
    } else {
      return rHeight + 1;
    }
  }

  /**
   * Returns the keys of the data structure in sorted order. In the case of binary search trees, the
   * visit order is: L V R
   * 
   * If the SearchTree is empty, an empty list is returned.
   * 
   * @return List of Keys in-order
   */
  @Override
  public List<K> getInOrderTraversal() {
    List<K> list = new ArrayList<K>(); //Keep track of traversed elements
    if (size == 0) {
      return list;
    } else {
      getInOrderTraversal(root, list);
      return list;
    }
  }

  /**
   * Helper method to add traversed node into list
   * 
   * @param node - root of the transversed subtree
   * @param list - List initialized in main method to be added upon
   */
  private void getInOrderTraversal(Node node, List<K> list) {
    if (node == null || node.key == null) {
      return;
    }
    getInOrderTraversal(node.leftChild, list);
    list.add(node.key);
    getInOrderTraversal(node.rightChild, list);
  }

  /**
   * Returns the keys of the data structure in pre-order traversal order. In the case of binary
   * search trees, the order is: V L R
   * 
   * If the SearchTree is empty, an empty list is returned.
   * 
   * @return List of Keys in pre-order
   */
  @Override
  public List<K> getPreOrderTraversal() {
    List<K> list = new ArrayList<K>(); //Keep track of traversed elements
    if (root == null) {
      return list;
    } else {
      getPreOrderTraversal(root, list);
      return list;
    }
  }

  /**
   * Helper method to add traversed node into list
   * 
   * @param node - root of the transversed subtree
   * @param list - List initialized in main method to be added upon
   */
  private void getPreOrderTraversal(Node node, List<K> list) {
    if (node == null || node.key == null) {
      return;
    }
    list.add(node.key);
    getPreOrderTraversal(node.leftChild, list);
    getPreOrderTraversal(node.rightChild, list);
  }

  /**
   * Returns the keys of the data structure in post-order traversal order. In the case of binary
   * search trees, the order is: L R V
   * 
   * If the SearchTree is empty, an empty list is returned.
   * 
   * @return List of Keys in post-order
   */
  @Override
  public List<K> getPostOrderTraversal() {
    List<K> list = new ArrayList<K>(); //Keep track of traversed elements
    if (root == null) {
      return list;
    } else {
      getPostOrderTraversal(root, list);
      return list;
    }
  }

  /**
   * Helper method to add traversed node into list
   * 
   * @param node - root of the transversed subtree
   * @param list - List initialized in main method to be added upon
   */
  private void getPostOrderTraversal(Node node, List<K> list) {
    if (node == null || node.key == null) {
      return;
    }
    getPostOrderTraversal(node.leftChild, list);
    getPostOrderTraversal(node.rightChild, list);
    list.add(node.key);
  }

  /**
   * Returns the keys of the data structure in level-order traversal order.
   * 
   * The root is first in the list, then the keys found in the next level down, and so on.
   * 
   * If the SearchTree is empty, an empty list is returned.
   * 
   * @return List of Keys in level-order
   */
  @Override
  public List<K> getLevelOrderTraversal() {
    List<K> list = new ArrayList<K>(); //Keep track of traversed elements
    if (root == null) {
      return list;
    } else {
      int h = getHeight();
      for (int i = 1; i <= h; i++)
        getOneLevelNodes(root, i, list);
      return list;
    }
  }

  /**
   * Helper function to get nodes per level starting from left to right
   * 
   * @param node
   * @param level
   * @param list
   */
  private void getOneLevelNodes(Node node, int level, List<K> list) {
    if (level == 1 && node != null && node.key != null) {
      list.add(node.key);
    }
    else if (level > 1 && node != null && node.key != null) {
      getOneLevelNodes(node.leftChild, level - 1, list);
      getOneLevelNodes(node.rightChild, level - 1, list);
    }
  }

  /**
   * Uses the BST insert function and calls a rebalancing method
   */
  @Override
  public void insert(K key, V value) throws IllegalNullKeyException, DuplicateKeyException {
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    Node add = new Node(key, value, RED);
    if (root == null) {
      root = new Node(key, value, BLACK);
    } else {
      Node temp = root;
      Node prev = null;
      while (temp != null && temp.key != null) {
        prev = temp;
        if (key.compareTo(temp.key) == 0) {
          throw new DuplicateKeyException();
        } else if (key.compareTo(temp.key) > 0) {
          temp = temp.rightChild;
        } else {
          temp = temp.leftChild;
        }
      }
      if (key.compareTo(prev.key) < 0) {
        prev.leftChild = add;
        add.parent = prev;
      } else {
        prev.rightChild = add;
        add.parent = prev;
      }
      size++;
      balance(add);
    }
  }

  /**
   * The crux of the Red-Black Tree class
   * 
   * Helper function for insert() to rebalance the tree according to RBT rules.
   * 
   * To help me personally, there exists 4 subcases in this method:
   * 
   * if the node is the root/no parent => set node to root and root to black. if parent is black =>
   * do nothing and return. if sibling is red => recolor. if sibling is black => tnr(this is the
   * tricky part)
   * 
   * 
   * To not have to add a case for no sibling, I have counteracted this by adding null children to
   * every leaf with color black such that it falls into the black sub-case. However during
   * traversal it should not add additional content since I have set the key and value to null, such
   * that it is only serves as a color indicator
   * 
   */
  private void balance(Node node) {
    /* Case 1 */
    if (node.parent == null) {
      root = node;
      root.color = BLACK;
      return;
    }

    /* Case 2 */
    if (node.parent.color == BLACK) {
      return;
    }
    
    /* sibling color */
    Node sibling = null;
    if (node.parent.parent.leftChild == node.parent) {
      sibling = node.parent.parent.rightChild;
    } else {
      sibling = node.parent.parent.leftChild;
    }

    /* Case 3 */
    if (sibling.color == RED) {
      node.parent.color = 1;
      sibling.color = 1;
      node.parent.parent.color = 0;
      balance(node.parent.parent);
      return;
    } else {
      /* Case 4 */
      if (node.parent.leftChild == node && node.parent.parent.rightChild == node.parent) {
        rRot(node);
        lRot(node);
        balance(node);
        return;
      }
      if (node.parent.rightChild == node && node.parent.parent.leftChild == node.parent) {
        lRot(node);
        rRot(node);
        balance(node);
        return;
      }
      if (node.parent.rightChild == node && node.parent.parent.rightChild == node.parent) {
        lRot(node.parent);
        balance(node.parent);
        return;
      }
      if (node.parent.leftChild == node && node.parent.parent.leftChild == node.parent) {
        rRot(node.parent);
        balance(node.parent);
        return;
      }
    }
  }
  
  /**
   * Left rotation helper function for rebalancing the tree
   * 
   * @param node
   */
  private void lRot(Node node) {
    Node parent = node.parent; //variable keeping track for parent
    Node leftChild = node.leftChild; //right child variable
    node.leftChild = parent; //where the switch starts
    parent.rightChild = leftChild;
    if(leftChild!=null){
        leftChild.parent = parent;
    }
    int color = parent.color;
    parent.color = node.color;
    node.color = color;
    Node grandParent = parent.parent;
    parent.parent = node;
    node.parent = grandParent;
    if(grandParent==null){
        root = node;
        return;
    }
    else{
        if(grandParent.leftChild == parent){
            grandParent.leftChild = node;
        }   
        else{
            grandParent.rightChild = node;
        }
    }
  }
  
  /**
   * Right rotation helper function for rebalancing the tree
   * 
   * @param node
   */
  private void rRot(Node node){
    Node parent = node.parent; //variable keeping track for parent
    Node rightChild = node.rightChild; //right child variable
    node.rightChild = parent;//where the switch starts
    parent.leftChild = rightChild;
    if(rightChild!=null){
        rightChild.parent = parent;
    }
    int color = parent.color;
    parent.color = node.color;
    node.color = color;
    Node grandParent = parent.parent;
    parent.parent = node;
    node.parent = grandParent;
    
    if(grandParent==null){
        root = node;
        return;
    }
    else{
        if(grandParent.leftChild == parent){
            grandParent.leftChild = node;
        }
        else{
            grandParent.rightChild = node;
        }
    }   
}
  
  /**
   * Not implementing this method
   */
  @Override
  public boolean remove(K key) throws IllegalNullKeyException {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the value associated with the specified key.
   *
   * Does not remove key or decrease number of keys If key is null, throw IllegalNullKeyException If
   * key is not found, throw KeyNotFoundException().
   */
  @Override
  public V get(K key) throws IllegalNullKeyException, KeyNotFoundException {
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    if (root == null) {
      throw new KeyNotFoundException();
    } else {
      Node temp = root; //temp variable
      while (temp != null) {
        if (key.compareTo(temp.key) == 0) {
          return temp.value;
        } else if (key.compareTo(temp.key) > 0) {
          temp = temp.rightChild;
        } else {
          temp = temp.leftChild;
        }
      }
    }
    throw new KeyNotFoundException();
  }

  /**
   * Returns true if the key is in the data structure If key is null, throw IllegalNullKeyException
   * Returns false if key is not null and is not present
   */
  @Override
  public boolean contains(K key) throws IllegalNullKeyException {
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    if (root == null) {
      return false;
    } else {
      Node temp = root; //starting search with root just like methods above
      while (temp != null) {
        if (key.compareTo(temp.key) == 0) {
          return true;
        } else if (key.compareTo(temp.key) > 0) {
          temp = temp.rightChild;
        } else {
          temp = temp.leftChild;
        }
      }
      return false;
    }
  }

  /**
   * Returns the number of key,value pairs in the data structure
   */
  @Override
  public int numKeys() {
    return size;
  }

  @Override
  public void print() {
    int h = getHeight();
    for (int i = 1; i <= h; i++) {
      List<K> list = new ArrayList<K>();
      getOneLevelNodes(root, i, list);
      for (int j = 1; j <= h-i; j++) {
        System.out.print(" ");
      }
      for (K key : list) {
        System.out.print(key + " ");
      }
      System.out.println("");
    }
  }


  // TODO: override the insert method so that it rebalances
  // according to red-black tree insert algorithm.


  // TODO [OPTIONAL] you may override print() to include
  // color R-red or B-black.

}
