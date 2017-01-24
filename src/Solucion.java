import edu.princeton.cs.algs4.StdIn;

public class Solucion {

	static Node root = new Node();

	public static class Node {
		int size;
		private static int N = 26;
		Node[] children = new Node[N];

		private static int getCharIndex(char c) {
			return c - 'a';
		}

		private Node getNode(char c) {
			return children[getCharIndex(c)];
		}

		private char getChar(Node node) {
			return getNodeIndex(node);
		}

		private char getNodeIndex(Node node) {
			for (int i = 0; i < children.length; i++) {
				if (node == children[i]) {
					return (char) ('a' + i);
				}
			}
			return 0;
		}

		private void setNode(char c, Node node) {
			children[getCharIndex(c)] = node;
		}

		public void add(String string) {
			add(string, 0);
		}

		public void add(String string, int index) {
			//print(this);
			size++;

			if (index == string.length()) {
				return;
			}

			char current = string.charAt(index);

			System.out.printf("child[%d]=%c,%d\n", index, current,
					getCharIndex(current));
			
			Node child = getNode(current);
			if (child == null) {
				child = new Node();
				setNode(current, child);
			}
			child.add(string, index + 1);
		}

		private void print(Node node) {
			for (int i = 0; i < node.children.length; i++) {
				System.out.printf("val[%d]=%s,", i, getNodeIndex(node.children[i]));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		// Node node = new Node();
		// build symbol table from standard input
		for (; !StdIn.isEmpty();) {
			String key = StdIn.readString();
			System.out.printf("adding key %s\n", key);

			root.add(key);
		}

	}
}
