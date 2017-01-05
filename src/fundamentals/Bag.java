package fundamentals;


import java.util.Iterator;
public class Bag<Item> implements Iterable<Item> {
	private Node first; // first node in list
	private int n;               // number of elements in bag

	private class Node {
		Item item;
		Node next;
	}

	public void add(Item item) { // same as push() in Stack
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
n++;	}

	public Iterator<Item> iterator() { 
		return new ListIterator(); 
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext() {
			return current != null; 
		}
		public void remove() { }
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

    
    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    public int size() {
        return n;
    }
}