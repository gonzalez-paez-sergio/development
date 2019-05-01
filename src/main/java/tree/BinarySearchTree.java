package tree;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import fundamentals.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

  private Node root;

  public int size() {
    return size(root);
  }

  private int size(Node x) {
    if (null == x) {
      return 0;
    } else {
      return x.N;
    }
  }

  /**
   * return null if the key is not present in the tree rooted at root return value associated with
   * the key in the tree rooted at root
   */
  public Value get(Key key) {
    return get(root, key);
  }

  /**
   * return null if the key is not present in the subtree rooted at x return value associated with
   * the key in the subtree rooted at x
   */
  public Value get(Node x, Key key) {
    if (null == x) {
      return null;
    }
    int cmp = key.compareTo((Key) x.key);
    if (cmp < 0) { // the value must be on the left
      return get(x.left, key);
    } else if (cmp > 0) { // the value must be on the right
      return get(x.right, key);
    } else {
      return (Value) x.val;
    }
  }

  public void put(Key key, Value val) {
    root = put(root, key, val);
  }

  private Node put(Node x, Key key, Value val) {
    if (null == x) {
      return new Node(key, val, 1);
    }

    int cmp = key.compareTo((Key) x.key);
    if (cmp < 0) { // the value must be on the left
      x.left = put(x.left, key, val);
    } else if (cmp > 0) { // the value must be on the right
      x.right = put(x.right, key, val);
    } else {
      // the current is the corrects place , so we update val
      x.val = val;
    }
    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  public Key min() {
    return (Key) min(root).key;
  }

  public Node min(Node x) {
    if (null == x.left) return x;
    return min(x.left);
  }

  public Key max() {
    return (Key) max(root).key;
  }

  public Node max(Node x) {
    if (null == x.right) return x;
    return min(x.right);
  }

  public Iterable<Key> keys() {
    return keys(min(), max());
  }

  public Iterable<Key> keys(Key lo, Key hi) {
    Queue<Key> queue = new Queue<Key>();
    keys(root, queue, lo, hi);
    return queue;
  }

  /** */
  private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
    if (null == x) return;
    int cmpLo = lo.compareTo((Key) x.key);
    int cmpHi = hi.compareTo((Key) x.key);
    if (cmpLo < 0) keys(x.left, queue, lo, hi);
    if (cmpLo <= 0 && cmpHi >= 0) queue.enqueue((Key) x.key);
    if (cmpHi > 0) keys(x.right, queue, lo, hi);
  }

  /**
   * Returns the keys in the BST in level order (for debugging).
   *
   * @return the keys in the BST in level order traversal
   */
  public Iterable<Key> levelOrder() {
    Queue<Key> keys = new Queue<Key>();
    Queue<Node> queue = new Queue<Node>();
    queue.enqueue(root);
    while (!queue.isEmpty()) {
      Node x = queue.dequeue();
      if (x == null) continue;
      keys.enqueue((Key) x.key);
      queue.enqueue(x.left);
      queue.enqueue(x.right);
    }
    return keys;
  }

  /**
   * Unit tests the {@code BST} data type.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    BinarySearchTree<String, Integer> st = new BinarySearchTree<String, Integer>();
    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      st.put(key, i);
    }

    for (String s : st.levelOrder()) StdOut.println(s + " " + st.get(s));

    BTreePrinter.printNode(st.root);

    StdOut.println();

    for (String s : st.keys()) StdOut.println(s + " " + st.get(s));

    BTreePrinter.printNode(st.root);
  }
}
