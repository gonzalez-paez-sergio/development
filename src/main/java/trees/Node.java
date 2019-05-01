package trees;

public class Node {
  public int v;
  public Node l;
  public Node r;
  public boolean visited;

  public Node(int value) {
    this.v = value;
  }

  @Override
  public String toString() {

    return "value:" + this.v

    // ((null != this.left) ? (",left.value:" + this.left.value) : "") +
    //
    // ((null != this.right) ? (",right.value:" + this.right.value) : "")

    ;
  }
}
