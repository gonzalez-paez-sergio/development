package fundamentals.linkedList;

import java.util.Iterator;

public class ListIterator<Item> implements Iterator<Item> {

  private Node<?> current;

  public ListIterator(Node<?> node) {
    this.current = node;
  }

  public boolean hasNext() {
    return current != null;
  }

  public Item next() {
    Item item = (Item) current.item;
    current = current.next;
    return item;
  }
}
