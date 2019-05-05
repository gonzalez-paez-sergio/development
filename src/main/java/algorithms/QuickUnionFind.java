package algorithms;

import java.util.Arrays;

public class QuickUnionFind {
  private int[] arr;
  private int[] size;

  QuickUnionFind(int size) {
    this.size = new int[size];
    this.arr = new int[size];
    for (int i = 0; i < size; i++) {
      this.arr[i] = i;
      this.size[i] = 1;
    }
  }

  //  0 1 2 3 4 5 6 7 8 9
  // |0|1|2|3|4|5|6|7|8|9|

  // connect   5 & 6 means  this.arr[5] = 6
  //  0 1 2 3 4 5 6 7 8 9
  // |0|1|2|3|4|6|6|7|8|9|

  // connect   1 & 7 means  this.arr[1] = 7
  //  0 1 2 3 4 5 6 7 8 9
  // |7|1|2|3|4|6|6|7|8|9|
  void union(int p, int q) {
    if (!connected(p, q)) {
      int rootp = root(p);
      int rootq = root(q);
      this.arr[rootp] = rootq;
      this.size[rootq] += this.size[rootp];
    } else {
      System.out.printf("%s, %s are already connected\n", p, q);
    }
  }

  boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  private int root(int p) {
    // System.out.printf("searching root for:%s, parent:%s\n", p, arr[p]);
    if (arr[p] == p) {
      return p;
    }
    return root(arr[p]);
  }

  void print() {
    Arrays.stream(arr).forEach(i1 -> System.out.printf("%s ", i1));
    System.out.printf(" : ");
    Arrays.stream(size).forEach(i1 -> System.out.printf("%s ", i1));
    System.out.println();
  }
}
