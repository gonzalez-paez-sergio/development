package algorithms;

import edu.princeton.cs.algs4.StdRandom;

public class Percolation {
  private int size;
  private boolean[] grid;
  private WeightedUnionFind wuf;
  private int numberOfOpenSites;

  Percolation(int n) {
    this.size = n;
    // create n-by-n grid, with all sites blocked
    this.grid = new boolean[n * n + 2];
    this.wuf = new WeightedUnionFind(n * n + 2);
  }

  void open(int row, int col) { // open site (row, col) if it is not open already
    if (!isOpen(row, col)) {
      int pos = size * row + col;
      this.grid[pos] = true;
      this.numberOfOpenSites++;
      connectOpenedN(row, col);
    }
  }

  private void connectOpenedN(int row, int col) { // open site (row, col) if it is not open already
    if (row == 0) {
      this.connectTop(row, col);
    } else {
      this.connect(row, col, row - 1, col);
    }

    if (row == size - 1) {
      this.connectBottom(row, col);
    } else {
      this.connect(row, col, row + 1, col);
    }

    this.connect(row, col, row, col - 1);
    this.connect(row, col, row, col + 1);
  }

  void connect(
      int row, int col, int row1, int col1) { // open site (row, col) if it is not open already
    if (0 <= row
        && row < size
        && 0 <= col
        && col < size
        && 0 <= row1
        && row1 < size
        && 0 <= col1
        && col1 < size
        && isOpen(row, col)
        && isOpen(row1, col1)) {
      int pos = size * row + col;
      int pos1 = size * row1 + col1;
      this.wuf.connect(pos, pos1);
    }
  }

  void connectTop(int row, int col) { // open site (row, col) if it is not open already
    if (0 <= row && row < size && 0 <= col && col < size && isOpen(row, col)) {
      int pos = size * row + col;
      this.wuf.connect(pos, size * size);
    }
  }

  void connectBottom(int row, int col) { // open site (row, col) if it is not open already
    if (0 <= row && row < size && 0 <= col && col < size && isOpen(row, col)) {
      int pos = size * row + col;
      this.wuf.connect(pos, size * size + 1);
    }
  }

  private boolean isOpen(int row, int col) { // is site (row, col) open?
    int pos = size * row + col;
    return this.grid[pos];
  }

  boolean isFull(int row, int col) { // is site (row, col) full?
    int top = size * size;
    int pos = size * row + col;
    return wuf.connected(top, pos);
  }

  public int numberOfOpenSites() { // number of open sites
    return this.numberOfOpenSites;
  }

  boolean percolates() { // does the system percolate?
    int top = size * size;
    int bottom = size * size + 1;
    return wuf.connected(top, bottom);
  }

  public static void main(String[] args) { // test client (optional)
    int size = 100;
    Percolation percolation = new Percolation(size);
    while (!percolation.percolates()) {
      int row = StdRandom.uniform(0, size);
      int col = StdRandom.uniform(0, size);
      percolation.open(row, col);
      // System.out.println(
      //     "number of open sites ["
      //         + percolation.numberOfOpenSites()
      //         + "]["
      //         + (percolation.numberOfOpenSites() * 100) / (size * size)
      //         + "]");
    }
    System.out.println(
        "number of open sites ["
            + percolation.numberOfOpenSites()
            + "]["
            + (percolation.numberOfOpenSites() * 100) / (size * size)
            + "]");
  }
}

// size * size - 100
// nos         - x
