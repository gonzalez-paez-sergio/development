package algorithms;

import org.junit.Test;

public class WeightedUnionFindTest {

  @Test
  public void test2() {
    WeightedUnionFind unionFind = new WeightedUnionFind(10);

    System.out.printf("WeightedUnionFindTest.test2 original: ");
    unionFind.print();
    int p = 0;
    int q = 1;
    unionFind.union(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 1;
    q = 2;
    unionFind.union(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 2;
    q = 3;
    unionFind.union(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 4;
    q = 3;
    unionFind.union(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 4;
    q = 5;
    unionFind.union(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 5;
    q = 6;
    unionFind.union(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 6;
    q = 7;
    unionFind.union(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 7;
    q = 8;
    unionFind.union(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 8;
    q = 9;
    unionFind.union(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 9;
    q = 0;
    unionFind.union(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 0;
    q = 1;
    unionFind.union(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
  }
}
