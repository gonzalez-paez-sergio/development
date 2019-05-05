package algorithms;

import org.junit.Test;

public class UnionFindTest {

  @Test
  public void test() {
    UnionFind unionFind = new UnionFind(10);
    unionFind.union(3, 6);
    unionFind.print();
    unionFind.union(1, 9);
    unionFind.print();
    unionFind.union(1, 6);
    unionFind.print();
    boolean result = unionFind.connected(3, 9);
    System.out.println("unionFind (3,9):" + result);
  }
}
