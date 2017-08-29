package search;

import fundamentals.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;

	public BinarySearchST(int capacity) { // See Algorithm 1.1 for standard
											// array-resizing code.
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean contains(Key key) {
		return null != get(key);
	}

	public Value get(Key key) {
		if (isEmpty()) {
			return null;
		}
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0)
			return vals[i];
		else
			return null;
	}

	public int rank(Key key, int lo, int hi) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

	public int rank(Key key) {
		return rank(key, 0, N - 1);
	}

	public void put(Key key, Value value) { // Search for key. Update value if
											// found; grow table if new.
		int intRank = rank(key);
		if (intRank < N && keys[intRank].compareTo(key) == 0) {
			vals[intRank] = value;
			return;
		}

		for (int j = N; j > intRank; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[intRank] = key;
		vals[intRank] = value;
		N++;
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> q = new Queue<Key>();
		for (int i = rank(lo); i < rank(hi); i++) {
			q.enqueue(keys[i]);
		}
		if (contains(hi)) {
			q.enqueue(keys[rank(hi)]);
		}
		return q;
	}

	public Iterable<Key> keys() {
		return keys(keys[0], keys[N - 1]);
	}

	public Iterable<Key> keys(Key lo) {
		return keys(lo, keys[N - 1]);
	}

	public Key getFirst() {
		return keys[0];
	}
}