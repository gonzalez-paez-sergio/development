package algorithms;

import org.junit.Test;

public class QuickUnionFindTest {

  @Test
  public void test() {
    QuickUnionFind unionFind = new QuickUnionFind(10);
    unionFind.union(3, 6);
    System.out.printf("QuickUnionFindTest.test (3,6): ");
    unionFind.print();

    unionFind.union(1, 7);
    System.out.printf("QuickUnionFindTest.test (1,7): ");
    unionFind.print();
    unionFind.union(7, 3);
    System.out.printf("QuickUnionFindTest.test (7,3): ");
    unionFind.print();
    unionFind.union(4, 5);
    System.out.printf("QuickUnionFindTest.testestt1 (4,5): ");
    unionFind.print();
    boolean result = unionFind.connected(5, 6);
    System.out.println("QuickUnionFindTest.test (5,6):" + result);
  }

  @Test
  public void test1() {
    QuickUnionFind unionFind = new QuickUnionFind(10);
    unionFind.union(3, 6);
    System.out.printf("QuickUnionFindTest.test1 (3,6): ");
    unionFind.print();
    unionFind.union(1, 7);
    System.out.printf("QuickUnionFindTest.test1 (1,7): ");
    unionFind.print();
    unionFind.union(7, 3);
    System.out.printf("QuickUnionFindTest.test1 (7,3): ");
    unionFind.print();
    unionFind.union(4, 5);
    System.out.printf("QuickUnionFindTest.test1 (4,5): ");
    unionFind.print();
    unionFind.union(6, 4);
    System.out.printf("QuickUnionFindTest.test1 (6,4): ");
    unionFind.print();
    boolean result = unionFind.connected(5, 6);
    System.out.println("QuickUnionFindTest (5,6):" + result);
  }

  @Test
  public void test2() {
    QuickUnionFind unionFind = new QuickUnionFind(10);

    System.out.printf("QuickUnionFindTest.test2 original: ");
    unionFind.print();
    int p = 0;
    int q = 1;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 1;
    q = 2;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 2;
    q = 3;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 3;
    q = 4;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 4;
    q = 5;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 5;
    q = 6;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 6;
    q = 7;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 7;
    q = 8;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 8;
    q = 9;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 9;
    q = 0;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 0;
    q = 1;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
  }

  @Test
  public void test3() {
    QuickUnionFind unionFind = new QuickUnionFind(10);

    System.out.printf("QuickUnionFindTest.test3 original: ");
    unionFind.print();
    int p = 0;
    int q = 1;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test3 (%s,%s): ", p, q);
    unionFind.print();
    p = 2;
    q = 0;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test3 (%s,%s): ", p, q);
    unionFind.print();
    p = 3;
    q = 0;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test3 (%s,%s): ", p, q);
    unionFind.print();
    p = 0;
    q = 4;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test3 (%s,%s): ", p, q);
    unionFind.print();
    p = 0;
    q = 5;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test3 (%s,%s): ", p, q);
    unionFind.print();
    p = 0;
    q = 6;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test3 (%s,%s): ", p, q);
    unionFind.print();
    p = 0;
    q = 7;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test3 (%s,%s): ", p, q);
    unionFind.print();
    p = 0;
    q = 8;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test3 (%s,%s): ", p, q);
    unionFind.print();
    p = 0;
    q = 9;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test3 (%s,%s): ", p, q);
    unionFind.print();
    p = 0;
    q = 0;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test3 (%s,%s): ", p, q);
    unionFind.print();
    p = 0;
    q = 1;
    unionFind.union(p, q);
    System.out.printf("QuickUnionFindTest.test3 (%s,%s): ", p, q);
    unionFind.print();
  }
}
