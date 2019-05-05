package algorithms;

import java.util.stream.IntStream;

public class UnionFind {

  private int[] arr;

  UnionFind(int size) {
    this.arr = new int[size];
    for (int i = 0; i < size; i++) {
      this.arr[i] = i;
    }
  }

  void union(int p, int q) {
    if (!connected(p, q)) {
      int arrp = arr[p];
      for (int i = 0; i < arr.length; i++) {
        if (arrp == arr[i]) {
          arr[i] = arr[q];
        }
      }
    }
  }

  boolean connected(int p, int q) {
    return this.arr[p] == this.arr[q];
  }

  public void print() {
    IntStream.range(0, arr.length).forEach(i -> System.out.printf("%s ", arr[i]));
    System.out.println();
  }
}
