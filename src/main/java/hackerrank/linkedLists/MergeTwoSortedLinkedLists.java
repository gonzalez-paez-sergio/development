package hackerrank.linkedLists;

/** Merge two sorted linked lists */
public class MergeTwoSortedLinkedLists {

  public static void main(String[] args) {
    Node nodeA = new Node();
    nodeA.data = 1;
    nodeA.next = new Node();
    nodeA.next.data = 2;
    nodeA.next.next = new Node();
    nodeA.next.next.data = 3;
    nodeA.next.next.next = new Node();
    nodeA.next.next.next.data = 4;

    Node nodeB = new Node();
    nodeB.data = 2;
    Node nodeC = new Node();
    nodeC.data = 2333;

    merge(nodeA, nodeB);
    System.out.println("nodeA:" + nodeA);
    System.out.println("nodeB:" + nodeB);

    merge(nodeA, nodeC);
    System.out.println("nodeA:" + nodeA);
    System.out.println("nodeC:" + nodeC);
  }

  public static Node merge(Node nodeA, Node nodeB) {

    if (nodeA == null) {
      return nodeB;
    }
    if (nodeB == null) {
      return nodeA;
    }

    if (nodeA.data < nodeB.data) {
      nodeA.next = merge(nodeA.next, nodeB);
      return nodeA;
    } else {
      nodeB.next = merge(nodeA, nodeB.next);
      ;
      return nodeB;
    }
  }
}
