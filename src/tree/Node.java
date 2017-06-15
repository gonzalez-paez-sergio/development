package tree;

public class Node<Key extends Comparable<Key>, Value> {
	Key key;
	Value val;
	Node left;
	Node right;
	int N;

	public Node(Key key, Value val, int N) {
		this.key = key;
		this.val = val;
		this.N = N;

	}
}