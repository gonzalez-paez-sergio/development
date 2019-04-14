package hackerrank.linkedLists;

public class InsertNodeAtTheTail {

  public static void main(String[] string) {

    Node head = new Node();
    head.next = null;
    head.data = 1;

    Node  n = insertNodeAtTailRecursive(head, 2);
    System.out.println(n);


    n = insertNodeAtTailRecursive(head, 4);
    System.out.println(n);


    n = insertNodeAtTailRecursive(head, 5);
    System.out.println(n);
  }

  public static Node insertNodeAtTail(Node head, int data) { 
    Node node = head;
    while (null != node.next){
      node = node.next;
    }

    Node newNode = new Node();
    newNode.data = data;
    node.next = newNode;
    return head;
  }

  public static Node insertNodeAtTailRecursive(Node head, int data) {
    if (null != head.next){
      insertNodeAtTailRecursive( head.next, data);
    } else {
      Node newNode = new Node();
      newNode.data = data;
      head.next = newNode;
    }
    return head;
  }
}
