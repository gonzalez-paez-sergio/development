package fundamentals.linkedList;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

	private Node<Item> first;
	private int N;

	private class Node<Item> {

		public Item item;
		public Node<Item> next;
	}

	public boolean isEmpty() {
		return null == first;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		Node<Item> nodeOldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = nodeOldFirst;
		N++;
	}

	public Item pop() {
		Item item = (Item) first.item;
		first = first.next;
		N--;
		return item;
	}

	/**
	 * Returns an iterator to this stack that iterates through the items in LIFO
	 * order.
	 *
	 * @return an iterator to this stack that iterates through the items in LIFO
	 *         order
	 */
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

}
