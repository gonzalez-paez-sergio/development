package hackerrank.tree;

public class LowestCommonAncestor {
	/*
	 * Node is defined as : class Node int data; Node left; Node right;
	 */

	static Node lca(Node node, int v1, int v2) {

		if (null == node) {
			// System.out.println("returning null");
			return null;
		}

		// System.out.printf("curent node %s, left %s\n", node.data, node.left);
		if (node.data == v1 || node.data == v2) {
			return node;
		}

		Node nodeLeft = lca(node.left, v1, v2);
		Node nodeRight = lca(node.right, v1, v2);

		if (null != nodeLeft && null != nodeRight) {
			return node;
		} else if (null != nodeLeft) {
			return nodeLeft;
		} else {
			return nodeRight;
		}
	}

}