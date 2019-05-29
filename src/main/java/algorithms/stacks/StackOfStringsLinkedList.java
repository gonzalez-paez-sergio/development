package algorithms.stacks;

import algorithms.NodeOfString;

public class StackOfStringsLinkedList {
  private int size = 0;
  private NodeOfString n = new NodeOfString();

  // create an empty stack
  StackOfStringsLinkedList() {
    this.n = new NodeOfString();
  }

  // insert a new string onto stack
  void push(String item) {
    NodeOfString newNode = this.n;
    this.n = new NodeOfString();
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
}
