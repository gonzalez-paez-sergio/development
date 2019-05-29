package algorithms.queues;

import algorithms.Node;

public class Queue<T> {
  Node<T> first;
  Node<T> last;
  int size;

  void enqueue(T item) {
    Node<T> n = this.last;
    this.last = new Node(item);
    if (this.isEmpty()) {
      this.first = this.last;
    } else {
      n.next = this.last;
    }
    this.size++;
  }

  T dequeue() {
    Node<T> n = this.first;
    T s = n.item;
    this.first = n.next;
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
