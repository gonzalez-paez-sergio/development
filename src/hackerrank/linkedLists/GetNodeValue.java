package hackerrank.linkedLists;

public class GetNodeValue {

	public static void main(String[] string) {

		// 1 -> 5 -> 9 -> 11 -> 13 -> 21 -> NULL
		// 8 -> 14 -> 15 -> 18 -> 22 -> 23 -> NULL

		// 1 -> 3 -> 5 -> 6 -> NULL, positionFromTail = 0 ==> 6
		// 1 -> 3 -> 5 -> 6 -> NULL, positionFromTail = 2

		Node headA = new Node();
		headA.data = 1;
		headA.next = new Node();
		headA.next.data = 3;
		headA.next.next = new Node();
		headA.next.next.data = 5;
		headA.next.next.next = new Node();
		headA.next.next.next.data = 6;

		GetNodeValue m = new GetNodeValue();
	//	int intResult = m.GetNodeRecursive(headA, 0);
		//System.out.println("intResult [" + intResult + "]");
		Node node = m.GetNodeRecursive(headA, 2);
		System.out.println("intResult [" + node.data + "]");

	}

	int GetNode(Node head, int n) {
		int intCounter = 0;
		int intPosition = 0;
		Node node = head;
		while (null != node.next) {
			intCounter++;
			node = node.next;
		}
		intPosition = intCounter - n;
		intCounter = 0;
		node = head;
		while (null != node) {
			if (intCounter == intPosition) {
				return node.data;
			}
			intCounter++;
			node = node.next;
		}
		return -1;
	}

	Node GetNodeRecursive(Node head, int n) {

		if (null != head.next) {
			System.out.println("0.intCounter [" + intCounter + "], n[" + n
					+ "], head[" + head.data + "]");
			GetNodeRecursive(head.next, n);
		}

		if (intCounter++ == n) {
			System.out.println("result [" + head.data + "]");
			return head;
		} 

		System.out.println("1.intCounter [" + intCounter + "], n[" + n + "]");

		return null;
	}

	int intCounter = 0;
}
