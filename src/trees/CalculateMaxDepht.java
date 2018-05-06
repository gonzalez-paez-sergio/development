package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CalculateMaxDepht {

	public static void main(String[] string) {

		Node node = new Node(4);

		node.l = new Node(5);
		node.r = new Node(6);

		node.r.l = new Node(7);
		node.r.r = new Node(10);

		node.r.l.r = new Node(8);
		node.r.l.l = new Node(9);

		node.r.r.r = new Node(11);
		node.r.r.l = new Node(12);

		node.r.r.r.l = new Node(13);

		// System.out.println(depth(node));
		// System.out.println(depthIterative(node));
		// System.out.println(treeHeight(node));
		System.out.println(treeHeight1(node));

		node = new Node(0);
		node.l = new Node(1);

		// System.out.println(depth(node));
		// //System.out.println(depthIterative(node));
		// System.out.println(treeHeight(node));
		System.out.println(treeHeight1(node));

	}

	static int depth(Node node) {

		int depthR = 0;
		int depthL = 0;
		if (null == node.l && null == node.r) {
			return 1;
		}
		if (null != node.l) {
			depthL = 1 + depth(node.l);
		}

		if (null != node.r) {
			depthR = 1 + depth(node.r);
		}

		return Math.max(depthR, depthL);
	}

	static int depthIterative(Node node) {
		Stack<Node> stack = new Stack<Node>();

		stack.push(node);
		int i = 0;
		while (i++ < 16) {
			System.out.printf("current node:%s, stack:%s\n", node, stack);
			if (null == node.l && null == node.r) {
				System.out.println("lef:" + node);
				node = stack.pop();
			}

			if (null != node.l && !node.l.visited) {
				node = node.l;
				node.visited = true;
				stack.push(node);
			}

			if (null != node.r && !node.r.visited) {
				node = node.r;
				node.visited = true;
				stack.push(node);
			}
		}
		return 0;
	}

	// Iterative method to find height of Bianry Tree
	static int treeHeight(Node node) {
		// Base Case
		if (node == null)
			return 0;

		// Create an empty queue for level order traversal
		Queue<Node> q = new LinkedList<Node>();

		// Enqueue Root and initialize height
		q.add(node);
		int height = 0;

		while (true) {
			// nodeCount (queue size) indicates number of nodes
			// at current level.
			int nodeCount = q.size();
			System.out.printf(" nodeCount:%s\n", nodeCount);
			if (nodeCount == 0)
				return height;
			height++;

			// Dequeue all nodes of current level and Enqueue all
			// nodes of next level
			while (nodeCount > 0) {// at this point we have nodeCount nodes in the queue
				Node newnode = q.poll();

				System.out.printf(">nodeCount:%s, newnode:%s\n", nodeCount, newnode);

				// q.remove();
				if (newnode.l != null)
					q.add(newnode.l);
				if (newnode.r != null)
					q.add(newnode.r);
				nodeCount--;
				System.out.printf("<nodeCount:%s, newnode:%s\n", nodeCount, newnode);
			}

			System.out.println();
		}
	}

	static int treeHeight1(Node node) {

		Queue<Node> queue = new LinkedList<>();

		int height = 1;

		queue.add(node);

		while (true) {

			int currentTraversal = queue.size();
			System.out.printf("height:%s, nodes in this level:%s\n", height, currentTraversal);

			if (0 == currentTraversal) {
				return height - 1;
			}
			while (currentTraversal-- > 0) {
				Node n = queue.poll();
				System.out.printf("Adding children of node:%s\n", n);
				if (null != n.l)
					queue.add(n.l);

				if (null != n.r)
					queue.add(n.r);
			}
			height++;

			System.out.println();
		}
	}
}
