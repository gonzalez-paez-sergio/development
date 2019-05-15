package algorithms;

import org.junit.Test;

public class SizedUnionFindTest {

  @Test
  public void test2() {
    SizedUnionFind unionFind = new SizedUnionFind(10);

    System.out.printf("SizedUnionFind.test2 original: \n");
    unionFind.print();
    int p = 1;
    int q = 2;
    unionFind.connect(p, q);
    System.out.printf("SizedUnionFind.test2 (%s,%s)\n", p, q);
    System.out.printf("SizedUnionFind.test2 find %s:%s: \n", p, unionFind.find(p));
    System.out.printf("SizedUnionFind.test2 find %s:%s: \n", q, unionFind.find(q));
    p = 6;
    q = 9;
    unionFind.connect(p, q);
    System.out.printf("SizedUnionFind.test2 (%s,%s)\n", p, q);
    System.out.printf("SizedUnionFind.test2 find %s:%s: \n", p, unionFind.find(p));
    System.out.printf("SizedUnionFind.test2 find %s:%s: \n", q, unionFind.find(q));
    p = 2;
    q = 6;
    unionFind.connect(p, q);
    System.out.printf("SizedUnionFind.test2 (%s,%s)\n", p, q);
    System.out.printf("SizedUnionFind.test2 find %s:%s: \n", p, unionFind.find(p));
    System.out.printf("SizedUnionFind.test2 find %s:%s: \n", q, unionFind.find(q));
  }
}
