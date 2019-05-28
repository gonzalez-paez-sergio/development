package algorithms.stacks;

public class StackOfStringsLinkedList {
  private int size = 0;
  private Node n = new Node();

  // create an empty stack
  StackOfStringsLinkedList() {
    this.n = new Node();
  }

  // insert a new string onto stack
  void push(String item) {
    Node newNode = this.n;
    this.n = new Node();
    this.n.item = item;
    this.n.next = newNode;
    this.size++;
  }
  // remove and return the string most recently added
  String pop() {
    if (this.size <= 0) {
      return null;
    }
    this.size--;
    String result = n.item;
    this.n = n.next;

    return result;
  }

  // is the stack empty?
  boolean isEmpty() {
    return this.size <= 0;
  }

  // number of strings on the stack
  int size() {
    return this.size;
  }

  class Node {
    String item;
    Node next;
  }
}
