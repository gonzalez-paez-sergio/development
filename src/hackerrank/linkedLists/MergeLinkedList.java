package hackerrank.linkedLists;

public class MergeLinkedList {

	public static void main(String[] string) {

		// 1 -> 5 -> 9 -> 11 -> 13 -> 21 -> NULL
		// 8 -> 14 -> 15 -> 18 -> 22 -> 23 -> NULL

		Node headA = new Node();
		headA.data = 1;
		headA.next = new Node();
		headA.next.data = 5;
		headA.next.next = new Node();
		headA.next.next.data = 9;

		Node headB = new Node();
		headB.data = 8;
		headB.next = new Node();
		headB.next.data = 14;

		MergeLinkedList m = new MergeLinkedList();
		Node node = m.mergeListRecursive(headA, headB);
		print(node);
		
		System.out.println("--");
		// 1 -> 3 -> 5 -> 6 -> NULL
		// 2 -> 4 -> 7 -> NULL

		headA = new Node();
		headA.data = 1;
		headA.next = new Node();
		headA.next.data = 3;
		headA.next.next = new Node();
		headA.next.next.data = 5;
		headA.next.next.next = new Node();
		headA.next.next.next.data = 6;

		headB = new Node();
		headB.data = 2;
		headB.next = new Node();
		headB.next.data = 4;
		headB.next.next = new Node();
		headB.next.next.data = 7;

		m = new MergeLinkedList();
		node = m.mergeListRecursive(headA, headB);
		print(node);

		headA = new Node();
		headA.data = 15;
		headB = new Node();
		headB.data = 12;

		m = new MergeLinkedList();
		node = m.mergeListRecursive(headA, headB);
		print(node);
	}

	private static void print(Node node) {
		while (null != node) {
			System.out.print(node.data + " ");
			node = node.next;

		}

		System.out.println();
	}

	Node MergeLists(Node headA, Node headB) {
		// This is a "method-only" submission.
		// You only need to complete this method

		Node nodeA = headA;
		Node nodeB = headB;
		Node nodePA = new Node();
		nodePA.next = nodeA;
		Node nodePB = new Node();
		nodePB.next = nodeA;

		while (null != nodeB) {
			if (null == nodeA && null != nodeB) {
				nodePB = nodeB;
				nodeB = nodeB.next;
				nodePA.next = nodePB;
				nodePB.next = nodeA;
			} else if (nodeA.data >= nodeB.data) {
				nodePB = nodeB;
				nodeB = nodeB.next;
				nodePA.next = nodePB;
				nodePB.next = nodeA;
			} else {
				nodePA = nodeA;
				nodeA = nodeA.next;
			}
			// print(headA);
		}

		return headA;
	}

	Node mergeList(Node h1, Node h2) {
		if (h1 == null)
			return h2;
		if (h2 == null)
			return h1;
		Node head;
		if (h1.data < h2.data) {
			head = h1;
		} else {
			head = h2;
			h2 = h1;
			h1 = head;
		}

		while (h1.next != null && h2 != null) {
			if (h1.next.data < h2.data) {
				h1 = h1.next;
			} else {
				Node afterh2 = h2.next;
				Node afterh1 = h1.next;
				h1.next = h2;
				h2.next = afterh1;

				if (h2.next != null) {
					h2 = afterh2;
				}
			}
		}
		return head;
	}

	Node mergeListRecursive(Node headA, Node headB) {
//		System.out.println(headA.data + "," + headB.data + " - " + headA.next + "," + headB.next);
		if (headA == null)
			return headB;
		if (headB == null)
			return headA;

		if (headA.data < headB.data) {
			headA.next = mergeListRecursive(headA.next, headB);
			return headA;
		} else {
			headB.next = mergeListRecursive(headB.next, headA);
			return headB;
		}
	}
}
