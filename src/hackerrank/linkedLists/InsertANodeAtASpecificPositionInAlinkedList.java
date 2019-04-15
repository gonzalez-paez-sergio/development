package hackerrank.linkedLists;

/**
Insert a node at a specific position in a linked list
*/
public class InsertANodeAtASpecificPositionInAlinkedList {

	public static void main(String[] string) {

		Node head = new Node();
		head.data = 1;
		head.next = new Node();
		head.next.data = 2;
		head.next.next = new Node();
		head.next.next.data = 3;
		head.next.next.next = new Node();
		head.next.next.next.data = 4;

		InsertANodeAtASpecificPositionInAlinkedList m = new InsertANodeAtASpecificPositionInAlinkedList();

		int data = 100;
		int intPosition = 2;
		System.out.println("before inserting [" + head + "]");
		Node result = m.insertNodeAtPosition(head, data, intPosition);
		System.out.println("result [" + result + "]");
		result = m.insertNodeAtPosition(head, data, -10);
		System.out.println("result [" + result + "]");
		result = m.insertNodeAtPosition(null, data, -10);
		System.out.println("result [" + result + "]");
	}

	static Node insertNodeAtPosition(Node head, int data, int intPosition) {
			if (null == head || intPosition < 1){
				head = new Node();
				head.data = data;
			} else if (intPosition == 1) {
				Node n = new Node();
				n.data = data;
				n.next = head.next;
				head.next = n;
			} else {
				insertNodeAtPosition(head, data, --intPosition);
			}
			return head;
	}
}
