package algorithms.queues;

import algorithms.NodeOfString;

public class QueueOfStrings {
  NodeOfString first;
  NodeOfString last;
  int size;

  void enqueue(String item) {
    NodeOfString tmp = this.last;
    this.last = new NodeOfString();
    this.last.next = null;
    this.last.item = item;
    if (this.isEmpty()) {
      this.first = this.last;
    } else {
      tmp.next = this.last;
    }
    this.size++;
  }

  String dequeue() {
    NodeOfString oldFirst = this.first;
    String s = oldFirst.item;
    this.first = oldFirst.next;
    this.size--;
    return s;
  }

  boolean isEmpty() {
    return null == this.first;
  }

  int size() {
    return this.size;
  }
}
