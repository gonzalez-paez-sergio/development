package algorithms;

import java.util.stream.IntStream;

/**
 * this class will use the value of arr[i] to determine the root of every element, ie, we will use
 * the major element to determine the root
 */
public class SizedUnionFind {

  private int[] arr;
  private int[] size;
  private int components;

  SizedUnionFind(int size) {
    this.components = size;
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
  void connect(int p, int q) {
    // System.out.printf("will union %s and %s\n", p, q);
    if (!connected(p, q)) {
      int rootp = root(p);
      int rootq = root(q);
      // System.out.printf(
      // "root of %s is %s,size:%s, root of %s is %s,size:%s\n",
      // p, rootp, size[rootp], q, rootq, size[rootq]);
      if (rootp < rootq) {
        // p branch is bigger than q branch
        this.arr[rootp] = rootq;
        this.size[rootq] += this.size[rootp];
      } else {
        this.arr[rootq] = rootp;
        this.size[rootp] += this.size[rootq];
      }
      this.components--;
      // } else {
      // System.out.printf("%s, %s are already connected\n", p, q);
    }
  }

  boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  //  public int root(int p) {
  //    // System.out.printf("searching root for:%s, parent:%s\n", p, arr[p]);
  //    if (arr[p] == p) {
  //      return p;
  //    }
  //    //  arr[p] = arr[arr[p]];
  //    return root(arr[p]);
  //  }

  /**
   * Union-find with specific canonical element. Add a method find() to the union-find data type so
   * that find(i) returns the largest element in the connected component containing iii. The
   * operations, union(), connected(), and find() should all take logarithmic time or better.
   *
   * <p>For example, if one of the connected components is {1,2,6,9}\{1, 2, 6, 9\}{1,2,6,9}, then
   * the find() method should return 999 for each of the four elements in the connected components.
   */
  int find(int p) {
    return root(p);
  }

  private int root(int p) {
    int root = p;
    while (root != arr[root]) {
      root = arr[root];
    }

    while (root != arr[p]) {
      arr[p] = root;
    }

    return root;
  }

  void print() {
    IntStream.range(0, arr.length).forEach(i -> System.out.printf("%s ", arr[i]));
    System.out.printf(" : ");
    IntStream.range(0, size.length).forEach(i -> System.out.printf("%s ", size[i]));
    System.out.printf("components %s ", this.components);
    System.out.println();
  }

  public int count() {
    return components;
  }
}
