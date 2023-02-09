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

// DO IMPLEMENT A BINARY SEARCH TREE IN THIS CLASS

/**
 * Defines the operations required of student's BST class.
 *
 * NOTE: There are many methods in this interface that are required solely to support gray-box
 * testing of the internal tree structure. They must be implemented as described to pass all grading
 * tests.
 * 
 * @author Deb Deppeler (deppeler@cs.wisc.edu)
 * @param <K> A Comparable type to be used as a key to an associated value.
 * @param <V> A value associated with the given key.
 */
public class BST<K extends Comparable<K>, V> implements STADT<K, V> {
  class Node {
    K key; //key associated with code
    V value; //value associated with code
    Node leftChild; //left child of node
    Node rightChild; //right child of node

    public Node(K someKey, V someValue) {
      this.key = someKey;
      this.value = someValue;
    }


  }

  public Node root;
  private int size;

  public BST() {
    root = null;
    size = 0;
  }

  /**
   * Returns the key that is in the root node of this ST. If root is null, returns null.
   * 
   * @return key found at root node, or null
   */
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
  public K getKeyOfLeftChildOf(K key) throws IllegalNullKeyException, KeyNotFoundException {
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    if (root == null) {
      throw new KeyNotFoundException();
    } else {
      Node temp = root; // starts at root
      while (temp != null) {
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
  public K getKeyOfRightChildOf(K key) throws IllegalNullKeyException, KeyNotFoundException {
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    if (root == null) {
      throw new KeyNotFoundException();
    } else {
      Node temp = root; //starts search at root
      while (temp != null) {
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
  public int getHeight() {
    if (root == null) {
      return 0;
    } else if (root.leftChild == null && root.rightChild == null) {
      return 1;
    } else {
      return getHeight(root); //helper function
    }
  }

  /**
   * Helper function for getHeight to get specific height from a certain node. Uses recursion to get
   * height of each subtree
   * 
   * @param node - node to get height of
   */
  private int getHeight(Node node) {
    if (node == null) {
      return 0;
    }

    int lHeight = getHeight(node.leftChild);
    int rHeight = getHeight(node.rightChild);

    /* gets max eight from subtrees */
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
  public List<K> getInOrderTraversal() {
    List<K> list = new ArrayList<K>(); //list to put iterations
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
    if (node == null) {
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
  public List<K> getPreOrderTraversal() {
    List<K> list = new ArrayList<K>(); //to put traversed elements
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
    if (node == null) {
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
  public List<K> getPostOrderTraversal() {
    List<K> list = new ArrayList<K>(); //to store traversed node keys
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
    if (node == null) {
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
  public List<K> getLevelOrderTraversal() {
    List<K> list = new ArrayList<K>(); //to store traversed node keys
    if (root == null) {
      return list;
    } else {
      int h = getHeight();
      for (int i = 1; i <= h; i++) {
        getOneLevelNodes(root, i, list);
      }
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
    if (level == 1 && node != null) {
      list.add(node.key);
    } else if (level > 1 && node != null) {
      getOneLevelNodes(node.leftChild, level - 1, list);//recursive functions
      getOneLevelNodes(node.rightChild, level - 1, list);
    }
  }


  /**
   * Add the key,value pair to the data structure and increase the number of keys. If key is null,
   * throw IllegalNullKeyException; If key is already in data structure, throw
   * DuplicateKeyException(); Do not increase the num of keys in the structure, if key,value pair is
   * not added.
   */
  public void insert(K key, V value) throws IllegalNullKeyException, DuplicateKeyException {
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    Node add = new Node(key, value);
    if (root == null) {
      root = add;
    } else {
      Node temp = root;
      Node prev = null;
      while (temp != null) {
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
      } else {
        prev.rightChild = add;
      }
    }
    size++;
  }



  /**
   * If key is found, remove the key,value pair from the data structure and decrease num keys, and
   * return true. If key is not found, do not decrease the number of keys in the data structure,
   * return false. If key is null, throw IllegalNullKeyException
   */
  public boolean remove(K key) throws IllegalNullKeyException {
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    int a = size; // keeps track of size to put out true/false
    deleteHelp(root, key);
    int b = size; // keeps track of size to put out true/false
    if (a == b) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Recursive helper method to delete
   * 
   * @param current - The "root" of the subtree we are deleting from, ie the node we are currently
   *                at.
   * @param key     - the node to be deleted from the tree
   * @return - node deleted or null
   */
  private Node deleteHelp(Node current, K key) {
    if (current == null) {
      return null;
    }
    if (current.key.compareTo(key) > 0) {
      current.leftChild = deleteHelp(current.leftChild, key);
    } else if (current.key.compareTo(key) < 0) {
      current.rightChild = deleteHelp(current.rightChild, key);
    } else {
      if (current.leftChild == null) {
        current = current.rightChild;
      } else if (current.rightChild == null) {
        current = current.leftChild;
      } else {
        size--;
        Node successor = findSuccessor(current.rightChild);
        current.key = successor.key;
        current.rightChild = deleteHelp(current.rightChild, successor.key);
      }
    }
    return current;
  }

  /**
   * Helper method for deleteHelp to find successor
   * 
   * @param node - right subtree to be found the left-est node
   * @return - most left node of subtree
   */
  private Node findSuccessor(Node node) {
    if (node.leftChild == null)
      return node;
    else
      return findSuccessor(node.leftChild);
  }


  /**
   * Returns the value associated with the specified key.
   *
   * Does not remove key or decrease number of keys If key is null, throw IllegalNullKeyException If
   * key is not found, throw KeyNotFoundException().
   */
  public V get(K key) throws IllegalNullKeyException, KeyNotFoundException {
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    if (root == null) {
      throw new KeyNotFoundException();
    } else {
      Node temp = root;
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
  public boolean contains(K key) throws IllegalNullKeyException {
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    if (root == null) {
      return false;
    } else {
      Node temp = root;
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
  public int numKeys() {
    return size;
  }


  /**
   * Print the tree.
   *
   * For our testing purposes of your print method: all keys that we insert in the tree will have a
   * string length of exactly 2 characters. example: numbers 10-99, or strings aa - zz, or AA to ZZ
   *
   * This makes it easier for you to not worry about spacing issues.
   *
   * You can display a binary search in any of a variety of ways, but we must see a tree that we can
   * identify left and right children of each node
   *
   * For example:
   * 
   * 30 /\ / \ 20 40 / /\ / / \ 10 35 50
   * 
   * Look from bottom to top. Inorder traversal of above tree (10,20,30,35,40,50)
   * 
   * Or, you can display a tree of this kind.
   * 
   * | |-------50 |-------40 | |-------35 30 |-------20 | |-------10
   * 
   * Or, you can come up with your own orientation pattern, like this.
   * 
   * 10 20 30 35 40 50
   * 
   * The connecting lines are not required if we can interpret your tree.
   * 
   */
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


} // copyrighted material, students do not have permission to post on public sites



// deppeler@cs.wisc.edu
