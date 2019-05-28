package algorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class WeightedUnionFindTest {

  @Test
  public void test2() {
    WeightedUnionFind unionFind = new WeightedUnionFind(10);

    System.out.printf("WeightedUnionFindTest.test2 original: ");
    unionFind.print();
    int p = 0;
    int q = 1;
    unionFind.connect(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 1;
    q = 2;
    unionFind.connect(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 2;
    q = 3;
    unionFind.connect(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 4;
    q = 3;
    unionFind.connect(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 4;
    q = 5;
    unionFind.connect(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 5;
    q = 6;
    unionFind.connect(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 6;
    q = 7;
    unionFind.connect(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 7;
    q = 8;
    unionFind.connect(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 8;
    q = 9;
    unionFind.connect(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 9;
    q = 0;
    unionFind.connect(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
    p = 0;
    q = 1;
    unionFind.connect(p, q);
    System.out.printf("WeightedUnionFindTest.test2 (%s,%s): ", p, q);
    unionFind.print();
  }

  // @Test
  public void testTinyUF() {
    // int N = StdIn.readInt();
    In inn = new In("src/main/resources/algorithms/tinyUF.txt");
    int N = inn.readInt();

    WeightedUnionFind weightedUnionFind = new WeightedUnionFind(N);
    while (!inn.isEmpty()) {
      int p = inn.readInt();
      int q = inn.readInt();
      weightedUnionFind.connect(p, q);
      //     weightedUnionFind.print();
      // System.out.println(p + " " + q);
      // System.out.println(weightedUnionFind.count() + " components");
    }
  }

  // @Test
  public void testMediumUF() {
    // int N = StdIn.readInt();
    In inn = new In("src/main/resources/algorithms/mediumUF.txt");
    int N = inn.readInt();

    WeightedUnionFind weightedUnionFind = new WeightedUnionFind(N);
    while (!inn.isEmpty()) {
      int p = inn.readInt();
      int q = inn.readInt();
      weightedUnionFind.connect(p, q);
      //    weightedUnionFind.print();
      // System.out.println(p + " " + q);
      // System.out.println(weightedUnionFind.count() + " components");
    }
  }

  // @Test
  public void testLargeUF() {
    // int N = StdIn.readInt();
    In inn = new In("src/main/resources/algorithms/largeUF.txt");
    int N = inn.readInt();

    WeightedUnionFind weightedUnionFind = new WeightedUnionFind(N);
    while (!inn.isEmpty()) {
      int p = inn.readInt();
      int q = inn.readInt();
      weightedUnionFind.connect(p, q);
      //   weightedUnionFind.print();
      // System.out.println(p + " " + q);
    }
    System.out.println(weightedUnionFind.count() + " components");
  }

  @Test
  public void testLargeRandomly() {
    // int N = StdIn.readInt();
    int MAX = 1_000_000;
    int[] a = new int[MAX];
    for (int i = 0; i < MAX; i++) a[i] = StdRandom.uniform(0, MAX);

    WeightedUnionFind weightedUnionFind = new WeightedUnionFind(MAX);
    for (int i = 0; i < MAX; i++) {
      int p = StdRandom.uniform(0, MAX);
      int q = StdRandom.uniform(0, MAX);
      weightedUnionFind.connect(p, q);
    }

    System.out.println(weightedUnionFind.count() + " components");
  }
}
