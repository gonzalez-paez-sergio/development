package hackerrank.tree;

/*
The Node struct is defined as follows:
   struct Node {
      int data;
      Node* left;
      Node* right;
   }
*/

public class IsThisaBinarySearchTree {

	public static void main(String[] string) {

	}

	boolean checkBST(Node root) {

		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean checkBST(Node root, int intMin, int intMax) {
		if (null == root)
			return true;

		if (intMin >= root.data)
			return false;
		if (intMax <= root.data)
			return false;

		return checkBST(root.left, intMin, root.data) && checkBST(root.right, root.data, intMax);
	}

	static class Node {
		int data;
		Node left;
		Node right;
	}

}
