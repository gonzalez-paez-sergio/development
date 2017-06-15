package fundamentals;

public class Stack<Item> {
	private Item[] a; // stack entries
	private int N; // size

	@SuppressWarnings("unchecked")
	public Stack(int cap) {
		a = (Item[]) new Object[cap];
	}

	/**
	 * new constructor for dynamic resizing
	 */

	@SuppressWarnings("unchecked")
	public Stack() {
		a = (Item[]) new Object[1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public Item pop() {
		// Remove item from top of stack.
		if (this.isEmpty()) {
			return null;
		}
		Item item = a[--N];
		a[N] = null; // Avoid loitering (see text).
		if (N > 0 && N == a.length / 4) {
			// System.out.printf("resizing from %d to %d",a.length, a.length/2);
			// System.out.println();
			resize(a.length / 2);
		}
		return item;
	}

	public void push(Item item) {
		// Add item to top of stack.
		if (N == a.length) {
			resize(2 * a.length);
		}
		a[N++] = item;
	}

	private void resize(int max) { // Move stack of size N <= max to a new array
									// of size max.
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
}