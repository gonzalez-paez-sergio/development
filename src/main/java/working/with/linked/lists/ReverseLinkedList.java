package working.with.linked.lists;

public class ReverseLinkedList {

  public static Node reverse(Node head) {

    /**
     *
     *
     * <pre>
     *
     *
     *         curr
     *          |
     *          A -> B -> C -> D -> null
     *
     *              next
     *   prev  curr  |
     *     |    |    |
     *          A -> B -> C -> D -> null
     *
     *              next
     *   prev  curr  |
     *     |    |    |
     *       <- A    B -> C -> D -> null
     *
     *              next
     *         curr  |
     *         prev  |
     *          |    |
     *       <- A    B -> C -> D -> null
     *
     *              next
     *              curr
     *         prev  |
     *          |    |
     *       <- A    B -> C -> D -> null
     *
     *                   next
     *              curr  |
     *         prev  |    |
     *          |    |    |
     *       <- A    B -> C -> D -> null
     *
     *
     *                   next
     *              curr  |
     *         prev  |    |
     *          |    |    |
     *       <- A <- B -> C -> D -> null
     *
     *
     *
     *
     * </pre>
     */
    Node prev = null;
    Node current = head;
    Node next = null;

    while (null != current) {
      System.out.printf("1. current:%s, prev:%s, next:%s\n", current, prev, next);
      next = current.next;
      current.next = prev;

      prev = current;
      current = next;
      System.out.printf("2. current:%s, prev:%s, next:%s\n", current, prev, next);
    }

    return prev;
  }

  public static void main(String[] string) {
    Node node = new Node(0);

    node.next = new Node(1);
    node.next.next = new Node(2);
    node.next.next.next = new Node(3);
    node.next.next.next.next = new Node(4);

    System.out.println(reverse(node));
  }

  static class Node {
    private int v;

    Node next;

    public Node(int v) {
      this.v = v;
    }

    public String toString() {
      return "[v:" + this.v + "] ";
    }

    public String toStringDeep() {
      return "[[value:" + this.v + "] " + next + "]";
    }
  }
}
